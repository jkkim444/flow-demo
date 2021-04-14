/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1070.java
 * @brief Batch Management Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief FW Service Package
 */
package com.encocns.fw.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW1070DAO;
import com.encocns.fw.dto.FW107001DTO;
import com.encocns.fw.service.svo.FW107001IN;
import com.encocns.fw.service.svo.FW107001OUT;
import com.encocns.fw.service.svo.FW107002IN;
import com.encocns.fw.service.svo.FW107002OUT;
import com.encocns.fw.service.svo.FW107003IN;
import com.encocns.fw.service.svo.FW107003OUT;

/**
 * @brief 배치 그룹 상세 관리 Service
 * @details 배치 그룹 상세 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW1070 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FW1070.class);

    @Value("#{globalContext}")
    private Properties globalContextProp;

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private FW1070DAO daoFW1070;

    @Resource(name = "txManagerIFRS")
    protected DataSourceTransactionManager txManagerCore;


    /**
     * @brief 배치그룹상세 조회
     * @details 배치그룹상세 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW107001IN
     * @return FW107001OUT
     */
    public FW107001OUT selectBatDtl( FW107001IN inService ) throws EnfraBusinessException
    {
        ArrayList<FW107001DTO> arrList = daoFW1070.selectBatDtl(inService);

        //Instance OSVO
        FW107001OUT outService = new FW107001OUT();
        outService.setArrList(arrList);

        return outService;
    }

    /**
     * @brief 배치 그룹 상세 등록 및 수정
     * @details 배치 그룹 상세 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW107002IN
     * @return FW107002OUT
     */
    public FW107002OUT mergeBatDtl( FW107002IN inService )
    {
        //Instance OSVO
        FW107002OUT outService = new FW107002OUT();

        ArrayList<FW107001DTO> batList = inService.getArrList();

        int iResult = 0;
        if(batList!=null && batList.size()>0) {
        	for( FW107001DTO bat : batList ) {

        		bat.setGrpId(inService.getGrpId());
        		bat.setUsrId(serviceComponent.getSessionVO().getUserId());

        		if( ServiceConst.GRID_DELETE.equals(bat.getJob()) ) {
        			iResult += daoFW1070.deleteBatDtl(bat);
        		}
        		else
        		{
        			iResult += daoFW1070.mergeBatDtl(bat);
        		}
        	}//end for
        }//if

        outService.setiResult(iResult);

        return outService;
    }



    /**
     * @brief 배치 작업 내용 기록
     * @details 배치 작업 내용 기록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW107003IN
     * @return FW107003OUT
     */
    public FW107003OUT executeBatch( FW107003IN inService ) throws Exception
    {
        //Instance OSVO
    	FW107003OUT outService = new FW107003OUT();

        ArrayList<FW107001DTO> batList = inService.getArrList();
        //grup instance id 채번 ( GRP_ID + 현재날짜 )
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String strTime = dayTime.format(new Date(time));

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus txStatus = txManagerCore.getTransaction(def);

        try {

            if(batList!=null && batList.size()>0) {

                String prjDir = globalContextProp.getProperty("PROJECT_PATH");

                String grpInsId = batList.get(0).getGrpId()+"_"+strTime;
                String shellName = prjDir +  "/bat_exe/" + grpInsId+".sh";

                File file = new File(shellName);
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                pw.println("#!/bin/bash");
                pw.println("cd "+ prjDir + "/DBSAVINGBat_IFR");

                int i=1;

            	for( FW107001DTO bat : batList ) {
            		bat.setGrpInstanceId(grpInsId);
            		bat.setUsrId(serviceComponent.getSessionVO().getUserId());
            		daoFW1070.insertBatExeMapp(bat);

            		String pre = "sh ./runJob.sh ";
            		String batExeParam = "/"+bat.getBatPath().substring(0,bat.getBatPath().lastIndexOf(".")+1).replaceAll("\\.", "/").replace("/job", "/base");
            		String jobXml = "";

            		String exe = "";

            		//write file
            		//required parameter jobid, seq, grpinstanceid
            		if( "2".equals(bat.getBizLclsCd()) ) {
            		    jobXml = "job-IP.xml";
            		}
            		else if( "3".equals(bat.getBizLclsCd()) ) {
            		    jobXml = "job-ID.xml";
                    }
            		else if( "5".equals(bat.getBizLclsCd()) ) {
            		    jobXml = "job-IA.xml";
                    }
            		else if( "8".equals(bat.getBizLclsCd()) ) {
            		    jobXml = "job-CO.xml";
                    }

            		exe = pre + batExeParam + jobXml + " " + bat.getBatId() + " " + bat.getBatParam().replaceAll("&", " ");
            		exe += ( " GRP_INSTANCE_ID=" + grpInsId + " " + "SEQ="+bat.getSeq() );

            	    pw.println(exe);

            	    if( i<batList.size() ) {
            	        pw.println("if [ $? -eq 0 ]");
            	        pw.println("then");
            	    }

            	    i++;
            	}//end for

            	pw.print("fi");

            	pw.close();

            	txManagerCore.commit(txStatus);

            	if(System.getProperty("os.name").indexOf("Windows") < 0) {
            	    //set auth
            	    exeShell("chmod 700 "+  shellName);
            	    //run shell
            	    exeShell( "nohup sh "+ shellName + " &");
            	}

            }//if
            else {
                txManagerCore.commit(txStatus);
            }

        } catch (IOException e) {
//            e.printStackTrace();
            txManagerCore.rollback(txStatus);
        } catch ( Exception e ) {
            txManagerCore.rollback(txStatus);
        }

        int iResult = 0;
        outService.setiResult(iResult);

        return outService;
    }

    private void exeShell( String cmd ) throws Exception {
        DefaultExecutor excutor = new DefaultExecutor();
        CommandLine cmdLine = CommandLine.parse(cmd);
//        CommandLine cmdLine = CommandLine.parse("nohup sh /home/ifrs/apps/DBSAVINGBat_IFR/runJob.sh /com/encocns/ifrs/co/base/job-CO.xml BIFC0000001 baseDt1=20200910 baseDt2=20200910 &);


        excutor.execute(cmdLine, new DefaultExecuteResultHandler());
    }

}


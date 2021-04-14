/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file BIFC0000005.java
 * @brief
 * \~english Batch template5
 * \~korean Batch template5
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 11. 7. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.job
 * @brief Common Job Package
 */
package com.encocns.ifrs.co.job;

import java.util.List;

import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.encocns.enfra.batch.core.item.database.EnfraItemReader;
import com.encocns.enfra.batch.core.item.file.EnfraFileWriterConfig;
import com.encocns.enfra.batch.core.item.file.EnfraItemFileWriter;
import com.encocns.enfra.batch.core.listener.repository.EnfraJobRepository;
import com.encocns.enfra.batch.core.tasklet.EnfraTasklet;

import com.encocns.ifrs.co.bvo.BIFC000000101IN;
import com.encocns.ifrs.co.dto.BIFC000000101DTO;
import com.encocns.ifrs.co.util.CommonUtil;

/**
 * @brief
 * \~english Batch template5
 * \~korean Batch template5
 * @details 
 * <pre>
 * Example of querying DB table data to write a file.
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 11. 7.
 * @version : 1.0.0
 */
public class BIFC0000005 extends EnfraTasklet {

    @Autowired
    private CommonUtil commonUtil;
    
    @Override
    public RepeatStatus execute(EnfraJobRepository jobRepository) throws Exception {
        
        // //////////////////////////////////////////////////////////////////////////////
        // @Step 1. Base Variables and Default Settings
        // //////////////////////////////////////////////////////////////////////////////
        
        EnfraItemReader<?> reader = this.getReader();
        EnfraFileWriterConfig config = new EnfraFileWriterConfig();
        
//        String currentDate = new DateFormatter("yyyyMMddHHmmssSS").print(new Date(), LocaleContextHolder.getLocale());
//        StringBuilder sb = new StringBuilder();
//        sb.append("/test/test_").append(currentDate).append(".txt");
//        config.setOutputResourceFullPath(sb.toString());
        
        // Configuration Option #1 : Output Resource Path Settings
        StringBuilder sbPath = new StringBuilder();
        String sInterfaceName = "TRDATAIFRS9.20191031";
        
        sbPath.append(commonUtil.getFileWriterOutputDir())
              .append(sInterfaceName);
        
        config.setOutputResourceFullPath(sbPath.toString()); // Configuration Option #1 : FileWriter Output Dir + Filename SET
        config.setBeanNames(BIFC000000101DTO.class);         // Configuration Option #2 : Output DTO Object SET
        config.setDelimiter(";");                            // Configuration Option #3 : Delimiter SET(Default : ; - semicolon)
        config.setHeaderCopy(true);                          // Configuration Option #4 : Header Copy SET(Default : false)
        config.setAppendAllowed(false);                      // Configuration Option #5 : Append Allowed SET(Default : false)
        
        EnfraItemFileWriter writer = this.getFileWriter(config);
        
        BIFC000000101IN inParam = new BIFC000000101IN();
       
        // //////////////////////////////////////////////////////////////////////////////
        // @Step 2. Business Logic
        // //////////////////////////////////////////////////////////////////////////////
        
        List<BIFC000000101DTO> list = reader.selectList("BIFC0000001.selectUserList", inParam);
        
        // Write a file to all the lists.(다건 처리)
        writer.writeAll(list);
        
//        BIFC000000101DTO dtoTest = new BIFC000000101DTO();
//        dtoTest.setUsrId("tester");
//        dtoTest.setBrnCd("1");
//        dtoTest.setPasswd("1234");
//        
        // For one row case, use the write() method. (단건 처리)
//        writer.write(dtoTest);
       
        return RepeatStatus.FINISHED;
    }

}

/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EnfraTasklet.java
 * @brief Core Tasklet
 */
/**
 * @namespace com.encocns.enfra.batch.core.tasklet
 * @brief Core Item Database Tasklet Package
 */
package com.encocns.enfra.batch.core.tasklet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.encocns.enfra.batch.core.consts.BatchConsts;
import com.encocns.enfra.batch.core.item.database.EnfraItemReader;
import com.encocns.enfra.batch.core.item.database.EnfraItemWriter;
import com.encocns.enfra.batch.core.item.database.EnfraSqlSessionTemplate;
import com.encocns.enfra.batch.core.item.file.EnfraFileWriterConfig;
import com.encocns.enfra.batch.core.item.file.EnfraItemFileWriter;
import com.encocns.enfra.batch.core.listener.repository.EnfraJobRepository;
import com.encocns.enfra.batch.exception.EnfraBusinessException;

/**
 * @brief Core Tasklet
 * @details Core Tasklet이다.
 * @author : joy
 * @date : 2018. 2. 26.
 * @version : 1.0.0
 */
public abstract class EnfraTasklet implements Tasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnfraTasklet.class);
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private EnfraSqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    private EnfraSqlSessionTemplate sqlSessionTemplate_BATCH;
    
    private DataSource dataSource;
    
    private EnfraItemReader<?> enfraItemReader;
    private EnfraItemWriter enfraItemWriter;
    
    private EnfraItemFileWriter enfraItemFileWriter;
    
    private Map<String, String> stepParameter;
    private Map<String, String> coreStepParameter;
    
    private EnfraJobRepository enfraJobRepository;
    
    private String exceptionStackTrace = " ";
    
    private DataSourceTransactionManager txManager;
    
    private TransactionStatus txStatus;
    
    private int commitCount = 1;
    private int defautCommitInterval = BatchConsts.DEFAULT_COMMIT_INTERVAL;
    private int commitInterval = BatchConsts.DEFAULT_COMMIT_INTERVAL;
    
    public EnfraTasklet() {
    }
    
    /**
     * @brief Execute Method
     * @details Execute Method이다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @param stepContribution
     * @param chunkContext
     * @return RepeatStatus
     * @throws Exception
     */
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        try {
            //initRepository
            enfraJobRepository.init(chunkContext, coreStepParameter, stepParameter);
            
            Properties commonProperties = (Properties)applicationContext.getBean("common");
            
            LocaleContextHolder.setLocale(LocaleUtils.toLocale(commonProperties.getProperty("DEFAULT_LOCALE").toString()));
            
            JobParameters jobParameters = enfraJobRepository.getJobParameter();
            
            Iterator<Entry<String, JobParameter>> it = jobParameters.getParameters().entrySet().iterator(); 
            
            boolean isParameterExist = false;
            
            boolean isRollBack = false;
            while(it.hasNext()) {
                Entry<String, JobParameter> entryParam = (Entry<String, JobParameter>)it.next();
                
                if( entryParam.getKey().equals("isRollBack") ) {
                    if( "true".equals(entryParam.getValue().toString())) {
                        isRollBack = true;
                    }
                }
                
                else if(!entryParam.getKey().equals("timestamp") && !entryParam.getKey().equals("jobName")) {
                    isParameterExist = true;
                    
                    if (jobParameters.getParameters().containsKey(entryParam.getKey()) && "".equals(jobParameters.getString(entryParam.getKey()))) {
                        throw new EnfraBusinessException("E000003", "[Key:" + entryParam.getKey() + " Value:" + entryParam.getValue() + "] Invalid parameter.");
                    } else {
                        if(entryParam.getKey().toUpperCase().endsWith("DT")) {
                            if (!isValidDate(jobParameters.getString(entryParam.getKey()), "yyyyMMdd")) {
                                throw new EnfraBusinessException("E000003", "[Key:" + entryParam.getKey() + " Value:" + entryParam.getValue() + "] Invalid parameter.");
                            }
                        }
                        
                        if(entryParam.getKey().toUpperCase().endsWith("YM")) {
                            if (!isValidDate(jobParameters.getString(entryParam.getKey()), "yyyyMM")) {
                                throw new EnfraBusinessException("E000003", "[Key:" + entryParam.getKey() + " Value:" + entryParam.getValue() + "] Invalid parameter.");
                            }
                        }
                    }
                }
            }
            
            if(!isParameterExist) {
                throw new EnfraBusinessException("E000003", "JobParameters are required.");
            }
            
            try {
                insertBatExeMapp();
                execute(enfraJobRepository);
            } catch(Exception e) {
                e.printStackTrace();
              
                if(this.getTxStatus() != null && !this.getTxStatus().isCompleted()) {
                    this.getTxManager().rollback(this.getTxStatus());
                }
                throw e;
            } finally {
                if( isRollBack && !this.getTxStatus().isCompleted() ) {
                    this.getTxManager().rollback(this.getTxStatus());
                    return RepeatStatus.FINISHED;
                }
                else if(this.getTxStatus() != null && !this.getTxStatus().isCompleted()) {
                    this.getTxManager().commit(this.getTxStatus());
                }
            }
            
            BigDecimal selectCount = BigDecimal.ZERO;
            BigDecimal insertCount = BigDecimal.ZERO;
            BigDecimal updateCount = BigDecimal.ZERO;
            BigDecimal deleteCount = BigDecimal.ZERO;
            
            selectCount = selectCount.add(sqlSessionTemplate.getSelectCount().abs());
            insertCount = insertCount.add(sqlSessionTemplate.getInsertCount().abs());
            updateCount = updateCount.add(sqlSessionTemplate.getUpdateCount().abs());
            deleteCount = deleteCount.add(sqlSessionTemplate.getDeleteCount().abs());
            
            selectCount = selectCount.add(sqlSessionTemplate_BATCH.getSelectCount().abs());
            insertCount = insertCount.add(sqlSessionTemplate_BATCH.getInsertCount().abs());
            updateCount = updateCount.add(sqlSessionTemplate_BATCH.getUpdateCount().abs());
            deleteCount = deleteCount.add(sqlSessionTemplate_BATCH.getDeleteCount().abs());
                
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("##### Select : {}, Insert : {}, Update : {}, Delete : {}",
                                   selectCount, insertCount, updateCount, deleteCount);
            }

            BigDecimal executionCount = insertCount.add(updateCount).add(deleteCount);
        
            // JFlow Log 출력
            printJFLowLog(enfraJobRepository.getJobName(), executionCount, executionCount, BigDecimal.ZERO, BigDecimal.ZERO, "", "");
            
            // STEP_LOG 저장
            this.insertLog();
            
            sqlSessionTemplate.setAllCount(BigDecimal.ZERO);
            sqlSessionTemplate_BATCH.setAllCount(BigDecimal.ZERO);
            
        } catch(Exception e) {
            String sExceptionStackTrace = ExceptionUtils.getStackTrace(e);
            
            if(getByteLength(sExceptionStackTrace, "UTF-8") > 4000) {
                sExceptionStackTrace = getByteString(sExceptionStackTrace, "UTF-8", 0, 4000);
            }
            
            // JFlow Log 출력
            printJFLowLog(enfraJobRepository.getJobName(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "E000003", sExceptionStackTrace);
            
            this.exceptionStackTrace = sExceptionStackTrace;
            
            this.localRollback();
            
            this.insertLog();
            
            sqlSessionTemplate.setAllCount(BigDecimal.ZERO);
            sqlSessionTemplate_BATCH.setAllCount(BigDecimal.ZERO);
            
            throw e;
        }
        
        return RepeatStatus.FINISHED;
    }
    
    public abstract RepeatStatus execute(EnfraJobRepository jobRepository) throws Exception;
    
    /**
     * @brief Transaction Manager SET
     * @details Transaction Manager를 SET한다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @param txManager
     */
    public void setTxManager(DataSourceTransactionManager txManager) {
        this.txManager = txManager;
        
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        this.setTxStatus(txManager.getTransaction(def));
    }
    
    /**
     * @brief Transaction Manager GET
     * @details Transaction Manager를 GET한다. 
     * @author : joy
     * @date : 2018. 3. 14.
     * @return DataSourceTransactionManager
     */
    public DataSourceTransactionManager getTxManager() {
        return txManager;
    }
    
    public EnfraItemReader<?> getReader() {
        return this.getReader(false);
    }

    /**
     * @brief EnfraReader GET
     * @details EnfraReader를 GET한다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @return EnfraItemReader<?>
     */
    public EnfraItemReader<?> getReader(boolean isBatch) {
        EnfraSqlSessionTemplate bs;
        
        if(isBatch) {
            bs = sqlSessionTemplate_BATCH;
        } else {
            bs = sqlSessionTemplate;
        }
        
        SqlSessionFactory sf  = bs.getSqlSessionFactory();
        
//        if( enfraItemReader!=null ) {
//            throw new EnfraCoreException("CE0008");
//        }
        
        enfraItemReader = new EnfraItemReader<>();
        
        enfraItemReader.setSqlSessionFactory(sf);
        enfraItemReader.setSqlSessionTemplate(bs);
        
        return enfraItemReader;
    }
    
    /**
     * @brief EnfraWriter GET
     * @details EnfraWriter를 GET한다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @return EnfraItemWriter
     */
    public EnfraItemWriter getWriter() {
        return this.getWriter(false);
    }
    
    /**
     * @brief EnfraWriter GET
     * @details EnfraWriter를 GET한다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @return EnfraItemWriter
     */
    public EnfraItemWriter getWriter(boolean isBatch) {
        EnfraSqlSessionTemplate bs;
        
        if(isBatch) {
            bs = sqlSessionTemplate_BATCH;
        } else {
            bs = sqlSessionTemplate;
        }
        
        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("EnfraItemWriter.getWriter() > ExecutorType : " + bs.getExecutorType());
        }
        
        enfraItemWriter = new EnfraItemWriter();
        enfraItemWriter.setSqlSessionTemplate(bs);
        
        return enfraItemWriter;
    }
    
    // TODO : File Writer Create! 
    public EnfraItemFileWriter getFileWriter(EnfraFileWriterConfig config) {
        
        enfraItemFileWriter = new EnfraItemFileWriter(config);
        
        return enfraItemFileWriter;
    }
    
    /**
     * @brief Step Parameter SET
     * @details Step Parameter를 SET한다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @param stepParameter
     */
    public void setStepParameter(Map<String, String> stepParameter) {
        this.stepParameter = stepParameter;
    }
    
    /**
     * @brief EnfraJobRepository SET
     * @details EnfraJobRepository를 SET한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param enfraJobRepository
     */
    public void setEnfraJobRepository(EnfraJobRepository enfraJobRepository) {
        this.enfraJobRepository = enfraJobRepository;
    }
    
    /**
     * @brief Core Step Parameter SET
     * @details Core Step Parameter를 SET한다. 
     * @author : joy
     * @date : 2018. 2. 26.
     * @param coreStepParameter
     */
    public void setCoreStepParameter(Map<String, String> coreStepParameter) {
        this.coreStepParameter = coreStepParameter;
    }

    /**
     * @brief Byte Length Getter
     * @details Byte Length Getter 이다.
     * @author : joy
     * @date : 2017. 2. 9.
     * @param str
     * @param charset
     * @return int Byte Length
     */
    private int getByteLength(String str, String charset) {
        int strLength = 0;

        ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();

        try {
            requestOutputStream.write(str.getBytes(charset));
            strLength = requestOutputStream.size();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strLength;
    }

    /**
     * @brief Byte String Cut
     * @details Byte String Cutter이다.
     * @author : joy
     * @date : 2017. 2. 9.
     * @param s 대상 문자열
     * @param charset 캐릭터셋
     * @param startIdx 시작 위치
     * @param bytes Cut Byte
     * @return String Result
     */
    private String getByteString(String s, String charset, int startIdx, int bytes) {
        ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();

        try {
            requestOutputStream.write(s.getBytes(charset));
            return new String(requestOutputStream.toByteArray(), startIdx, bytes, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }
    
    /**
     * @brief 스텝로그 등록 처리
     * @details 스텝로그 등록 처리한다.
     * @author : joy
     * @date : 2017. 2. 10.
     */
    public void insertLog() {
        boolean isError = false;

        // 에러 FLAG
        if(!" ".equals(exceptionStackTrace)) {
            isError = true;
        }
        
        
        // 최종 로그 목록
        List<Map<String, Object>> logListNew = new ArrayList<Map<String, Object>>();
        
        // ExecuteType이 SIMPLE인 EnfraSqlSessionTemplate 객체의 로그 목록
        List<Map<String, Object>> logList = sqlSessionTemplate.getLogList();
        
        int lastStepSeqno = 0;
        
        for(Map<String, Object> logRow : logList) {
            logRow.put("step_execution_id", enfraJobRepository.getStepId());
            
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug(logRow.toString());
            }
            
            lastStepSeqno = (int)logRow.get("step_seqno");
            
            logListNew.add(logRow);
        }
        
        boolean isSTLog = false;
        
        if(logList.size() > 0) {
            isSTLog = true;
        }
        
        // ExecuteType이 SIMPLE인 EnfraSqlSessionTemplate 객체 로그목록 초기화
        sqlSessionTemplate.setLogList(new ArrayList<Map<String, Object>>());
        logList = null;
        
        // ExecuteType이 BATCH인 EnfraSqlSessionTemplate 객체의 로그 목록
        List<Map<String, Object>> logList2 = sqlSessionTemplate_BATCH.getLogList();
        for(Map<String, Object> logRow : logList2) {
            logRow.put("step_execution_id", enfraJobRepository.getStepId());
            
            if(isSTLog) {
                logRow.put("step_seqno", ((int)logRow.get("step_seqno") + lastStepSeqno));
            }
            
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug(logRow.toString());
            }
            
            logListNew.add(logRow);
        }
        
        logList2 = null;
        
        // ExecuteType이 BATCH인 EnfraSqlSessionTemplate 객체 로그목록 초기화
        sqlSessionTemplate_BATCH.setLogList(new ArrayList<Map<String, Object>>());
        
        DefaultTransactionDefinition defCommon = new DefaultTransactionDefinition();
        defCommon.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus txStatusCommon = txManager.getTransaction(defCommon);
        
        EnfraSqlSessionTemplate logSqlSessionTemplate = (EnfraSqlSessionTemplate)applicationContext.getBean("sqlSessionTemplate");
        
        try {
            // STEP_LOG 등록 처리
            for(Map<String, Object> logRow : logListNew) {
                if(!logRow.containsKey("end_time")) {
                    Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
                    
                    logRow.put("end_time", currentTimeStamp);
                    
                    if(isError) {
                        logRow.put("err_msg", exceptionStackTrace);
                        logRow.put("status", "FAILED");
                    }
                }
                
                logSqlSessionTemplate.insertLog("common.insertStepReaderWriterLog", logRow);
            }
            
            txManager.commit(txStatusCommon);
        } catch(Exception e) {
            e.printStackTrace();
            txManager.rollback(txStatusCommon);
        }
        
    }
    
    public void insertBatExeMapp() {
        
        EnfraSqlSessionTemplate logSqlSessionTemplate = (EnfraSqlSessionTemplate)applicationContext.getBean("sqlSessionTemplate");
        
        //화면에서 실행했을때 매핑 insert
        if(  enfraJobRepository.getJobParameter().getString("GRP_INSTANCE_ID")!=null && !"".equals(enfraJobRepository.getJobParameter().getString("GRP_INSTANCE_ID"))) {

            DefaultTransactionDefinition defCommon = new DefaultTransactionDefinition();
            defCommon.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus txStatusCommon = txManager.getTransaction(defCommon);
            
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("job_execution_id", enfraJobRepository.getJobId());
            param.put("grp_instance_id", enfraJobRepository.getJobParameter().getString("GRP_INSTANCE_ID"));
            param.put("seq", enfraJobRepository.getJobParameter().getString("SEQ"));
            param.put("bat_id", enfraJobRepository.getJobName());
            
            try {
                logSqlSessionTemplate.insertLog("common.updateBatExeMapp", param);    
                txManager.commit(txStatusCommon);
            }
            catch(Exception e) {
                txManager.rollback(txStatusCommon);
            }
            
        }
    }

    /**
     * @brief JFlow Log 출력
     * @details JFlow에서 Gathering할 Log를 출력한다.
     * @author : joy
     * @date : 2017. 2. 14.
     * @param sJobName 작업명
     * @param executionCount 실행건수
     * @param processCount 처리건수
     * @param errorCount 에러건수
     * @param skipCount SKIP건수
     * @param sErrorCode 발생에러코드
     * @param sErrorMessage 발생에러메시지
     */
    private void printJFLowLog(String sJobName, BigDecimal executionCount, BigDecimal processCount
            , BigDecimal errorCount, BigDecimal skipCount, String sErrorCode, String sErrorMessage
            ) {
        StringBuffer logSb = new StringBuffer();

        logSb.append("\n").append("====================================").append("\n")
                .append("JobName : ").append(sJobName).append("\n")
                .append("Execution Count : ").append(executionCount).append("\n")
                .append("Process Count : ").append(processCount).append("\n")
                .append("Error Count : ").append(errorCount).append("\n")
                .append("Skip Count : ").append(skipCount).append("\n")
                .append("Error Code : ").append(sErrorCode).append("\n")
                .append("Error Message : ").append(sErrorMessage).append("\n")
                .append("====================================").append("\n");

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info(logSb.toString());
        }
    }
    
    /**
     * @brief Transaction CREATE
     * @details Transaction를 CREATE한다.
     * @author : joy
     * @date : 2018. 3. 14.
     * @param paramTxManager
     * @return TransactionStatus
     */
    protected TransactionStatus createTransaction(DataSourceTransactionManager paramTxManager) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return paramTxManager.getTransaction(def);
    }

    /**
     * @brief TransactionStatus GET 
     * @details TransactionStatus를 GET한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @return
     */
    protected TransactionStatus getTxStatus() {
        return txStatus;
    }

    /**
     * @param txStatus the txStatus to set
     */
    protected void setTxStatus(TransactionStatus txStatus) {
        this.txStatus = txStatus;
    }

    protected void beginTransaction() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        this.setTxStatus(getTxManager().getTransaction(def));
    }
    
    protected void endTransaction() {
        if(this.getTxStatus() != null && !this.getTxStatus().isCompleted()) {
            txManager.commit(txStatus);
        }
    }
    
    /**
     * @brief Transaction CREATE
     * @details Transaction를 CREATE한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @return
     */
    protected TransactionStatus createTransaction() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return getTxManager().getTransaction(def);
    }
    
    /**
     * @brief Commit Interval SET
     * @details Commit Interval 정의한다. 만일 defaultCommitInterval를 초과한경우 defautCommitInterval 값으로 대체한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param commitInterval
     */
    protected void setCommitInterval(int commitInterval) {
        this.commitInterval = commitInterval;
        
        if(commitInterval > defautCommitInterval ) {
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Commit Interval " + commitInterval + " must be less then "+defautCommitInterval+"."); 
                LOGGER.info("set Commit Interval as default : " + defautCommitInterval+".");
            }
            
            this.commitInterval = defautCommitInterval;
            
        } else {        
            this.commitInterval = commitInterval;
        }
    }
    
    /**
     * @brief commit Interval만큼 Commit, Transaction CREATE
     * @details commit Interval만큼 Commit하고 Transaction을 CREATE한다.
     * @author : joy
     * @date : 2018. 2. 26.
     */
    protected void checkCommit() {
        if(commitCount % commitInterval == 0) {
            this.localCommit();
        } else {
            commitCount++;
        }
    }
    
    /**
     * @brief 현재 트랜잭션을 커밋(commit)한다.
     * @details 현재 트랜잭션을 커밋(commit)한다.
     * @author : joy
     * @date : 2018. 2. 26.
     */
    private void localCommit() {
        if(!this.getTxStatus().isCompleted()) {
            txManager.commit(txStatus);
        }
        
        txStatus = this.createTransaction();
        
        commitCount = 1;
    }
    
    /**
     * @brief 현재 트랜잭션을 롤백(rollback)한다.
     * @details 현재 트랜잭션을 롤백(rollback)한다.
     * @author : joy
     * @date : 2018. 2. 26.
     */
    protected void localRollback() {
        if(!this.getTxStatus().isCompleted()) {
            txManager.rollback(txStatus);
        }
        
        commitCount = 1;
    }


    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }


    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the sqlSessionTemplate
     */
    public EnfraSqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    /**
     * @param sqlSessionTemplate the sqlSessionTemplate to set
     */
    public void setSqlSessionTemplate(EnfraSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * @return the sqlSessionTemplate_BATCH
     */
    protected EnfraSqlSessionTemplate getSqlSessionTemplate_BATCH() {
        return sqlSessionTemplate_BATCH;
    }

    /**
     * @param sqlSessionTemplate_BATCH the sqlSessionTemplate_BATCH to set
     */
    protected void setSqlSessionTemplate_BATCH(EnfraSqlSessionTemplate sqlSessionTemplate_BATCH) {
        this.sqlSessionTemplate_BATCH = sqlSessionTemplate_BATCH;
    }
    
    private boolean isValidDate(String yyyyMMdd) throws Exception {

        boolean result = false;

        if (yyyyMMdd.length() != 8) {
            return false;
        }

        try {
            int yyyy = Integer.parseInt(yyyyMMdd.substring(0, 4));
            int mm = Integer.parseInt(yyyyMMdd.substring(4, 6));
            int dd = Integer.parseInt(yyyyMMdd.substring(6));

            result = isValidDate(yyyy, mm, dd);
        } catch (Exception e) {
            return false;
        }

        return result;
    }
    
    private boolean isValidDate(int yyyy, int mm, int dd) throws Exception {

        boolean result = false;

        Calendar cal = new GregorianCalendar(yyyy, mm - 1, dd);

        int calYyyy = cal.get(Calendar.YEAR);
        int calMm = cal.get(Calendar.MONTH) + 1;
        int calDd = cal.get(Calendar.DATE);

        if (calYyyy == yyyy && calMm == mm && calDd == dd) {
            result = true;
        }

        return result;
    }
    
    private boolean isValidDate(String s, String format) throws Exception {

        boolean result = false;

        if (s == null) {
            if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }
        if (format == null) {
            if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format, LocaleContextHolder.getLocale());
        Date date = null;

        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }

        if (!formatter.format(date).equals(s)) {
            if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }

        SimpleDateFormat newFormatter = new SimpleDateFormat("yyyyMMdd", LocaleContextHolder.getLocale());

        result = isValidDate(newFormatter.format(date));

        return result;
    }
    
}

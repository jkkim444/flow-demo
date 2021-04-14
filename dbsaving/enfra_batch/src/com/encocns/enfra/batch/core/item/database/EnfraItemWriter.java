/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EnfraCursorReader.java
 * @brief Core Item Writer
 */
/**
 * @namespace com.encocns.batch.core.item.database
 * @brief Core Item Database Package
 */
package com.encocns.enfra.batch.core.item.database;

/**
 * @brief Core Item Writer 
 * @details  Core Item Writer이다.
 * @author : joy
 * @date : 2018. 2. 26.
 * @version : 1.0.0
 */
public class EnfraItemWriter {
    
    private EnfraSqlSessionTemplate sqlSessionTemplate;
    
    private String tempStatement = "";
    
    public void setSqlSessionTemplate(EnfraSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    /**
     * @brief SqlSessionTemplate GET
     * @details SqlSessionTemplate를 GET한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @return
     */
    public EnfraSqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
    
    /**
     * @brief Log 출력 여부 설정
     * @details Log 출력 여부를 설정한다.(true or false)
     * @author : joy
     * @date : 2018. 2. 26.
     * @param isLog
     */
    public void setLog(boolean isLog) {
        sqlSessionTemplate.setLog(isLog);
    }
    
    /**
     * @brief 등록 처리
     * @details 해당 statement로 파라미터 바인드하여 등록 처리한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param statement
     */
    public int insert(String statement) {
        return this.performChecker("INSERT", statement, null);
    }
    
    /**
     * @brief 등록 처리
     * @details 해당 statement로 파라미터 바인드하여 등록 처리한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param statement
     * @param parameter
     */
    public int insert(String statement, Object parameter) {
        return this.performChecker("INSERT", statement, parameter);
    }
    
    /**
     * @brief 수정 처리
     * @details 해당 statement로 파라미터 바인드하여 수정 처리한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param statement
     */
    public int update(String statement) {
        return this.performChecker("UPDATE", statement, null);
    }
    
    /**
     * @brief 수정 처리
     * @details 해당 statement로 파라미터 바인드하여 수정 처리한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param statement
     * @param parameter
     */
    public int update(String statement, Object parameter) {
        return this.performChecker("UPDATE", statement, parameter);
    }
    
    /**
     * @brief 삭제 처리
     * @details 해당 statement로 파라미터 바인드하여 삭제 처리한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param statement
     */
    public int delete(String statement) {
        return this.performChecker("DELETE", statement, null);
    }
    
    /**
     * @brief 삭제 처리
     * @details 해당 statement로 파라미터 바인드하여 삭제 처리한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param statement
     * @param parameter
     */
    public int delete(String statement, Object parameter) {
        return this.performChecker("DELETE", statement, parameter);
    }
    
    
    /**
     * @brief sqlSessionTemplate flushStatements call
     * @details sqlSessionTemplate flushStatements call 
     * @author : joy
     * @date : 2018. 3. 16.
     */
    public void flush() {
        sqlSessionTemplate.flush();
    }
    
    /**
     * @brief 하나의 쿼리 수행만 가능하도록 validation
     * @details 하나의 쿼리 수행만 가능하도록 validation
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 19.
     * @version : 1.0.0
     * @param queryType
     * @param statement
     * @param parameter
     * @return int 수행 결과 처리 건 수
     */
    private int performChecker(String queryType, String statement, Object parameter) {
        int result = 0;
        
//        if("".equals(tempStatement) || tempStatement.equals(statement)) {
            tempStatement = statement;
            
            if("INSERT".equals(queryType)) {
                if(parameter != null) {
                    result = sqlSessionTemplate.insert(statement, parameter);
                } else {
                    result = sqlSessionTemplate.insert(statement);
                }
            } else if("UPDATE".equals(queryType)) {
                if(parameter != null) {
                    result = sqlSessionTemplate.update(statement, parameter);
                } else {
                    result = sqlSessionTemplate.update(statement);
                }
            } else if("DELETE".equals(queryType)) {
                if(parameter != null) {
                    result = sqlSessionTemplate.delete(statement, parameter);
                } else {
                    result = sqlSessionTemplate.delete(statement);
                }
            }
//        } else {
//            throw new EnfraCoreException("CE0009");
//        }
        
        return result;
    }
}

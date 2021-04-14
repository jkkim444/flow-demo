/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EnfraItemReader.java
 * @brief Core Item Reader
 */
/**
 * @namespace com.encocns.enfra.batch.core.item.database
 * @brief Core Item Database Package
 */
package com.encocns.enfra.batch.core.item.database;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.item.ExecutionContext;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @brief Core Item Reader
 * @details Core Item Reader 이다. 
 * @author : joy
 * @date : 2018. 2. 26.
 * @version : 1.0.0
 * @param <T>
 */
public class EnfraItemReader<T> extends MyBatisCursorItemReader<T> {
	
	private EnfraSqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @brief 초기화
	 * @details 초기화한다.
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
	}
	
	/**
	 * @brief 초기화 메소드를 호출, Cursor Open
	 * @details 초기화 메소드를 호출, Cursor Open
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @throws Exception
	 */
	public void loadSQL() throws Exception {
		this.afterPropertiesSet();
		this.open(new ExecutionContext());
	}
	
	/**
	 * @brief SqlSessionTemplate(Mybatis) 객체를 GET 
	 * @details SqlSessionTemplate(Mybatis) 객체를 GET한다. 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @return EnfraSqlSessionTemplate MyBatis SqlSessionTemplate
	 */
	public EnfraSqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	
	/**
	 * @brief SqlSessionTemplate(Mybatis) 객체를 SET 
	 * @details SqlSessionTemplate(Mybatis) 객체를 SET한다. 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param sqlSessionTemplate MyBatis SqlSessionTemplate
	 */
	public void setSqlSessionTemplate(EnfraSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/**
	 * @brief sqlSessionTemplate select one
	 * @details sqlSessionTemplate select one 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param statement
	 * @return T
	 */
	@SuppressWarnings("hiding")
    public <T> T selectOne(String statement) {
		return sqlSessionTemplate.selectOne(statement);
	}
	
	/**
	 * @brief sqlSessionTemplate select one
	 * @details sqlSessionTemplate select one, parameter bind
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param statement
	 * @param parameter
	 * @return T
	 */
	@SuppressWarnings("hiding")
    public <T> T selectOne(String statement, Object parameter) {
		return sqlSessionTemplate.selectOne(statement, parameter);
	}
	
	/**
	 * @brief sqlSessionTemplate select list
	 * @details sqlSessionTemplate select list
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param statement
	 * @return <E> List<E>
	 */
	public <E> List<E> selectList(String statement) {
		return sqlSessionTemplate.selectList(statement);
	}
	
	/**
	 * @brief sqlSessionTemplate select list
	 * @details sqlSessionTemplate select list, parameter bind 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public <E> List<E> selectList(String statement, Object parameter) {
		return sqlSessionTemplate.selectList(statement, parameter);
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
     * @brief Parameter를 SET
     * @details Parameter를 SET한다.
     * @author : joy
     * @date : 2018. 2. 26.
     * @param Object parameter
     */
    public void setParameter(Object parameter) {
        ObjectMapper oMapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, Object> param = oMapper.convertValue(parameter, Map.class);
        super.setParameterValues(param);
    }
	
}

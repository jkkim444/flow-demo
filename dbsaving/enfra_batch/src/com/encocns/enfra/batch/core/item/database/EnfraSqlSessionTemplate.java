/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file BaseReaderWriterSqlSessionTemplate.java
 * @brief Reader Writer SqlSessionTemplate
 */
/**
 * @namespace com.encocns.batch.core.item.database
 * @brief Core Item Database Package
 */
package com.encocns.enfra.batch.core.item.database;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.encocns.enfra.batch.core.util.MybatisUtil;

/**
 * @brief Reader Writer SqlSessionTemplate
 * @details Reader Writer SqlSessionTemplate이다.
 * @author : joy
 * @date : 2017. 2. 2.
 * @version : 1.0.0
 */
public class EnfraSqlSessionTemplate extends SqlSessionTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnfraSqlSessionTemplate.class);

	private Long jobInstanceId;
	private Long jobExecutionId;
	private Long stepExecutionId;
	private String jobName;

	private BigDecimal selectCount = BigDecimal.ZERO;
	private BigDecimal insertCount = BigDecimal.ZERO;
	private BigDecimal updateCount = BigDecimal.ZERO;
	private BigDecimal deleteCount = BigDecimal.ZERO;

	private boolean isUse = false;

	private boolean isCustom = false;

	private boolean isLog = false;

	private String queryId = "";
	private String queryProcessDiv = "";

	private List<Map<String, Object>> logList = new ArrayList<Map<String, Object>>();

	/**
	 * @brief EnfraSqlSessionTemplate sqlSessionFactory Setter
	 * @details EnfraSqlSessionTemplate sqlSessionFactory Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param sqlSessionFactory
	 */
	public EnfraSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	/**
	 * @brief EnfraSqlSessionTemplate sqlSessionFactory Setter
	 * @details EnfraSqlSessionTemplate sqlSessionFactory Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param sqlSessionFactory
	 * @param executorType
	 */
	public EnfraSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
		super(sqlSessionFactory, executorType);
	}
	
	/**
	 * @brief 단건 조회 처리
	 * @details 해당 statement로 파라미터 없이 단건 조회 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#selectOne(java.lang.String)
	 * @param statement
	 * @return <T> T 단건 조회 결과
	 */
	@Override
	public <T> T selectOne(String statement) {
		int result = 0;

		isUse = true;

		printSQL(statement, null);
		
		startLog(statement, "SELECT");

		T resultObject = super.selectOne(statement);

		if(resultObject != null) {
			result = 1;
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(isLog) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Select Count : {} ", statement, result);

		selectCount = selectCount.add(new BigDecimal(result));

		return resultObject;
	}

	/**
	 * @brief 단건 조회 처리(파라미터 있음)
	 * @details 해당 statement로 파라미터 바인드하여 단건 조회 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#selectOne(java.lang.String, java.lang.Object)
	 * @param statement
	 * @param parameter
	 * @return <T> T 단건 조회 결과
	 */
	@Override
	public <T> T selectOne(String statement, Object parameter) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "SELECT");

		T resultObject = super.selectOne(statement, parameter);

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(resultObject != null) {
			result = 1;
		}

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Select Count : {} > Parameters : {}", statement, result, getFields(parameter));

		selectCount = selectCount.add(new BigDecimal(result));

		return resultObject;
	}

	/**
	 * @brief 다건 조회 처리
	 * @details 해당 statement로 파라미터 없이 조회 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#selectList(java.lang.String)
	 * @param statement
	 * @return <E> List<E> 다건 조회 결과
	 */
	@Override
	public <E> List<E> selectList(String statement) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "SELECT");

		List<E> resultList = super.selectList(statement);

		if(resultList != null ) {
			result = resultList.size();
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Select Count : {} ", statement, result);

		selectCount = selectCount.add(new BigDecimal(result));

		return resultList;
	}

	/**
	 * @brief 다건 조회 처리(파라미터 있음)
	 * @details 해당 statement로 파라미터 바인드하여 조회 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#selectList(java.lang.String, java.lang.Object)
	 * @param statement
	 * @param parameter
	 * @return <E> List<E> 다건 조회 결과
	 */
	@Override
	public <E> List<E> selectList(String statement, Object parameter) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "SELECT");

		List<E> resultList = super.selectList(statement, parameter);

		if(resultList != null ) {
			result = resultList.size();
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Select Count : {1} > Parameters : {}", statement, result, getFields(parameter));

		selectCount = selectCount.add(new BigDecimal(result));

		return resultList;
	}


	/**
	 * @brief 등록 처리
	 * @details 해당 statement로 파라미터 바인드하여 등록 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#insert(java.lang.String, java.lang.Object)
	 * @param statement
	 * @return int 등록 처리 건수
	 */
	@Override
	public int insert(String statement) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "INSERT");

		result = super.insert(statement);

		if(this.getExecutorType() == ExecutorType.BATCH) {
			result = 1;
		}
		
		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Insert Count : {}", statement, result);

		insertCount = insertCount.add(new BigDecimal(result));

		return result;
	}

	/**
	 * @brief 등록 처리
	 * @details 해당 statement로 파라미터 바인드하여 등록 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#insert(java.lang.String, java.lang.Object)
	 * @param statement
	 * @param parameter
	 * @return int 등록 처리 건수
	 */
	@Override
	public int insert(String statement, Object parameter) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "INSERT");

		result = super.insert(statement, parameter);

		if(this.getExecutorType() == ExecutorType.BATCH) {
			result = 1;
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Insert Count : {} > Parameters : {}", statement, result, getFields(parameter));

		insertCount = insertCount.add(new BigDecimal(result));

		return result;
	}

	/**
	 * @brief 삭제 처리
	 * @details 해당 statement로 파라미터 바인드하여 삭제 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#delete(java.lang.String, java.lang.Object)
	 * @param statement
	 * @return int 삭제 처리 건수
	 */
	@Override
	public int delete(String statement) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "DELETE");

		result = super.delete(statement);
		
		if(this.getExecutorType() == ExecutorType.BATCH) {
			result = 1;
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Delete Count : {} > Parameters : {}", statement, result);

		deleteCount = deleteCount.add(new BigDecimal(result));

		return result;
	}

	/**
	 * @brief 삭제 처리
	 * @details 해당 statement로 파라미터 바인드하여 삭제 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#delete(java.lang.String, java.lang.Object)
	 * @param statement
	 * @param parameter
	 * @return int 삭제 처리 건수
	 */
	@Override
	public int delete(String statement, Object parameter) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "DELETE");

		result = super.delete(statement, parameter);
		
		if(this.getExecutorType() == ExecutorType.BATCH) {
			result = 1;
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Delete Count : {} > Parameters : {}", statement, result, getFields(parameter));

		deleteCount = deleteCount.add(new BigDecimal(result));

		return result;
	}

	/**
	 * @brief 수정 처리
	 * @details 해당 statement로 파라미터 바인드하여 수정 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#update(java.lang.String, java.lang.Object)
	 * @param statement
	 * @return int 수정 처리 건수
	 */
	@Override
	public int update(String statement) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "UPDATE");

		result = super.update(statement);
		
		if(this.getExecutorType() == ExecutorType.BATCH) {
			result = 1;
		}
		
		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Update Count : {}", statement, result);

		updateCount = updateCount.add(new BigDecimal(result));

		return result;
	}

	/**
	 * @brief 수정 처리
	 * @details 해당 statement로 파라미터 바인드하여 수정 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.mybatis.spring.SqlSessionTemplate#update(java.lang.String, java.lang.Object)
	 * @param statement
	 * @param parameter
	 * @return int 수정 처리 건수
	 */
	@Override
	public int update(String statement, Object parameter) {
		int result = 0;

		printSQL(statement, null);
		
		startLog(statement, "UPDATE");

		result = super.update(statement, parameter);
		
		if(this.getExecutorType() == ExecutorType.BATCH) {
			result = 1;
		}

		endLog(statement, new BigDecimal(String.valueOf(result)), " ");

		if(getLog()) if(LOGGER.isInfoEnabled()) LOGGER.info("##### {} > Update Count : {} > Parameters : {}", statement, result, getFields(parameter));

		updateCount = updateCount.add(new BigDecimal(result));

		return result;
	}

	/**
	 * @brief 해당 Object를 invoke 하여 파라미터 문자열 생성하여 반환
	 * @details 해당 Object를 invoke 하여 파라미터 문자열 생성하여 반환한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param obj
	 * @return String 파라미터 문자열
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String getFields(Object obj) {
		StringBuffer resultSB = new StringBuffer();
		boolean isNotFirst = false;
		try {
			Class dymClass = obj.getClass();

			if(dymClass.toString().endsWith("DTO")
					||  dymClass.toString().endsWith("IN")
					) {
				Field[] fields = dymClass.getDeclaredFields();

				for (int i = 0; i < fields.length; i++) {
					String methodName = fields[i].getName();

    	    		if(methodName.substring(0,  1).matches("[a-z]+") &&
    	    				methodName.substring(1,  2).matches("[A-Z]+")
    	    				) {
    	    			methodName = "get"+methodName;
    	    		} else {
    	    			methodName = "get"+StringUtils.capitalize(methodName);
    	    		}

					Method method = dymClass.getMethod(methodName, null);

					String value = String.valueOf(method.invoke(obj, null));

					if(isNotFirst) {
						if(value != null && !"null".equals(value)) {
							resultSB.append("," + fields[i].getName() + "=" + value);
						}
					} else {
						if(value != null && !"null".equals(value)) {
							resultSB.append(fields[i].getName() + "=" + value);
						}
					}

					isNotFirst = true;
				}
			} else if(dymClass.toString().endsWith("String")) {
				resultSB.append("String=" + obj.toString());
			} else if(dymClass.toString().endsWith("int")) {
				resultSB.append("int=" + String.valueOf(obj));
			} else if(dymClass.toString().endsWith("HashMap")) {
				HashMap targetObj = (HashMap)obj;

	            Iterator<String> iterator = targetObj.keySet().iterator();

	            String key = "";
	            isNotFirst = false;

	            while (iterator.hasNext())  {
	                key = iterator.next();
	                Object value = targetObj.get(key);

					if(isNotFirst) {
						resultSB.append(",");
					}

	                if (value != null) {
						resultSB.append(key + "=" + value);
	                }

	                isNotFirst = true;
	            }
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultSB.toString();
	}

	/**
	 * @brief Job Instance Id Getter
	 * @details Job Instance Id Getter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @return long jobInstance Id
	 */
	public Long getJobInstanceId() {
		return jobInstanceId;
	}

	/**
	 * @brief Job Instance Id Setter
	 * @details Job Instance Id Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param jobInstanceId
	 */
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	/**
	 * @brief Job Execution Id Getter
	 * @details Job Execution Id Getter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @return long jobExecution Id
	 */
	public Long getJobExecutionId() {
		return jobExecutionId;
	}

	/**
	 * @brief Job Execution Id Setter
	 * @details Job Execution Id Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param jobExecutionId
	 */
	public void setJobExecutionId(Long jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

	/**
	 * @brief Step Execution Id Getter
	 * @details Step Execution Id Getter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @return long stepExecution Id
	 */
	public Long getStepExecutionId() {
		return stepExecutionId;
	}

	/**
	 * @brief Step Execution Id Setter
	 * @details Step Execution Id Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param stepExecutionId
	 */
	public void setStepExecutionId(Long stepExecutionId) {
		this.stepExecutionId = stepExecutionId;
	}

	/**
	 * @brief Job Name Getter
	 * @details Job Name Getter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @return String Job Name
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @brief Job Name Setter
	 * @details Job Name Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param jobName
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	/**
	 * @brief 전체 건수를 초기화
	 * @details 전체 건수를 초기화한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param count 초기화 건수
	 */
	public void setAllCount(BigDecimal count) {
		this.selectCount = count;
		this.insertCount = count;
		this.updateCount = count;
		this.deleteCount = count;
	}

	/**
	 * @brief 해당 BaseReaderWriterSqlSessionTemplate의 사용 여부 반환
	 * @details 해당 BaseReaderWriterSqlSessionTemplate의 사용 여부 반환한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @return
	 */
	public boolean isUse() {
		return isUse;
	}

	/**
	 * @brief 해당 BaseReaderWriterSqlSessionTemplate의 사용 여부 값 SETTER
	 * @details 해당 BaseReaderWriterSqlSessionTemplate의 사용 여부 SET한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param isUse 사용여부 값
	 * @return
	 */
	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	/**
	 * @brief 커스텀 여부 반환
	 * @details 건수에 대한 커스텀 여부를 반환한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @return
	 */
	public boolean isCustom() {
		return isCustom;
	}

	/**
	 * @brief CRUD의 Count수를 Set
	 * @details CRUD의 Count수를 Set
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param selectCount 조회 건수
	 * @param insertCount 등록 건수
	 * @param updateCount 수정 건수
	 * @param deleteCount 삭제 건수
	 */
	public void setCRUDCount(BigDecimal selectCount, BigDecimal insertCount, BigDecimal updateCount, BigDecimal deleteCount) {
		isCustom = true;

		this.selectCount = selectCount;
		this.insertCount = insertCount;
		this.updateCount = updateCount;
		this.deleteCount = deleteCount;
	}

	/**
	 * @brief 로그 출력 여부 Get
	 * @details 로그 출력의 여부를 Get한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 */
	public boolean getLog() {
		return isLog;
	}
	
	/**
	 * @brief 로그 출력 여부 Set
	 * @details 로그 출력의 여부를 Set한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param isLog 로그 출력 여부
	 */
	public void setLog(boolean isLog) {
		this.isLog = isLog;
	}

	/**
	 * @brief 쿼리 아이디 Getter
	 * @details 쿼리 아이디 Getter이다.
	 * @author : joy
	 * @date : 2017. 2. 9.
	 * @return String QueryId
	 */
	public String getQueryId() {
		return queryId;
	}

	/**
	 * @brief 쿼리 아이디 Setter
	 * @details 쿼리 아이디 Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 9.
	 * @param queryId
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	/**
	 * @brief 쿼리 처리 구분 Getter
	 * @details 쿼리 처리 구분 Getter이다.
	 * @author : joy
	 * @date : 2017. 2. 9.
	 * @return String QueryProcessDiv
	 */
	public String getQueryProcessDiv() {
		return queryProcessDiv;
	}

	/**
	 * @brief 쿼리 처리 구분 Setter
	 * @details 쿼리 처리 구분 Setter이다.
	 * @author : joy
	 * @date : 2017. 2. 9.
	 * @param queryProcessDiv
	 */
	public void setQueryProcessDiv(String queryProcessDiv) {
		this.queryProcessDiv = queryProcessDiv;
	}

	/**
	 * @brief 로그 목록 추가 처리
	 * @details 로그 목록에 추가 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param sQueryId 쿼리아이디
	 * @param sQueryProcessDiv 쿼리처리구분
	 */
	public void startLog(String sQueryId, String sQueryProcessDiv) {
		if(!getContainQueryId(sQueryId)) {
			// 스텝 일련번호를 증가한다.

			HashMap<String, Object> logRow = new HashMap<String, Object>();
			logRow.put("step_execution_id", stepExecutionId);
			logRow.put("step_seqno", logList.size()+1);
			logRow.put("query_id", sQueryId);
			logRow.put("query_process_div", sQueryProcessDiv);
			logRow.put("process_cnt", "0");
			logRow.put("err_msg", " ");
			logRow.put("status", "STARTED");
			Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
			logRow.put("start_time", currentTimeStamp);

			logList.add(logRow);
		}
	}

	/**
	 * @brief 로그 목록 수정 처리
	 * @details 로그 목록 수정 처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @param iProcessCnt 처리건수
	 * @param sErrorMsg 오류메시지
	 */
	public void endLog(String sQueryId, BigDecimal iProcessCnt, String sErrorMsg) {
		for(Map<String, Object> logRow : logList) {
			if(sQueryId.equals(logRow.get("query_id").toString())) {
				logRow.put("process_cnt", new BigDecimal(String.valueOf(logRow.get("process_cnt"))).add(iProcessCnt));
				logRow.put("err_msg", sErrorMsg);
				logRow.put("status", "COMPLETED");

				// 최종 수행 시간을 계속해서 업데이트한다.
				Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
				logRow.put("end_time", currentTimeStamp);

				break;
			}
		}
	}

	/**
	 * @brief Log List에 해당 QueryId 존재 여부 반환
	 * @details Log List에 해당 QueryId 존재 여부를 반환한다.
	 * @author : joy
	 * @date : 2017. 2. 10.
	 * @param sQueryId
	 * @return boolean QueryId Exist
	 */
	private boolean getContainQueryId(String sQueryId) {
		for(Map<String, Object> row : logList) {
			if(sQueryId.equals(row.get("query_id").toString())) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * @brief 해당 QueryID로 Query만 반환
	 * @details 해당 QueryID로 Query만 반환한다.
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param queryId
	 * @param parameter
	 * @return String query
	 */
	public String getQuery(String queryId, Object parameter) {
		MappedStatement ms = this.getConfiguration().getMappedStatement(queryId);
		BoundSql boundSql = ms.getBoundSql(parameter);
		
		return boundSql.getSql();
	}
	
	/**
	 * @brief 해당 QueryID로 Query에 파라미터를 Bind하여 반환
	 * @details 해당 QueryID로 Query에 파라미터를 Bind하여 반환한다. 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param queryId
	 * @param parameter
	 * @return String query
	 */
	protected String getSql(String queryId, Object parameter) {
		MappedStatement ms = this.getConfiguration().getMappedStatement(queryId);
		return MybatisUtil.getMybatisQuery(ms.getBoundSql(parameter), parameter);
	}

	/**
	 * @brief LogList 반환
	 * @details LogList를 반환한다. 
	 * @author : joy
	 * @date : 2018. 3. 13.
	 * @return
	 */
	public List<Map<String, Object>> getLogList() {
		return logList;
	}
	
	/**
     * @param logList the logList to set
     */
    public void setLogList(List<Map<String, Object>> logList) {
        this.logList = logList;
    }

    /**
	 * @brief flushStatements call
	 * @details flushStatements call 
	 * @author : joy
	 * @date : 2018. 3. 16.
	 */
	public void flush() {
		this.flushStatements();
	}
	
    public int insertLog(String statement, Object parameter) {
        return super.insert(statement, parameter);
    }
    
    private void printSQL(String sQueryId, Object param) {
        MappedStatement ms = super.getSqlSessionFactory().getConfiguration().getMappedStatement(sQueryId);
        BoundSql boundSql = ms.getBoundSql(param);
        String finalSql = MybatisUtil.getMybatisQuery(boundSql, param);
        
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("-------------------------------------------------");
            LOGGER.debug(finalSql);
            LOGGER.debug("-------------------------------------------------");
        }
    }

    /**
     * @return the selectCount
     */
    public BigDecimal getSelectCount() {
        return selectCount;
    }

    /**
     * @param selectCount the selectCount to set
     */
    public void setSelectCount(BigDecimal selectCount) {
        this.selectCount = selectCount;
    }

    /**
     * @return the insertCount
     */
    public BigDecimal getInsertCount() {
        return insertCount;
    }

    /**
     * @param insertCount the insertCount to set
     */
    public void setInsertCount(BigDecimal insertCount) {
        this.insertCount = insertCount;
    }

    /**
     * @return the updateCount
     */
    public BigDecimal getUpdateCount() {
        return updateCount;
    }

    /**
     * @param updateCount the updateCount to set
     */
    public void setUpdateCount(BigDecimal updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * @return the deleteCount
     */
    public BigDecimal getDeleteCount() {
        return deleteCount;
    }

    /**
     * @param deleteCount the deleteCount to set
     */
    public void setDeleteCount(BigDecimal deleteCount) {
        this.deleteCount = deleteCount;
    }

}

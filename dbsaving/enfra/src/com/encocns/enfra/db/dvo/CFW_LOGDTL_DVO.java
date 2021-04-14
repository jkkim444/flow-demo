/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CCO_LOG_DVO.java
 * @brief
 */
/**
 * @namespace com.encocns.enfra.db.dvo
 * @brief
 */
package com.encocns.enfra.db.dvo;

public class CFW_LOGDTL_DVO {

	private String log_seqno;
	private long logdtl_seqno;
	private String query_id;
	private String query_process_div;
	private long process_cnt;
	private String err_msg;
	private String status;
	private String start_time;
	private String end_time;
	private String query;
	
	/**
	 * @return the log_seqno
	 */
	public String getLog_seqno() {
		return log_seqno;
	}
	/**
	 * @param log_seqno the log_seqno to set
	 */
	public void setLog_seqno(String log_seqno) {
		this.log_seqno = log_seqno;
	}
	/**
	 * @return the logdtl_seqno
	 */
	public long getLogdtl_seqno() {
		return logdtl_seqno;
	}
	/**
	 * @param logdtl_seqno the logdtl_seqno to set
	 */
	public void setLogdtl_seqno(long logdtl_seqno) {
		this.logdtl_seqno = logdtl_seqno;
	}
	/**
	 * @return the query_id
	 */
	public String getQuery_id() {
		return query_id;
	}
	/**
	 * @param query_id the query_id to set
	 */
	public void setQuery_id(String query_id) {
		this.query_id = query_id;
	}
	/**
	 * @return the query_process_div
	 */
	public String getQuery_process_div() {
		return query_process_div;
	}
	/**
	 * @param query_process_div the query_process_div to set
	 */
	public void setQuery_process_div(String query_process_div) {
		this.query_process_div = query_process_div;
	}
	/**
	 * @return the process_cnt
	 */
	public long getProcess_cnt() {
		return process_cnt;
	}
	/**
	 * @param process_cnt the process_cnt to set
	 */
	public void setProcess_cnt(long process_cnt) {
		this.process_cnt = process_cnt;
	}
	/**
	 * @return the err_msg
	 */
	public String getErr_msg() {
		return err_msg;
	}
	/**
	 * @param err_msg the err_msg to set
	 */
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the start_time
	 */
	public String getStart_time() {
		return start_time;
	}
	/**
	 * @param start_time the start_time to set
	 */
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	/**
	 * @return the end_time
	 */
	public String getEnd_time() {
		return end_time;
	}
	/**
	 * @param end_time the end_time to set
	 */
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	
}

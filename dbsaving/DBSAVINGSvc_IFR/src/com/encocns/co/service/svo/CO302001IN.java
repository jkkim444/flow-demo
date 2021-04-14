/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO302001IN.java
 * @brief 메시지 코드 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 메시지 코드 조회 IN
 * @details 메시지 코드 조회 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO302001IN {

    private String bizLclsCd; /* Business large category code*/
    private String msgTcd;    /* Message Parent Code*/
    private String msgCd;     /* Message code  */
    private String lclCd;     /* Locale Code  */
    private String msgCntn;   /* Message content  */
    private String rmkCntn;   /* Remarks content  */
    private String sortSeq;   /* Sort sequence */

	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getMsgTcd() {
		return msgTcd;
	}
	public void setMsgTcd(String msgTcd) {
		this.msgTcd = msgTcd;
	}
	public String getMsgCd() {
		return msgCd;
	}
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getMsgCntn() {
		return msgCntn;
	}
	public void setMsgCntn(String msgCntn) {
		this.msgCntn = msgCntn;
	}
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}
	public String getSortSeq() {
		return sortSeq;
	}
	public void setSortSeq(String sortSeq) {
		this.sortSeq = sortSeq;
	}

}

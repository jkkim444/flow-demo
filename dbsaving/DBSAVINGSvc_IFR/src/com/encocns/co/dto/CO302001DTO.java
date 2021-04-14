/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO302001DTO.java
 * @brief 메시지 코드 관리 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 메시지 코드 관리 DTO
 * @details 메시지 코드 관리 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO302001DTO {

	private String msgTcd;                        /* 메시지타입코드 */
	private String msgCd;                         /* 메시지코드 */
	private String lclCd;                         /* 번역코드 */
	private String msgCntn;                       /* 메시지내용 */
	private String rmkCntn;                       /* 비고 */
	private String regId;                         /* 등록ID */
	private String regDtm;                        /* 등록일자 */
	private String chgId;                         /* 변경ID */
	private String chgDtm;                        /* 변경일자 */

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
	public String getChgId() {
		return chgId;
	}
	public void setChgId(String chgId) {
		this.chgId = chgId;
	}
	public String getChgDtm() {
		return chgDtm;
	}
	public void setChgDtm(String chgDtm) {
		this.chgDtm = chgDtm;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegDtm() {
		return regDtm;
	}
	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

}

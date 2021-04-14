/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO302003IN.java
 * @brief 메시지 코드 삭제 IN
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
 * @brief 메시지 코드 삭제 IN
 * @details 메시지 코드 삭제 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO302003IN {

    private String msgTcd;    /* 메시지 상위 코드 */
    private String msgCd;     /* 메시지 코드      */
    private String lclCd;     /* 로케일 코드      */

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

}

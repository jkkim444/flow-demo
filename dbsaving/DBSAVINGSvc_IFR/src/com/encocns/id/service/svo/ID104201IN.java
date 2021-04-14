/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID104201IN.java
 * @brief 산출정보 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service.svo
 * @brief id SVO Package
 */
package com.encocns.id.service.svo;

/**
 * @brief 산출정보 조회 IN
 * @details 산출정보 조회 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID104201IN {

	private String clclIstgId;                       /* 산출대상ID */
	private String clclIstgCtnt;                     /* 산출대상명 */

	public String getClclIstgId() {
		return clclIstgId;
	}
	public void setClclIstgId(String clclIstgId) {
		this.clclIstgId = clclIstgId;
	}
	public String getClclIstgCtnt() {
		return clclIstgCtnt;
	}
	public void setClclIstgCtnt(String clclIstgCtnt) {
		this.clclIstgCtnt = clclIstgCtnt;
	}
}

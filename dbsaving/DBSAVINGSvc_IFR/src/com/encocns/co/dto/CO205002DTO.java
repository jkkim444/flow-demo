/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO104001DTO.java
 * @brief 그룹사용자관리 DTO
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
 * @brief 그룹사용자관리 DTO
 * @details 그룹사용자관리 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO205002DTO {
	private String grpId;                            /* 그룹ID */
	private String usrId;                            /* 사용자ID */
    private String chgUser;                          /* 변경사용자 */

	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getChgUser() {
		return chgUser;
	}
	public void setChgUser(String chgUser) {
		this.chgUser = chgUser;
	}
}

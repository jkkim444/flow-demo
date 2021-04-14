/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP208003DTO.java
 * @brief 타사연체여부 업로드 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 11. 25. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;



/**
 * @brief 타사연체여부 업로드 management List Query DTO
 * @details 타사연체여부 업로드 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 11. 25.
 * @version : 1.0.0
 */
public class IP208003DTO {

	private String stdrYm;                     /* 기준년월 */
	private String loanAcno;                   /* 대출계좌번호 */
	private String otinOvrdYn;                 /* 타기관연체여부 */
	private String usrId;					   /* 사용자ID */

	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLoanAcno() {
		return loanAcno;
	}
	public void setLoanAcno(String loanAcno) {
		this.loanAcno = loanAcno;
	}
	public String getOtinOvrdYn() {
		return otinOvrdYn;
	}
	public void setOtinOvrdYn(String otinOvrdYn) {
		this.otinOvrdYn = otinOvrdYn;
	}

}

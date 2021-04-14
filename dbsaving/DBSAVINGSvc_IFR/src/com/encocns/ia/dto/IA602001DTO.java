/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 수익용 부동산 보유 현황 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 수익용 부동산 보유 현황 management List Query DTO
 * @details 수익용 부동산 보유 현황 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA602001DTO {

	private String rNum;                          /* 행번호 */
	private String baseDt;                        /* 기준일자 */
	private String acqsDspslDivCd;                /* 취득처분구분코드 */
	private String tnasetDivCd;                   /* 유형자산구분코드 */
	private String asetCd;                        /* 자산코드 */
	private String asetNm;                        /* 자산명 */
	private BigDecimal acqsDspslAmt;              /* 취득처분금액 */
	private String usrId;                         /* 사용자ID */


	/**
	 * @return the rNum
	 */
	public String getrNum() {
		return rNum;
	}
	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getBaseDt() {
		return baseDt;
	}
	public void setBaseDt(String baseDt) {
		this.baseDt = baseDt;
	}
	public String getAcqsDspslDivCd() {
		return acqsDspslDivCd;
	}
	public void setAcqsDspslDivCd(String acqsDspslDivCd) {
		this.acqsDspslDivCd = acqsDspslDivCd;
	}
	public String getTnasetDivCd() {
		return tnasetDivCd;
	}
	public void setTnasetDivCd(String tnasetDivCd) {
		this.tnasetDivCd = tnasetDivCd;
	}
	public String getAsetCd() {
		return asetCd;
	}
	public void setAsetCd(String asetCd) {
		this.asetCd = asetCd;
	}
	public String getAsetNm() {
		return asetNm;
	}
	public void setAsetNm(String asetNm) {
		this.asetNm = asetNm;
	}
	public BigDecimal getAcqsDspslAmt() {
		return acqsDspslAmt;
	}
	public void setAcqsDspslAmt(BigDecimal acqsDspslAmt) {
		this.acqsDspslAmt = acqsDspslAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


}

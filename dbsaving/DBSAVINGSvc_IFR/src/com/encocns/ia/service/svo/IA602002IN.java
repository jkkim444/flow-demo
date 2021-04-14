/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002IN.java
 * @brief IFRS 계정코드 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;
import java.util.List;

import com.encocns.ia.dto.IA602001DTO;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA602002IN {

	private String baseDt;                           /* 기준일자 */
	private String acqsDspslDivCd;                   /* 취득처분구분코드 */
	private String tnasetDivCd;                      /* 유형자산구분코드 */
	private String asetCd;                           /* 자산코드 */
	private String asetNm;                           /* 자산명 */
	private BigDecimal acqsDspslAmt;                 /* 취득처분금액 */
	private String usrId;                            /* 사용자ID */

	private List<IA602001DTO> arrList;               /* 그리드 데이터 */

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
	public List<IA602001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA602001DTO> arrList) {
		this.arrList = arrList;
	}
}

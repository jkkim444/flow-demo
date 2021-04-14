/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA502002IN.java
 * @brief 제무제표 양식 management IN
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


/**
 * @brief 제무제표 양식 management IN
 * @details 제무제표 양식 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA502002IN {

	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String ifrsAccNm;                        /* IFRS계정명 */
	private int toacLvel;                            /* 계정과목레벨 */
	private String lvelIfrsAccNm;                    /* 레벨IFRS계정명 */
	private String uprIfrsAccCd;                     /* 상위IFRS계정코드 */
	private String scrnIndcOrd;                      /* 화면표시순서 */
	private String ecalTpCd;                         /* 정산유형코드 */
	private String aplcStrtDt;                       /* 적용시작일자 */

	private String jobDivCd;                         /* 등록수정구분코드 */
	private String usrId;                            /* 사용자ID */

	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}
	public String getAplcStrtDt() {
		return aplcStrtDt;
	}
	public void setAplcStrtDt(String aplcStrtDt) {
		this.aplcStrtDt = aplcStrtDt;
	}
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getIfrsAccNm() {
		return ifrsAccNm;
	}
	public void setIfrsAccNm(String ifrsAccNm) {
		this.ifrsAccNm = ifrsAccNm;
	}
	public int getToacLvel() {
		return toacLvel;
	}
	public void setToacLvel(int toacLvel) {
		this.toacLvel = toacLvel;
	}
	public String getUprIfrsAccCd() {
		return uprIfrsAccCd;
	}
	public void setUprIfrsAccCd(String uprIfrsAccCd) {
		this.uprIfrsAccCd = uprIfrsAccCd;
	}
	public String getScrnIndcOrd() {
		return scrnIndcOrd;
	}
	public void setScrnIndcOrd(String scrnIndcOrd) {
		this.scrnIndcOrd = scrnIndcOrd;
	}
	public String getEcalTpCd() {
		return ecalTpCd;
	}
	public void setEcalTpCd(String ecalTpCd) {
		this.ecalTpCd = ecalTpCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}

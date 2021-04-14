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

import java.util.List;

import com.encocns.ia.dto.IA501001DTO;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA501002IN {

	private String ifrsAccCd;                    /* IFRS계정코드 */
	private String ifrsAccDcd;					 /* IFRS계정구분코드 */
	private String ifrsAccNm;                    /* IFRS계정명 */
	private String bltAccYn;                     /* 실계정여부 */
	private int toacLvel;                        /* 계정과목레벨 */
	private String lvelIfrsAccNm;                /* 레벨IFRS계정명 */
	private String uprIfrsAccCd;                 /* 상위IFRS계정코드 */
	private int scrnIndcOrd;                     /* 화면표시순서 */
	private String toacCd;                       /* KGAAP계정코드 */
	private String aplcStrtDt;					 /* 적용시작일자 */
	private String aplcEndDt;					 /* 적용종료일자 */
	private String jobDivCd;
	private String usrId;

	private List<IA501001DTO> arrGridData;



	/**
	 * @return the arrGridData
	 */
	public List<IA501001DTO> getArrGridData() {
		return arrGridData;
	}
	/**
	 * @param arrGridData the arrGridData to set
	 */
	public void setArrGridData(List<IA501001DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getAplcEndDt() {
		return aplcEndDt;
	}
	public void setAplcEndDt(String aplcEndDt) {
		this.aplcEndDt = aplcEndDt;
	}
	/**
	 * @return the aplcStrtDt
	 */
	public String getAplcStrtDt() {
		return aplcStrtDt;
	}
	/**
	 * @param aplcStrtDt the aplcStrtDt to set
	 */
	public void setAplcStrtDt(String aplcStrtDt) {
		this.aplcStrtDt = aplcStrtDt;
	}
	/**
	 * @return the ifrsAccCd
	 */
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	/**
	 * @param ifrsAccCd the ifrsAccCd to set
	 */
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	/**
	 * @return the ifrsAccDcd
	 */
	public String getIfrsAccDcd() {
		return ifrsAccDcd;
	}
	/**
	 * @param ifrsAccDcd the ifrsAccDcd to set
	 */
	public void setIfrsAccDcd(String ifrsAccDcd) {
		this.ifrsAccDcd = ifrsAccDcd;
	}
	/**
	 * @return the ifrsAccNm
	 */
	public String getIfrsAccNm() {
		return ifrsAccNm;
	}
	/**
	 * @param ifrsAccNm the ifrsAccNm to set
	 */
	public void setIfrsAccNm(String ifrsAccNm) {
		this.ifrsAccNm = ifrsAccNm;
	}
	/**
	 * @return the bltAccYn
	 */
	public String getBltAccYn() {
		return bltAccYn;
	}
	/**
	 * @param bltAccYn the bltAccYn to set
	 */
	public void setBltAccYn(String bltAccYn) {
		this.bltAccYn = bltAccYn;
	}
	/**
	 * @return the toacLvel
	 */
	public int getToacLvel() {
		return toacLvel;
	}
	/**
	 * @param toacLvel the toacLvel to set
	 */
	public void setToacLvel(int toacLvel) {
		this.toacLvel = toacLvel;
	}
	/**
	 * @return the lvelIfrsAccNm
	 */
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	/**
	 * @param lvelIfrsAccNm the lvelIfrsAccNm to set
	 */
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}
	/**
	 * @return the uprIfrsAccCd
	 */
	public String getUprIfrsAccCd() {
		return uprIfrsAccCd;
	}
	/**
	 * @param uprIfrsAccCd the uprIfrsAccCd to set
	 */
	public void setUprIfrsAccCd(String uprIfrsAccCd) {
		this.uprIfrsAccCd = uprIfrsAccCd;
	}
	/**
	 * @return the scrnIndcOrd
	 */
	public int getScrnIndcOrd() {
		return scrnIndcOrd;
	}
	/**
	 * @param scrnIndcOrd the scrnIndcOrd to set
	 */
	public void setScrnIndcOrd(int scrnIndcOrd) {
		this.scrnIndcOrd = scrnIndcOrd;
	}
	/**
	 * @return the toacCd
	 */
	public String getToacCd() {
		return toacCd;
	}
	/**
	 * @param toacCd the toacCd to set
	 */
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}
	/**
	 * @return the jobDivCd
	 */
	public String getJobDivCd() {
		return jobDivCd;
	}
	/**
	 * @param jobDivCd the jobDivCd to set
	 */
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}





}

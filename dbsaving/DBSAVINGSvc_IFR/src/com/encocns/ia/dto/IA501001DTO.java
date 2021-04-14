/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501001DTO.java
 * @brief IFRS 계정코드 management List Query DTO
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


/**
 * @brief IFRS 계정코드 management List Query DTO
 * @details IFRS 계정코드 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA501001DTO {

	private String ifrsAccCd;                    /* IFRS계정코드 */
	private String aplcStrtDt;                   /* 적용시작일자 */
	private String aplcEndDt;                    /* 적용종료일자 */
	private String ifrsAccDcd;					 /* IFRS계정구분코드 */
	private String ifrsAccNm;                    /* IFRS계정명 */
	private String bltAccYn;                     /* 실계정여부 */
	private int toacLvel;                        /* 계정과목레벨 */
	private String lvelIfrsAccNm;                /* 레벨IFRS계정명 */
	private String uprIfrsAccCd;                 /* 상위IFRS계정코드 */
	private int scrnIndcOrd;                     /* 화면표시순서 */
	private String toacCd;                       /* KGAAP계정코드 */
	private String rNum;
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getAplcStrtDt() {
		return aplcStrtDt;
	}
	public void setAplcStrtDt(String aplcStrtDt) {
		this.aplcStrtDt = aplcStrtDt;
	}
	public String getAplcEndDt() {
		return aplcEndDt;
	}
	public void setAplcEndDt(String aplcEndDt) {
		this.aplcEndDt = aplcEndDt;
	}
	public String getIfrsAccDcd() {
		return ifrsAccDcd;
	}
	public void setIfrsAccDcd(String ifrsAccDcd) {
		this.ifrsAccDcd = ifrsAccDcd;
	}
	public String getIfrsAccNm() {
		return ifrsAccNm;
	}
	public void setIfrsAccNm(String ifrsAccNm) {
		this.ifrsAccNm = ifrsAccNm;
	}
	public String getBltAccYn() {
		return bltAccYn;
	}
	public void setBltAccYn(String bltAccYn) {
		this.bltAccYn = bltAccYn;
	}
	public int getToacLvel() {
		return toacLvel;
	}
	public void setToacLvel(int toacLvel) {
		this.toacLvel = toacLvel;
	}
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}
	public String getUprIfrsAccCd() {
		return uprIfrsAccCd;
	}
	public void setUprIfrsAccCd(String uprIfrsAccCd) {
		this.uprIfrsAccCd = uprIfrsAccCd;
	}
	public int getScrnIndcOrd() {
		return scrnIndcOrd;
	}
	public void setScrnIndcOrd(int scrnIndcOrd) {
		this.scrnIndcOrd = scrnIndcOrd;
	}
	public String getToacCd() {
		return toacCd;
	}
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

}

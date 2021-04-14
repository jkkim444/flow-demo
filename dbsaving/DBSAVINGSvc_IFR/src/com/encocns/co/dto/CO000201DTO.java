/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000201DTO.java
 * @brief 계정 코드 조회 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 계정 코드 조회 DTO
 * @details 계정 코드 조회 DTO
 * @author : 차상길
 * @date : 2020. 4. 21.
 * @version : 1.0.0
 */
public class CO000201DTO {

	private String toacCd;                           /* 계정코드 */
	private String ifrsAccCd;                        /* 코드 */
	private String ifrsAccNm;                        /* 계정명 */
	private String lvelIfrsAccNm;                    /* 계정명 */
	private String bltAccYn;                         /* 기표계정여부 */
	private int toacLvel;                            /* 계정과목레벨 */
	private String aplcStrtDt;                       /* 적용시작일자 */
	private String aplcEndDt;                        /* 적용종료일자 */

	// 공통 팝업용 변수
	private String cd;                               /* 코드 */
	private String nm;                               /* 이름 */

	public String getToacCd() {
		return toacCd;
	}
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
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
	public String getBltAccYn() {
		return bltAccYn;
	}
	public void setBltAccYn(String bltAccYn) {
		this.bltAccYn = bltAccYn;
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
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}

}

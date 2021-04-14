/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA502001DTO.java
 * @brief 제무제표 양식 management List Query DTO
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
 * @brief 제무제표 양식 management List Query DTO
 * @details 제무제표 양식 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA502001DTO {

	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String lvelIfrsAccNm;                    /* 레벨IFRS계정명 */
	private String ifrsAccNm;                        /* IFRS계정명 */
	private int toacLvel;                            /* 계정과목레벨 */
	private String uprIfrsAccCd;                     /* 상위IFRS계정코드 */
	private String scrnIndcOrd;                      /* 화면표시순서 */
	private String aplcStrtDt;                       /* 적용시작일자 */
	private String aplcEndDt;                        /* 적용종료일자 */
	private String ecalTpCd;                         /*	정산유형코드 */
	private String rNum;                             /*	행 번호 */

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
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
	public String getEcalTpCd() {
		return ecalTpCd;
	}
	public void setEcalTpCd(String ecalTpCd) {
		this.ecalTpCd = ecalTpCd;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}



}

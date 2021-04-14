/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file 매뉴 관리 등록 및 수정.java
 * @brief Menu Management IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.math.BigDecimal;

/**
 * @brief 매뉴 관리 등록 및 수정 IN
 * @details 매뉴 관리 등록 및 수정 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO201002IN {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String menuId;                        /* 메뉴ID */
	private String lclCd;                         /* 코드 */
	private String menuNm;                        /* 메뉴명 */
	private String hgrkMenuId;                    /* 상위메뉴ID */
	private BigDecimal menuSeq;                   /* 메뉴번호 */
	private BigDecimal menuLev;                   /* 메뉴레벨 */
	private String scrMrkYn;                      /* 화면표시여부 */
	private String scrId;                         /* 화면ID */
	private String scrNm;                         /* 화면명 */
	private String usrId;                         /* 사용자ID */
	private String jobDivCd;                      /* 코드 */

	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getHgrkMenuId() {
		return hgrkMenuId;
	}
	public void setHgrkMenuId(String hgrkMenuId) {
		this.hgrkMenuId = hgrkMenuId;
	}
	public BigDecimal getMenuSeq() {
		return menuSeq;
	}
	public void setMenuSeq(BigDecimal menuSeq) {
		this.menuSeq = menuSeq;
	}
	public BigDecimal getMenuLev() {
		return menuLev;
	}
	public void setMenuLev(BigDecimal menuLev) {
		this.menuLev = menuLev;
	}
	public String getScrMrkYn() {
		return scrMrkYn;
	}
	public void setScrMrkYn(String scrMrkYn) {
		this.scrMrkYn = scrMrkYn;
	}
	public String getScrId() {
		return scrId;
	}
	public void setScrId(String scrId) {
		this.scrId = scrId;
	}
	public String getScrNm() {
		return scrNm;
	}
	public void setScrNm(String scrNm) {
		this.scrNm = scrNm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}

}

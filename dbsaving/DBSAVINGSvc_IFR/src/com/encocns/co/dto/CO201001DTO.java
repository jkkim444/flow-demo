/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO201001DTO.java
 * @brief 메뉴 관리 화면 조회 DTO
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

import java.math.BigDecimal;

/**
 * @brief 메뉴 관리 화면 조회 DTO
 * @details 메뉴 관리 화면 조회 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO201001DTO {

	private String bizLclsCd;                     /* 업무대분류코드 */
	private String menuId;                        /* 메뉴ID */
	private String lclCd;                         /* 코드 */
	private String menuNm;                        /* 메뉴명 */
	private String hgrkMenuId;                    /* 상위메뉴ID */
	private BigDecimal menuSeq;                   /* 메뉴번호 */
	private BigDecimal menuLev;                   /* 메뉴레벨 */
	private String scrMrkYn;                      /* 화면표시여부 */
	private String scrId;                         /* 화면ID */
	private String scrNm;                         /* 화면명 */
	private String svcId;                         /* 서비스ID */
	private String rmkCntn;                       /* 비고 */

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
	public String getSvcId() {
		return svcId;
	}
	public void setSvcId(String svcId) {
		this.svcId = svcId;
	}
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}
}

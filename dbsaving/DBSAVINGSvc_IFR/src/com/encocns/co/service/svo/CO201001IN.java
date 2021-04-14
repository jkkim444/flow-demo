/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO201001IN.java
 * @brief 메뉴 관리 조회 IN
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

import java.util.List;
import java.util.Map;

/**
* @brief 메뉴 관리 조회 IN
* @details 메뉴 관리 조회 IN
* @author : 차상길
* @date : 2020. 11. 26.
* @version : 1.0.0
*/
public class CO201001IN {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String menuId;                        /* 메뉴ID */
	private String menuNm;                        /* 메뉴명 */
	private String scrId;                         /* 화면ID */
	private String scrNm;                         /* 화면명 */
	private String scrMrkYn;                      /* 화면표시여부 */
	private String searchText;                    /* 조회TEXT */
	private List<Map<?,?>> arrScrIdList;          /* 화면ID */
	private String lclCd;                         /* 코드 */
	private String usrId;                         /* 사용자ID */
	private int empno;                            /* 사원번호 */

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
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
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
	public String getScrMrkYn() {
		return scrMrkYn;
	}
	public void setScrMrkYn(String scrMrkYn) {
		this.scrMrkYn = scrMrkYn;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public List<Map<?, ?>> getArrScrIdList() {
		return arrScrIdList;
	}
	public void setArrScrIdList(List<Map<?, ?>> arrScrIdList) {
		this.arrScrIdList = arrScrIdList;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
}

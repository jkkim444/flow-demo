/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP208001IN.java
 * @brief 금대손충당금 대상 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

/**
 * @brief 대손충당금 대상 management IN
 * @details 대손충당금 대상 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP208001IN {
    private String searchStdrYm;                  /* 기준년월 */
    private String searchStdrYmEnd;               /* 기준년월 */

    private String cstno;                         /* 고객번호 */
    private String loanAcno;                      /* 대출계좌 */
    private String trgtValDtnCd;                  /* 대상검증코드 */
    private boolean otinOvrdYn;                   /* 타기관연체여부 */

    private int selectPage;                       /* 페이지 */
    private int pageSize;                         /* 페이지 사이즈 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getSearchStdrYmEnd() {
		return searchStdrYmEnd;
	}
	public void setSearchStdrYmEnd(String searchStdrYmEnd) {
		this.searchStdrYmEnd = searchStdrYmEnd;
	}
	public String getCstno() {
		return cstno;
	}
	public void setCstno(String cstno) {
		this.cstno = cstno;
	}
	public String getLoanAcno() {
		return loanAcno;
	}
	public void setLoanAcno(String loanAcno) {
		this.loanAcno = loanAcno;
	}
	public String getTrgtValDtnCd() {
		return trgtValDtnCd;
	}
	public void setTrgtValDtnCd(String trgtValDtnCd) {
		this.trgtValDtnCd = trgtValDtnCd;
	}
	public int getSelectPage() {
		return selectPage;
	}
	public void setSelectPage(int selectPage) {
		this.selectPage = selectPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public boolean isOtinOvrdYn() {
		return otinOvrdYn;
	}
	public void setOtinOvrdYn(boolean otinOvrdYn) {
		this.otinOvrdYn = otinOvrdYn;
	}
}

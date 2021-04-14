/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO00001DTO.java
 * @brief 홈화면 알림글 DTO
 * @section Major History
 * <pre>
 *   - 최호연 | 2020. 10. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 홈화면 알림글 DTO
 * @details 홈화면 알림글 DTO
 * @author : 최호연
 * @date : 2020. 10. 26.
 * @version : 1.0.0
 */
public class CO000002DTO {

	private String regDt;              /* 등록일자         */
	private int regSeqno;              /* 등록일련번호     */
	private String cmknFileCtnt;       /* 공지파일내용     */
	private String fileCpntId;	       /* 파일컴퍼넌트ID     */
	private String fileCpntIdY;	       /* 파일컴퍼넌트ID 여부*/
	private String iqryTmcnt;          /* 조회횟수         */
	private String cmknSrchDivCd;      /* 공지검색구분코드 */
	private String titl;               /* 제목             */
	private String noticeYn;           /* 공지사항 상단노출*/
	private String rNum;               /* 순번             */

	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public int getRegSeqno() {
		return regSeqno;
	}
	public void setRegSeqno(int regSeqno) {
		this.regSeqno = regSeqno;
	}
	public String getCmknFileCtnt() {
		return cmknFileCtnt;
	}
	public void setCmknFileCtnt(String cmknFileCtnt) {
		this.cmknFileCtnt = cmknFileCtnt;
	}
	public String getIqryTmcnt() {
		return iqryTmcnt;
	}
	public void setIqryTmcnt(String iqryTmcnt) {
		this.iqryTmcnt = iqryTmcnt;
	}
	public String getCmknSrchDivCd() {
		return cmknSrchDivCd;
	}
	public void setCmknSrchDivCd(String cmknSrchDivCd) {
		this.cmknSrchDivCd = cmknSrchDivCd;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getNoticeYn() {
		return noticeYn;
	}
	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getFileCpntId() {
		return fileCpntId;
	}
	public void setFileCpntId(String fileCpntId) {
		this.fileCpntId = fileCpntId;
	}
	public String getFileCpntIdY() {
		return fileCpntIdY;
	}
	public void setFileCpntIdY(String fileCpntIdY) {
		this.fileCpntIdY = fileCpntIdY;
	}


}

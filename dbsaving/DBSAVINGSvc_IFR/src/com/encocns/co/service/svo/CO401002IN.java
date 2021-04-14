/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO401002IN.java
 * @brief 공지사항 등록 및 수정 IN
 * @section Major History
 * <pre>
 *   - 최호연 | 2020. 10. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 공지사항 등록 및 수정 IN
 * @details 공지사항 등록 및 수정 IN
 * @author : 최호연
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class CO401002IN {

	private String cmknSrchDivCd;      /* 공지검색구분코드 */
	private String titl;               /* 제목             */
	private String fileCpntId;	       /* 파일컴퍼넌트ID     */
	private String noticeYn;           /* 공지사항 상단노출*/
	private String regDt;              /* 등록일자         */
	private String cmknFileCtnt;       /* 공지파일내용     */
	private String iqryTmcnt;          /* 조회횟수         */
	private String rNum;               /* 순번             */
	private int    regSeqno;           /* 등록일련번호     */
	private String jobDivCd;           /* 등록 및 수정코드 */
	private String usrId;

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
	public String getFileCpntId() {
		return fileCpntId;
	}
	public void setFileCpntId(String fileCpntId) {
		this.fileCpntId = fileCpntId;
	}
	public String getNoticeYn() {
		return noticeYn;
	}
	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
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
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public int getRegSeqno() {
		return regSeqno;
	}
	public void setRegSeqno(int regSeqno) {
		this.regSeqno = regSeqno;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}

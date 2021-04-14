/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO401003IN.java
 * @brief 공지사항 삭제 IN
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
 * @brief 공지사항 삭제 IN
 * @details 공지사항 삭제 IN
 * @author : 최호연
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class CO401003IN {

	private String regDt;
	private int regSeqno;
	private String iqryTmcnt;
	private String fileCpntId;

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
	public String getIqryTmcnt() {
		return iqryTmcnt;
	}
	public void setIqryTmcnt(String iqryTmcnt) {
		this.iqryTmcnt = iqryTmcnt;
	}
	public String getFileCpntId() {
		return fileCpntId;
	}
	public void setFileCpntId(String fileCpntId) {
		this.fileCpntId = fileCpntId;
	}
}

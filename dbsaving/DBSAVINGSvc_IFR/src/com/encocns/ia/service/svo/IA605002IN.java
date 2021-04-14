/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002IN.java
 * @brief IFRS 계정코드 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;
import java.util.List;

import com.encocns.ia.dto.IA605001DTO;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA605002IN {

	private String baseYm;                           /* 기준년도 */
	private BigDecimal seqno;                        /* 일련번호 */
	private String acntDiv;                          /* 계정구분 */
	private String itmsDivCtnt;                      /* 종목구분내용 */
	private BigDecimal totAset;                      /* 총자산 */
	private BigDecimal acbkAmt;                      /* 장부금액 */
	private String usrId;
	private List<IA605001DTO> arrList;				 /* 그리드 데이터 */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public BigDecimal getSeqno() {
		return seqno;
	}
	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
	}
	public String getAcntDiv() {
		return acntDiv;
	}
	public void setAcntDiv(String acntDiv) {
		this.acntDiv = acntDiv;
	}
	public String getItmsDivCtnt() {
		return itmsDivCtnt;
	}
	public void setItmsDivCtnt(String itmsDivCtnt) {
		this.itmsDivCtnt = itmsDivCtnt;
	}
	public BigDecimal getTotAset() {
		return totAset;
	}
	public void setTotAset(BigDecimal totAset) {
		this.totAset = totAset;
	}
	public BigDecimal getAcbkAmt() {
		return acbkAmt;
	}
	public void setAcbkAmt(BigDecimal acbkAmt) {
		this.acbkAmt = acbkAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public List<IA605001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA605001DTO> arrList) {
		this.arrList = arrList;
	}

}

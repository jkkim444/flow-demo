/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA501001IN.java
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

/**
 * @brief IFRS 수정분개 관리_팝업 management IN
 * @details IFRS 수정분개 관리_팝업 management IN
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA530101IN {
	private String JlzYm ;                           /* 분개년월 */
	private String jrlzBzwkCd;                       /* 분개업무구분코드 */
	private String jrlzBzwkDtlCd;                    /* 분개업무상세코드 */
	private BigDecimal Seqno ;               		 /* 순번 */

	public String getJlzYm() {
		return JlzYm;
	}
	public void setJlzYm(String jlzYm) {
		JlzYm = jlzYm;
	}
	public String getJrlzBzwkDtlCd() {
		return jrlzBzwkDtlCd;
	}
	public void setJrlzBzwkDtlCd(String jrlzBzwkDtlCd) {
		this.jrlzBzwkDtlCd = jrlzBzwkDtlCd;
	}
	public BigDecimal getSeqno() {
		return Seqno;
	}
	public void setSeqno(BigDecimal seqno) {
		Seqno = seqno;
	}
	public String getJrlzBzwkCd() {
		return jrlzBzwkCd;
	}
	public void setJrlzBzwkCd(String jrlzBzwkCd) {
		this.jrlzBzwkCd = jrlzBzwkCd;
	}
}

/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501003IN.java
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
 * @brief IFRS 마감정보관리 management IN
 * @details IFRS 마감정보관리 management IN
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA530003IN {

	private String jlzYm ;                           /* 분개년월 */
	private BigDecimal amndSeqno;                    /* 수정일련번호 */
	private String jrlzBzwkCd;                       /* 분개업무구분코드 */

	public String getJlzYm() {
		return jlzYm;
	}
	public void setJlzYm(String jlzYm) {
		this.jlzYm = jlzYm;
	}
	public BigDecimal getAmndSeqno() {
		return amndSeqno;
	}
	public void setAmndSeqno(BigDecimal amndSeqno) {
		this.amndSeqno = amndSeqno;
	}
	public String getJrlzBzwkCd() {
		return jrlzBzwkCd;
	}
	public void setJrlzBzwkCd(String jrlzBzwkCd) {
		this.jrlzBzwkCd = jrlzBzwkCd;
	}

}

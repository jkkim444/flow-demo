/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515003IN.java
 * @brief 임차시설물 복구충당부채 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 임차시설물 복구충당부채 management IN
 * @details 임차시설물 복구충당부채 management IN
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA523003IN {

	private String stdrYm;                           /* 기준년월 */
	private int seqno;                               /* 일련번호 */

	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}

}

/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA501001IN.java
 * @brief IFRS 수정분개관리 management IN
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 28. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief IFRS 수정분개관리 management IN
 * @details IFRS 수정분개관리 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 28.
 * @version : 1.0.0
 */
public class IA530001IN {
    private String searchJlzYm;				/* 분개년월 */
    private String usrId;					/* 사용자ID */

	public String getSearchJlzYm() {
		return searchJlzYm;
	}
	public void setSearchJlzYm(String searchJlzYm) {
		this.searchJlzYm = searchJlzYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}

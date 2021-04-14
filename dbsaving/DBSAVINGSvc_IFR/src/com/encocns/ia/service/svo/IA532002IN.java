/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA532002IN.java
 * @brief KGAAP 계정코드 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief KGAAP 계정코드 management IN
 * @details KGAAP 계정코드 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA532002IN {

	private String toacCd;                           /* KGAAP계정코드 */
	private String toacNm;                           /* KGAAP계정명 */
	private String uprnToacCd;                       /* 상위KGAAP계정코드 */
	private String ifrsAccCd;                        /* IFRS계정코드 */

	private String usrId;                            /* 사용자ID */
	private String jobDivCd;                         /* 등록수정구분코드 */

	public String getToacCd() {
		return toacCd;
	}

	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}

	public String getToacNm() {
		return toacNm;
	}

	public void setToacNm(String toacNm) {
		this.toacNm = toacNm;
	}

	public String getUprnToacCd() {
		return uprnToacCd;
	}

	public void setUprnToacCd(String uprnToacCd) {
		this.uprnToacCd = uprnToacCd;
	}

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}

	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getJobDivCd() {
		return jobDivCd;
	}

	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}

}

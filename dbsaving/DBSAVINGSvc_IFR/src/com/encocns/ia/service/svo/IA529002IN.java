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

/**
 * @brief IFRS 마감정보관리 management IN
 * @details IFRS 마감정보관리 management IN
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA529002IN {

	private String baseYm;	      /*	기준년도        */
	private String fnafOpngDtm;   /*    재무개시일시    */
	private String adjsClsnDtm;   /*    정산마감일시    */
	private String fnstClsnDtm;   /*    재무제표마감일시*/
	private String icsClsnDtm;	  /*    포괄마감일시    */
	private String pbnfClsnDtm;   /* 	공시 마감일시   */

	private String bassCrtn1Yn;   /*	기초생성여부1   */
	private String bassCrtn2Yn;   /*	기초생성여부2   */
	private String bassCrtn3Yn;   /*	기초생성여부3   */
	private String bassCrtn4Yn;   /*	기초생성여부4   */
	private String bassCrtn5Yn;   /*	기초생성여부5   */
	private String bassCrtn6Yn;   /*	기초생성여부6   */
	private String bassCrtn7Yn;   /*	기초생성여부7   */
	private String bassCrtn8Yn;   /*	기초생성여부8   */
	private String bassCrtn9Yn;   /*	기초생성여부9   */
	private String bassCrtn10Yn;  /*	기초생성여부10  */
	private String bassCrtn11Yn;  /*	기초생성여부11  */
	private String bassCrtn12Yn;  /*	기초생성여부12  */
	private String usrId;		  /* 사용자ID */

	private String jobDivCd;      /* 작업구분코드(U,I) */

	public String getBaseYm() {
		return baseYm;
	}

	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}

	public String getFnafOpngDtm() {
		return fnafOpngDtm;
	}

	public void setFnafOpngDtm(String fnafOpngDtm) {
		this.fnafOpngDtm = fnafOpngDtm;
	}

	public String getAdjsClsnDtm() {
		return adjsClsnDtm;
	}

	public void setAdjsClsnDtm(String adjsClsnDtm) {
		this.adjsClsnDtm = adjsClsnDtm;
	}

	public String getFnstClsnDtm() {
		return fnstClsnDtm;
	}

	public void setFnstClsnDtm(String fnstClsnDtm) {
		this.fnstClsnDtm = fnstClsnDtm;
	}

	public String getIcsClsnDtm() {
		return icsClsnDtm;
	}

	public void setIcsClsnDtm(String icsClsnDtm) {
		this.icsClsnDtm = icsClsnDtm;
	}

	public String getPbnfClsnDtm() {
		return pbnfClsnDtm;
	}

	public void setPbnfClsnDtm(String pbnfClsnDtm) {
		this.pbnfClsnDtm = pbnfClsnDtm;
	}

	public String getBassCrtn1Yn() {
		return bassCrtn1Yn;
	}

	public void setBassCrtn1Yn(String bassCrtn1Yn) {
		this.bassCrtn1Yn = bassCrtn1Yn;
	}

	public String getBassCrtn2Yn() {
		return bassCrtn2Yn;
	}

	public void setBassCrtn2Yn(String bassCrtn2Yn) {
		this.bassCrtn2Yn = bassCrtn2Yn;
	}

	public String getBassCrtn3Yn() {
		return bassCrtn3Yn;
	}

	public void setBassCrtn3Yn(String bassCrtn3Yn) {
		this.bassCrtn3Yn = bassCrtn3Yn;
	}

	public String getBassCrtn4Yn() {
		return bassCrtn4Yn;
	}

	public void setBassCrtn4Yn(String bassCrtn4Yn) {
		this.bassCrtn4Yn = bassCrtn4Yn;
	}

	public String getBassCrtn5Yn() {
		return bassCrtn5Yn;
	}

	public void setBassCrtn5Yn(String bassCrtn5Yn) {
		this.bassCrtn5Yn = bassCrtn5Yn;
	}

	public String getBassCrtn6Yn() {
		return bassCrtn6Yn;
	}

	public void setBassCrtn6Yn(String bassCrtn6Yn) {
		this.bassCrtn6Yn = bassCrtn6Yn;
	}

	public String getBassCrtn7Yn() {
		return bassCrtn7Yn;
	}

	public void setBassCrtn7Yn(String bassCrtn7Yn) {
		this.bassCrtn7Yn = bassCrtn7Yn;
	}

	public String getBassCrtn8Yn() {
		return bassCrtn8Yn;
	}

	public void setBassCrtn8Yn(String bassCrtn8Yn) {
		this.bassCrtn8Yn = bassCrtn8Yn;
	}

	public String getBassCrtn9Yn() {
		return bassCrtn9Yn;
	}

	public void setBassCrtn9Yn(String bassCrtn9Yn) {
		this.bassCrtn9Yn = bassCrtn9Yn;
	}

	public String getBassCrtn10Yn() {
		return bassCrtn10Yn;
	}

	public void setBassCrtn10Yn(String bassCrtn10Yn) {
		this.bassCrtn10Yn = bassCrtn10Yn;
	}

	public String getBassCrtn11Yn() {
		return bassCrtn11Yn;
	}

	public void setBassCrtn11Yn(String bassCrtn11Yn) {
		this.bassCrtn11Yn = bassCrtn11Yn;
	}

	public String getBassCrtn12Yn() {
		return bassCrtn12Yn;
	}

	public void setBassCrtn12Yn(String bassCrtn12Yn) {
		this.bassCrtn12Yn = bassCrtn12Yn;
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

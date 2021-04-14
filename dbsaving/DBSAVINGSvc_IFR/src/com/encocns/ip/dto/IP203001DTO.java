/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP203001DTO.java
 * @brief NICE PD관리 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;

/**
 * @brief NICE PD관리 management List Query DTO
 * @details NICE PD관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP203001DTO {

	private String rNum;				 /* 행번호 */
	private String stdrYm;               /* 기준년월 */
    private String crgdCd;               /* 신용등급 코드 */
    private double pdRate1;              /* PD비율1 */
    private double pdRate2;              /* PD비율2 */
    private double pdRate3;              /* PD비율3 */
    private double pdRate4;              /* PD비율4 */
    private double pdRate5;              /* PD비율5 */

    private String delYn;				 /* 삭제여부 */

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getCrgdCd() {
		return crgdCd;
	}
	public void setCrgdCd(String crgdCd) {
		this.crgdCd = crgdCd;
	}
	public double getPdRate1() {
		return pdRate1;
	}
	public void setPdRate1(double pdRate1) {
		this.pdRate1 = pdRate1;
	}
	public double getPdRate2() {
		return pdRate2;
	}
	public void setPdRate2(double pdRate2) {
		this.pdRate2 = pdRate2;
	}
	public double getPdRate3() {
		return pdRate3;
	}
	public void setPdRate3(double pdRate3) {
		this.pdRate3 = pdRate3;
	}
	public double getPdRate4() {
		return pdRate4;
	}
	public void setPdRate4(double pdRate4) {
		this.pdRate4 = pdRate4;
	}
	public double getPdRate5() {
		return pdRate5;
	}
	public void setPdRate5(double pdRate5) {
		this.pdRate5 = pdRate5;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

}

/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA522002IN.java
 * @brief 임차시설물 복구비용 추정 management IN
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

import java.math.BigDecimal;

/**
 * @brief 임차시설물 복구비용 추정 management IN
 * @details 임차시설물 복구비용 추정 management IN
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA522002IN {

	private String stdrYm;                /*    기준년월       */
	private BigDecimal areRcost;          /*    면적복구비용   */
	private double prceIrrt;              /*    물가상승률     */
	private int    rentTrmCnt;	          /*    임차기간년수   */
	private double rcvrDcrt12;	          /* 	복구할인율12   */
	private double rcvrDcrt24;	          /* 	복구할인율24   */
	private double rcvrDcrt36;	          /* 	복구할인율36   */
	private double rcvrDcrt48;	          /* 	복구할인율48   */
	private double rcvrDcrt60;	          /* 	복구할인율60   */
	private double rcvrDcrt72;	          /* 	복구할인율72   */
	private double rcvrDcrt84;	          /* 	복구할인율84   */
	private double rcvrDcrt96;	          /* 	복구할인율96   */
	private double rcvrDcrt108;	          /* 	복구할인율108  */
	private double rcvrDcrt120;           /* 	복구할인율120  */
	private String jobDivCd;			  /* 등록수정구분코드 */
	private String usrId;				  /* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public BigDecimal getAreRcost() {
		return areRcost;
	}
	public void setAreRcost(BigDecimal areRcost) {
		this.areRcost = areRcost;
	}
	public double getPrceIrrt() {
		return prceIrrt;
	}
	public void setPrceIrrt(double prceIrrt) {
		this.prceIrrt = prceIrrt;
	}
	public int getRentTrmCnt() {
		return rentTrmCnt;
	}
	public void setRentTrmCnt(int rentTrmCnt) {
		this.rentTrmCnt = rentTrmCnt;
	}
	public double getRcvrDcrt12() {
		return rcvrDcrt12;
	}
	public void setRcvrDcrt12(double rcvrDcrt12) {
		this.rcvrDcrt12 = rcvrDcrt12;
	}
	public double getRcvrDcrt24() {
		return rcvrDcrt24;
	}
	public void setRcvrDcrt24(double rcvrDcrt24) {
		this.rcvrDcrt24 = rcvrDcrt24;
	}
	public double getRcvrDcrt36() {
		return rcvrDcrt36;
	}
	public void setRcvrDcrt36(double rcvrDcrt36) {
		this.rcvrDcrt36 = rcvrDcrt36;
	}
	public double getRcvrDcrt48() {
		return rcvrDcrt48;
	}
	public void setRcvrDcrt48(double rcvrDcrt48) {
		this.rcvrDcrt48 = rcvrDcrt48;
	}
	public double getRcvrDcrt60() {
		return rcvrDcrt60;
	}
	public void setRcvrDcrt60(double rcvrDcrt60) {
		this.rcvrDcrt60 = rcvrDcrt60;
	}
	public double getRcvrDcrt72() {
		return rcvrDcrt72;
	}
	public void setRcvrDcrt72(double rcvrDcrt72) {
		this.rcvrDcrt72 = rcvrDcrt72;
	}
	public double getRcvrDcrt84() {
		return rcvrDcrt84;
	}
	public void setRcvrDcrt84(double rcvrDcrt84) {
		this.rcvrDcrt84 = rcvrDcrt84;
	}
	public double getRcvrDcrt96() {
		return rcvrDcrt96;
	}
	public void setRcvrDcrt96(double rcvrDcrt96) {
		this.rcvrDcrt96 = rcvrDcrt96;
	}
	public double getRcvrDcrt108() {
		return rcvrDcrt108;
	}
	public void setRcvrDcrt108(double rcvrDcrt108) {
		this.rcvrDcrt108 = rcvrDcrt108;
	}
	public double getRcvrDcrt120() {
		return rcvrDcrt120;
	}
	public void setRcvrDcrt120(double rcvrDcrt120) {
		this.rcvrDcrt120 = rcvrDcrt120;
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

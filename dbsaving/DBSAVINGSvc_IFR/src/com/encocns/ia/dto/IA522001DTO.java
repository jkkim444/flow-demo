/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA522001DTO.java
 * @brief 임차시설물 복구비용 추정 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 임차시설물 복구비용 추정 management List Query DTO
 * @details 임차시설물 복구비용 추정 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA522001DTO {

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

	private String rNum;

	/**
	 * @return the stdrYm
	 */
	public String getStdrYm() {
		return stdrYm;
	}

	/**
	 * @param stdrYm the stdrYm to set
	 */
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}

	/**
	 * @return the areRcost
	 */
	public BigDecimal getAreRcost() {
		return areRcost;
	}

	/**
	 * @param areRcost the areRcost to set
	 */
	public void setAreRcost(BigDecimal areRcost) {
		this.areRcost = areRcost;
	}

	/**
	 * @return the prceIrrt
	 */
	public double getPrceIrrt() {
		return prceIrrt;
	}

	/**
	 * @param prceIrrt the prceIrrt to set
	 */
	public void setPrceIrrt(double prceIrrt) {
		this.prceIrrt = prceIrrt;
	}

	/**
	 * @return the rentTrmCnt
	 */
	public int getRentTrmCnt() {
		return rentTrmCnt;
	}

	/**
	 * @param rentTrmCnt the rentTrmCnt to set
	 */
	public void setRentTrmCnt(int rentTrmCnt) {
		this.rentTrmCnt = rentTrmCnt;
	}

	/**
	 * @return the rcvrDcrt12
	 */
	public double getRcvrDcrt12() {
		return rcvrDcrt12;
	}

	/**
	 * @param rcvrDcrt12 the rcvrDcrt12 to set
	 */
	public void setRcvrDcrt12(double rcvrDcrt12) {
		this.rcvrDcrt12 = rcvrDcrt12;
	}

	/**
	 * @return the rcvrDcrt24
	 */
	public double getRcvrDcrt24() {
		return rcvrDcrt24;
	}

	/**
	 * @param rcvrDcrt24 the rcvrDcrt24 to set
	 */
	public void setRcvrDcrt24(double rcvrDcrt24) {
		this.rcvrDcrt24 = rcvrDcrt24;
	}

	/**
	 * @return the rcvrDcrt36
	 */
	public double getRcvrDcrt36() {
		return rcvrDcrt36;
	}

	/**
	 * @param rcvrDcrt36 the rcvrDcrt36 to set
	 */
	public void setRcvrDcrt36(double rcvrDcrt36) {
		this.rcvrDcrt36 = rcvrDcrt36;
	}

	/**
	 * @return the rcvrDcrt48
	 */
	public double getRcvrDcrt48() {
		return rcvrDcrt48;
	}

	/**
	 * @param rcvrDcrt48 the rcvrDcrt48 to set
	 */
	public void setRcvrDcrt48(double rcvrDcrt48) {
		this.rcvrDcrt48 = rcvrDcrt48;
	}

	/**
	 * @return the rcvrDcrt60
	 */
	public double getRcvrDcrt60() {
		return rcvrDcrt60;
	}

	/**
	 * @param rcvrDcrt60 the rcvrDcrt60 to set
	 */
	public void setRcvrDcrt60(double rcvrDcrt60) {
		this.rcvrDcrt60 = rcvrDcrt60;
	}

	/**
	 * @return the rcvrDcrt72
	 */
	public double getRcvrDcrt72() {
		return rcvrDcrt72;
	}

	/**
	 * @param rcvrDcrt72 the rcvrDcrt72 to set
	 */
	public void setRcvrDcrt72(double rcvrDcrt72) {
		this.rcvrDcrt72 = rcvrDcrt72;
	}

	/**
	 * @return the rcvrDcrt84
	 */
	public double getRcvrDcrt84() {
		return rcvrDcrt84;
	}

	/**
	 * @param rcvrDcrt84 the rcvrDcrt84 to set
	 */
	public void setRcvrDcrt84(double rcvrDcrt84) {
		this.rcvrDcrt84 = rcvrDcrt84;
	}

	/**
	 * @return the rcvrDcrt96
	 */
	public double getRcvrDcrt96() {
		return rcvrDcrt96;
	}

	/**
	 * @param rcvrDcrt96 the rcvrDcrt96 to set
	 */
	public void setRcvrDcrt96(double rcvrDcrt96) {
		this.rcvrDcrt96 = rcvrDcrt96;
	}

	/**
	 * @return the rcvrDcrt108
	 */
	public double getRcvrDcrt108() {
		return rcvrDcrt108;
	}

	/**
	 * @param rcvrDcrt108 the rcvrDcrt108 to set
	 */
	public void setRcvrDcrt108(double rcvrDcrt108) {
		this.rcvrDcrt108 = rcvrDcrt108;
	}

	/**
	 * @return the rcvrDcrt120
	 */
	public double getRcvrDcrt120() {
		return rcvrDcrt120;
	}

	/**
	 * @param rcvrDcrt120 the rcvrDcrt120 to set
	 */
	public void setRcvrDcrt120(double rcvrDcrt120) {
		this.rcvrDcrt120 = rcvrDcrt120;
	}

	/**
	 * @return the rNum
	 */
	public String getrNum() {
		return rNum;
	}

	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}




}

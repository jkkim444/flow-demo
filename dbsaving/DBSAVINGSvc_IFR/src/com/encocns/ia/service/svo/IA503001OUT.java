/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA503001OUT.java
 * @brief IFRS정산표 산출 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA503001DTO;

/**
 * @brief IFRS정산표 산출 management OUT
 * @details IFRS정산표 산출 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
public class IA503001OUT {

    private List<IA503001DTO> list;
    private String clsnCtnt;
    private String chkAmt01;    //6000000000 검증오류
    private String chkAmt02;	//8210136200 검증오류

	/**
	 * @return the list
	 */
	public List<IA503001DTO> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<IA503001DTO> list) {
		this.list = list;
	}
	/**
	 * @return the clsnCtnt
	 */
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	/**
	 * @param clsnCtnt the clsnCtnt to set
	 */
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
	/**
	 * @return the chkAmt01
	 */
	public String getChkAmt01() {
		return chkAmt01;
	}
	/**
	 * @param chkAmt01 the chkAmt01 to set
	 */
	public void setChkAmt01(String chkAmt01) {
		this.chkAmt01 = chkAmt01;
	}
	/**
	 * @return the chkAmt02
	 */
	public String getChkAmt02() {
		return chkAmt02;
	}
	/**
	 * @param chkAmt02 the chkAmt02 to set
	 */
	public void setChkAmt02(String chkAmt02) {
		this.chkAmt02 = chkAmt02;
	}


}

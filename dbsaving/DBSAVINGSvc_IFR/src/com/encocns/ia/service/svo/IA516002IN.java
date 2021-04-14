/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515002IN.java
 * @brief 퇴직금 지급 현황 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;
import java.util.List;

import com.encocns.ia.dto.IA516002DTO;

/**
 * @brief 퇴직금 지급 현황 management IN
 * @details 퇴직금 지급 현황 management IN
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA516002IN {

	private String stdrYm;                           /* 전기년월 */
	private BigDecimal yrThtrWorkPmcs;               /* 년도당기근무원가 */
	private BigDecimal yrRetmSlryRsrv;               /* 년도확정급여채무이자원가 */
	private BigDecimal yrInstlAsetIntEarn;           /* 년도사외적립자산이자수익 */
	private BigDecimal yrFrmRetmSlry;                /* 확정기여형퇴직급여 */
	private List<IA516002DTO> arrGridData;           /* 조회내역 */
	private String usrId;                            /* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public BigDecimal getYrThtrWorkPmcs() {
		return yrThtrWorkPmcs;
	}
	public void setYrThtrWorkPmcs(BigDecimal yrThtrWorkPmcs) {
		this.yrThtrWorkPmcs = yrThtrWorkPmcs;
	}
	public BigDecimal getYrRetmSlryRsrv() {
		return yrRetmSlryRsrv;
	}
	public void setYrRetmSlryRsrv(BigDecimal yrRetmSlryRsrv) {
		this.yrRetmSlryRsrv = yrRetmSlryRsrv;
	}
	public BigDecimal getYrInstlAsetIntEarn() {
		return yrInstlAsetIntEarn;
	}
	public void setYrInstlAsetIntEarn(BigDecimal yrInstlAsetIntEarn) {
		this.yrInstlAsetIntEarn = yrInstlAsetIntEarn;
	}
	public BigDecimal getYrFrmRetmSlry() {
		return yrFrmRetmSlry;
	}
	public void setYrFrmRetmSlry(BigDecimal yrFrmRetmSlry) {
		this.yrFrmRetmSlry = yrFrmRetmSlry;
	}
	public List<IA516002DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IA516002DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}

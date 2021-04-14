/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP207001DTO.java
 * @brief 예치금대손충당금 기본 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;

import java.math.BigDecimal;

/**
 * @brief 예치금대손충당금 기본 management List Query DTO
 * @details 예치금대손충당금 기본 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP212001DTO {

    private String stdrYm;                      /* 기준년월 */
    private String frtrYm;                      /* 전기년월 */
	private String cdNm;                        /* 대손충당금요약구분코드 명 */

	private String chgAmtDivCd;           		/* 변동금액구분코드 */
	private String badlnRsrvBrfDivCd;           /* 대손충당금요약구분코드 */
	private BigDecimal credLssMsrAmt;           /* 신용손실측정금액 */
	private BigDecimal imprAsetAmt1;            /* 손상되지자산금액 */
	private BigDecimal imprAsetAmt2;            /* 손상된자산금액 */
	private BigDecimal amtSum;					/* 금액 합계 */

    private String delYn;						/* 삭제여부 */

    private String usrId;						/* 사용자ID */
    private String rNum;						/* 행번호 */

    public String getStdrYm() {
        return stdrYm;
    }

    public void setStdrYm(String stdrYm) {
        this.stdrYm = stdrYm;
    }

    public String getFrtrYm() {
        return frtrYm;
    }

    public void setFrtrYm(String frtrYm) {
        this.frtrYm = frtrYm;
    }

    public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getChgAmtDivCd() {
		return chgAmtDivCd;
	}

	public void setChgAmtDivCd(String chgAmtDivCd) {
		this.chgAmtDivCd = chgAmtDivCd;
	}

	public String getBadlnRsrvBrfDivCd() {
        return badlnRsrvBrfDivCd;
    }

    public void setBadlnRsrvBrfDivCd(String badlnRsrvBrfDivCd) {
        this.badlnRsrvBrfDivCd = badlnRsrvBrfDivCd;
    }

    public BigDecimal getCredLssMsrAmt() {
		return credLssMsrAmt;
	}

	public void setCredLssMsrAmt(BigDecimal credLssMsrAmt) {
		this.credLssMsrAmt = credLssMsrAmt;
	}

	public BigDecimal getImprAsetAmt1() {
		return imprAsetAmt1;
	}

	public void setImprAsetAmt1(BigDecimal imprAsetAmt1) {
		this.imprAsetAmt1 = imprAsetAmt1;
	}

	public BigDecimal getImprAsetAmt2() {
		return imprAsetAmt2;
	}

	public void setImprAsetAmt2(BigDecimal imprAsetAmt2) {
		this.imprAsetAmt2 = imprAsetAmt2;
	}

	public BigDecimal getAmtSum() {
		return amtSum;
	}

	public void setAmtSum(BigDecimal amtSum) {
		this.amtSum = amtSum;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

}

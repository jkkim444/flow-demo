/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW102002IN.java
 * @brief Batch Management IN
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief Batch Management IN
 * @details Batch Management IN
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 19.
 * @version : 1.0.0
 */
public class FW102002IN {

	private String bizLclsCd;                        /* 업무구분코드 */
	private String batId;                            /* 배치ID */
	private String batNm;                            /* 배치명 */
	private String batDcd;                           /* 배치구분코드 */
	private String batClcyDcd;                       /* 배치주기구분코드 */
	private String batPath;                          /* 배치경로 */
	private String rmkCntn;                          /* 비고 */
	private String usrId;                            /* 사용자ID */

    public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	/**
     * @return the batId
     */
    public String getBatId() {
        return batId;
    }
    /**
     * @param batId the batId to set
     */
    public void setBatId(String batId) {
        this.batId = batId;
    }
    /**
     * @return the batNm
     */
    public String getBatNm() {
        return batNm;
    }
    /**
     * @param batNm the batNm to set
     */
    public void setBatNm(String batNm) {
        this.batNm = batNm;
    }
    /**
     * @return the batDcd
     */
    public String getBatDcd() {
        return batDcd;
    }
    /**
     * @param batDcd the batDcd to set
     */
    public void setBatDcd(String batDcd) {
        this.batDcd = batDcd;
    }
    /**
     * @return the batClcyDcd
     */
    public String getBatClcyDcd() {
        return batClcyDcd;
    }
    /**
     * @param batClcyDcd the batClcyDcd to set
     */
    public void setBatClcyDcd(String batClcyDcd) {
        this.batClcyDcd = batClcyDcd;
    }
    /**
     * @return the rmkCntn
     */
    public String getRmkCntn() {
        return rmkCntn;
    }
    /**
     * @param rmkCntn the rmkCntn to set
     */
    public void setRmkCntn(String rmkCntn) {
        this.rmkCntn = rmkCntn;
    }
    /**
     * @return the usrId
     */
    public String getUsrId() {
        return usrId;
    }
    /**
     * @param usrId the usrId to set
     */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }
	public String getBatPath() {
		return batPath;
	}
	public void setBatPath(String batPath) {
		this.batPath = batPath;
	}

}

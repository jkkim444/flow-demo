/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW102001DTO.java
 * @brief Batch Management List Query DTO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dto
 * @brief Common DTO Package
 */
package com.encocns.fw.dto;

/**
 * @brief Batch Management List Query DTO
 * @details Batch Management List Query DTO
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 19.
 * @version : 1.0.0
 */
public class FW102001DTO {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String batId;                         /* 배치ID */
	private String batNm;                         /* 배치명 */
	private String batDcd;                        /* 배치구분코드 */
	private String batClcyDcd;                    /* 배치주기구분코드 */
	private String batPath;                       /* 배치경로 */
	private String rmkCntn;                       /* 비고 */
	private String chgId;                         /* 변경ID */
	private String chgDtm;                        /* 변경일자 */

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
     * @return the chgId
     */
    public String getChgId() {
        return chgId;
    }
    /**
     * @param chgId the chgId to set
     */
    public void setChgId(String chgId) {
        this.chgId = chgId;
    }
    /**
     * @return the chgDtm
     */
    public String getChgDtm() {
        return chgDtm;
    }
    /**
     * @param chgDtm the chgDtm to set
     */
    public void setChgDtm(String chgDtm) {
        this.chgDtm = chgDtm;
    }
	public String getBatPath() {
		return batPath;
	}
	public void setBatPath(String batPath) {
		this.batPath = batPath;
	}

}

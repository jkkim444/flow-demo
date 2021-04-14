/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO00001DTO.java
 * @brief 홈화면 알림글 DTO
 * @section Major History
 * <pre>
 *   - 이좌형 | 2020. 1. 29. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 홈화면 알림글 DTO
 * @details 홈화면 알림글 DTO
 * @author : 이좌형
 * @date : 2020. 1. 29.
 * @version : 1.0.0
 */
public class CO000001DTO {

	private String cmknMtrTitl;                   /* 제목 */
	private String chgDate;                       /* 변경일자 */
	private String fileCpntId;                    /* 파일컴포넌트ID */
	private int fileSeq;                          /* 파일순번 */
	private String fileXtns;                      /* 확장자 */

	public String getCmknMtrTitl() {
		return cmknMtrTitl;
	}
	public void setCmknMtrTitl(String cmknMtrTitl) {
		this.cmknMtrTitl = cmknMtrTitl;
	}
	public String getChgDate() {
		return chgDate;
	}
	public void setChgDate(String chgDate) {
		this.chgDate = chgDate;
	}
	public String getFileCpntId() {
		return fileCpntId;
	}
	public void setFileCpntId(String fileCpntId) {
		this.fileCpntId = fileCpntId;
	}
	public int getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}
    public String getFileXtns() {
        return fileXtns;
    }
    public void setFileXtns(String fileXtns) {
        this.fileXtns = fileXtns;
    }

}

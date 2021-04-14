/**
 * @file ID201001DTO.java
 * @brief 공시보고서목록관리 DTO
 * @section Major History
 * <pre>
 *   - 차 상 길 | 2020. 9. 29. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.dto
 * @brief id DTO Package
 */
package com.encocns.id.dto;

/**
 * @brief 공시보고서목록관리 DTO
 * @details 공시보고서목록관리 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID201001DTO {
	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String cmtLevel;                         /* 주석레벨 */
	private int outputSer;                           /* 출력순서 */
	private String uprnPbnfRptId;                    /* 상위공시보고서ID */
	private String rptPbnfYn;                        /* 보고서공시여부 */
	private String mgmtUnitCd;                       /* 코드 */
	private String aplyStdt;                         /* 적용시작일자 */
	private String aplyEndt;                         /* 적용종료일자 */
	private String pbnfRptClcd;                      /* 코드 */
	private String rmkCtnt;                          /* 비고내용 */
	private String uprnPbnfRptNm;                    /* 공시보고서명 */
	private String rptFinText;

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getPbnfRptId() {
		return pbnfRptId;
	}
	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}
	public String getPbnfRptNm() {
		return pbnfRptNm;
	}
	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}
	public String getCmtLevel() {
		return cmtLevel;
	}
	public void setCmtLevel(String cmtLevel) {
		this.cmtLevel = cmtLevel;
	}
	public int getOutputSer() {
		return outputSer;
	}
	public void setOutputSer(int outputSer) {
		this.outputSer = outputSer;
	}
	public String getUprnPbnfRptId() {
		return uprnPbnfRptId;
	}
	public void setUprnPbnfRptId(String uprnPbnfRptId) {
		this.uprnPbnfRptId = uprnPbnfRptId;
	}
	public String getRptPbnfYn() {
		return rptPbnfYn;
	}
	public void setRptPbnfYn(String rptPbnfYn) {
		this.rptPbnfYn = rptPbnfYn;
	}
	public String getMgmtUnitCd() {
		return mgmtUnitCd;
	}
	public void setMgmtUnitCd(String mgmtUnitCd) {
		this.mgmtUnitCd = mgmtUnitCd;
	}
	public String getAplyStdt() {
		return aplyStdt;
	}
	public void setAplyStdt(String aplyStdt) {
		this.aplyStdt = aplyStdt;
	}
	public String getAplyEndt() {
		return aplyEndt;
	}
	public void setAplyEndt(String aplyEndt) {
		this.aplyEndt = aplyEndt;
	}
	public String getPbnfRptClcd() {
		return pbnfRptClcd;
	}
	public void setPbnfRptClcd(String pbnfRptClcd) {
		this.pbnfRptClcd = pbnfRptClcd;
	}
	public String getRmkCtnt() {
		return rmkCtnt;
	}
	public void setRmkCtnt(String rmkCtnt) {
		this.rmkCtnt = rmkCtnt;
	}
	public String getUprnPbnfRptNm() {
		return uprnPbnfRptNm;
	}
	public void setUprnPbnfRptNm(String uprnPbnfRptNm) {
		this.uprnPbnfRptNm = uprnPbnfRptNm;
	}
	public String getRptFinText() {
		return rptFinText;
	}
	public void setRptFinText(String rptFinText) {
		this.rptFinText = rptFinText;
	}

}

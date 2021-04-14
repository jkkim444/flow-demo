/**
 * @file ID203001DTO.java
 * @brief 공시보고서검증 DTO
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
 * @brief 공시보고서검증 DTO
 * @details 공시보고서검증 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID203001DTO {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String uprnPbnfRptNm;                    /* 공시보고서명 */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private int totCnt;                              /* 총 건수 */
	private int yCnt;                                /* 성공 건수 */
	private int nCnt;                                /* 실패 건수 */

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
	public String getUprnPbnfRptNm() {
		return uprnPbnfRptNm;
	}
	public void setUprnPbnfRptNm(String uprnPbnfRptNm) {
		this.uprnPbnfRptNm = uprnPbnfRptNm;
	}
	public String getPbnfRptNm() {
		return pbnfRptNm;
	}
	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public int getyCnt() {
		return yCnt;
	}
	public void setyCnt(int yCnt) {
		this.yCnt = yCnt;
	}
	public int getnCnt() {
		return nCnt;
	}
	public void setnCnt(int nCnt) {
		this.nCnt = nCnt;
	}
}

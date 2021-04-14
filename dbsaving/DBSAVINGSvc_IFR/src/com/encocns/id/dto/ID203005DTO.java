/**
 * @file ID203005DTO.java
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
public class ID203005DTO {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String cellId;                           /* 셀ID */
	private String valdtnItemDvcd;                   /* 검증항목구분코드 */
	private String valdtnIstgId;                     /* 검증대상ID */
	private String valdtnIstgNm;					 /* 검증대상명 */
	private String valdtnIstgVal;                    /* 검증대상값 */
	private String valdtnVal;                        /* 검증값 */
	private String signDvcd;                         /* 부호구분코드 */
	private int rowNo;                               /* 로우번호 */
	private int colNo;                               /* 컬럼번호 */

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
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getValdtnItemDvcd() {
		return valdtnItemDvcd;
	}
	public void setValdtnItemDvcd(String valdtnItemDvcd) {
		this.valdtnItemDvcd = valdtnItemDvcd;
	}
	public String getValdtnIstgId() {
		return valdtnIstgId;
	}
	public void setValdtnIstgId(String valdtnIstgId) {
		this.valdtnIstgId = valdtnIstgId;
	}
	public String getValdtnIstgNm() {
		return valdtnIstgNm;
	}
	public void setValdtnIstgNm(String valdtnIstgNm) {
		this.valdtnIstgNm = valdtnIstgNm;
	}
	public String getValdtnIstgVal() {
		return valdtnIstgVal;
	}
	public void setValdtnIstgVal(String valdtnIstgVal) {
		this.valdtnIstgVal = valdtnIstgVal;
	}
	public String getValdtnVal() {
		return valdtnVal;
	}
	public void setValdtnVal(String valdtnVal) {
		this.valdtnVal = valdtnVal;
	}
	public String getSignDvcd() {
		return signDvcd;
	}
	public void setSignDvcd(String signDvcd) {
		this.signDvcd = signDvcd;
	}
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public int getColNo() {
		return colNo;
	}
	public void setColNo(int colNo) {
		this.colNo = colNo;
	}
	public String getPbnfRptNm() {
		return pbnfRptNm;
	}
	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}

}
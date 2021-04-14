/**
 * @file ID104003DTO.java
 * @brief 산출기준관리 DTO
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
 * @brief 산출기준관리 DTO
 * @details 산출기준관리 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID104003DTO {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String cellId;                           /* 셀ID */
	private String clclMthdDvcd;                     /* 산출방법구분코드 */
	private String clclIstgId;                       /* 산출대상ID */
	private String clclIstgNm;                       /* 산출대상명 */
	private String clclVal;                          /* 산출값 */
	private String rmk;                              /* 비고 */
	private String clclValDvcd;                      /* 산출값구분코드 */
	private String signDvcd;                         /* 부호구분코드 */
	private String usrId;                            /* 사용자ID */
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
	public String getClclMthdDvcd() {
		return clclMthdDvcd;
	}
	public void setClclMthdDvcd(String clclMthdDvcd) {
		this.clclMthdDvcd = clclMthdDvcd;
	}
	public String getClclIstgId() {
		return clclIstgId;
	}
	public void setClclIstgId(String clclIstgId) {
		this.clclIstgId = clclIstgId;
	}
	public String getClclVal() {
		return clclVal;
	}
	public void setClclVal(String clclVal) {
		this.clclVal = clclVal;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getClclValDvcd() {
		return clclValDvcd;
	}
	public void setClclValDvcd(String clclValDvcd) {
		this.clclValDvcd = clclValDvcd;
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
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getClclIstgNm() {
		return clclIstgNm;
	}
	public void setClclIstgNm(String clclIstgNm) {
		this.clclIstgNm = clclIstgNm;
	}

}

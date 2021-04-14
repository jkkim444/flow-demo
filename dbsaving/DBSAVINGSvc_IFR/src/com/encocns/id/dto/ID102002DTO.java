/**
 * @file ID102002DTO.java
 * @brief 양식관리 DTO
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
 * @brief 양식관리 DTO
 * @details 양식관리 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID102002DTO {

	private int rowNo;                               /* 로우번호 */
	private int colNo;                               /* 컬럼번호 */
	private String cellId;                           /* 셀ID */
	private String cellCtnt;                         /* 셀내용 */
	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String usrId;                            /* 사용자ID */
	private int alignDvcd;                           /* 정렬구분코드 */
	private int endRowNo;                            /* 끝로우번호 */
	private int endColNo;                            /* 끝컬럼번호 */

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
	public String getCellCtnt() {
		return cellCtnt;
	}
	public void setCellCtnt(String cellCtnt) {
		this.cellCtnt = cellCtnt;
	}
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
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public int getAlignDvcd() {
		return alignDvcd;
	}
	public void setAlignDvcd(int alignDvcd) {
		this.alignDvcd = alignDvcd;
	}
	public int getEndRowNo() {
		return endRowNo;
	}
	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}
	public int getEndColNo() {
		return endColNo;
	}
	public void setEndColNo(int endColNo) {
		this.endColNo = endColNo;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
}

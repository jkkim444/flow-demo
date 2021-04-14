/**
 * @file ID201002DTO.java
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
public class ID201002DTO {
	private int rowNo;                               /* 로우번호 */
	private int colNo;                               /* 컬럼번호 */
	private String cellCtnt;                         /* 셀내용 */
	private String alignDvcd;                        /* 정렬구분코드 */
	private String cellId;                           /* 셀ID */
	private String hdrYn;                            /* 헤더여부 */
	private int startRowNo;                          /* 시작로우번호 */
	private int startColNo;                          /* 시작컬럼번호 */
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
	public String getAlignDvcd() {
		return alignDvcd;
	}
	public void setAlignDvcd(String alignDvcd) {
		this.alignDvcd = alignDvcd;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getHdrYn() {
		return hdrYn;
	}
	public void setHdrYn(String hdrYn) {
		this.hdrYn = hdrYn;
	}
	public int getStartRowNo() {
		return startRowNo;
	}
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}
	public int getStartColNo() {
		return startColNo;
	}
	public void setStartColNo(int startColNo) {
		this.startColNo = startColNo;
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

}

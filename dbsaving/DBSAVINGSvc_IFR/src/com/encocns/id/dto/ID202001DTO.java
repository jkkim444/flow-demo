/**
 * @file ID202001DTO.java
 * @brief 공시보고서수기관리 DTO
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
 * @brief 공시보고서수기관리 DTO
 * @details 공시보고서수기관리 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID202001DTO {

	private int rowNo;                               /* 로우번호 */
	private int colNo;                               /* 컬럼번호 */
	private String cellCtnt;                         /* 셀내용 */
	private String alignDvcd;                        /* 정렬구분코드 */
	private String cellId;                           /* 셀ID */
	private String hdrYn;                            /* 헤더여부 */
	private int showRowNo;                           /* 로우번호 */
	private int showColNo;                           /* 컬럼번호 */
	private String inputCellYn;                      /* 수기입력셀여부 */

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
	public int getShowRowNo() {
		return showRowNo;
	}
	public void setShowRowNo(int showRowNo) {
		this.showRowNo = showRowNo;
	}
	public int getShowColNo() {
		return showColNo;
	}
	public void setShowColNo(int showColNo) {
		this.showColNo = showColNo;
	}
	public String getInputCellYn() {
		return inputCellYn;
	}
	public void setInputCellYn(String inputCellYn) {
		this.inputCellYn = inputCellYn;
	}
}

/**
 * @file ID201003DTO.java
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
public class ID201003DTO {
	private String cellCtnt;		/* 셀내용 */
	private String clclValDvcd;		/* 산출값구분코드 */
	private String alignDvnm;		/* 정렬구분명 */

	public String getCellCtnt() {
		return cellCtnt;
	}
	public void setCellCtnt(String cellCtnt) {
		this.cellCtnt = cellCtnt;
	}
	public String getClclValDvcd() {
		return clclValDvcd;
	}
	public void setClclValDvcd(String clclValDvcd) {
		this.clclValDvcd = clclValDvcd;
	}
	public String getAlignDvnm() {
		return alignDvnm;
	}
	public void setAlignDvnm(String alignDvnm) {
		this.alignDvnm = alignDvnm;
	}
}

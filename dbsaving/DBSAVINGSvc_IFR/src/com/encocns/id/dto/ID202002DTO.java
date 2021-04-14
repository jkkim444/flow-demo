/**
 * @file ID202002DTO.java
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
public class ID202002DTO {

	private int startRowNo;                          /* 시작로우번호 */
	private int startColNo;                          /* 시작컬럼번호 */
	private int endRowNo;                            /* 끝로우번호 */
	private int endColNo;                            /* 끝컬럼번호 */

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

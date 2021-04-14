/**
 * @file ID102003DTO.java
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
public class ID102003DTO {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private int startRowNo;                          /* 시작로우번호 */
	private int endRowNo;                            /* 끝로우번호 */
	private int startColNo;                          /* 시작컬럼번호 */
	private int endColNo;                            /* 끝컬럼번호 */
	private String usrId;                            /* 사용자ID */

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
	public int getStartRowNo() {
		return startRowNo;
	}
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}
	public int getEndRowNo() {
		return endRowNo;
	}
	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}
	public int getStartColNo() {
		return startColNo;
	}
	public void setStartColNo(int startColNo) {
		this.startColNo = startColNo;
	}
	public int getEndColNo() {
		return endColNo;
	}
	public void setEndColNo(int endColNo) {
		this.endColNo = endColNo;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}

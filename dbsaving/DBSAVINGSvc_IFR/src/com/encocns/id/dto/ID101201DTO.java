/**
 * @file ID101201DTO.java
 * @brief 상위보고서 조회 DTO
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
 * @brief 상위보고서 조회 DTO
 * @details 상위보고서 조회 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID101201DTO {

	private String uprnPbnfRptId;                    /* 상위공시보고서ID */
	private String uprnPbnfRptNm;                    /* 공시보고서명 */
	private int cmtLevel;                            /* 주석레벨 */

	public String getUprnPbnfRptId() {
		return uprnPbnfRptId;
	}

	public void setUprnPbnfRptId(String uprnPbnfRptId) {
		this.uprnPbnfRptId = uprnPbnfRptId;
	}

	public String getUprnPbnfRptNm() {
		return uprnPbnfRptNm;
	}

	public void setUprnPbnfRptNm(String uprnPbnfRptNm) {
		this.uprnPbnfRptNm = uprnPbnfRptNm;
	}

	public int getcmtLevel() {
		return cmtLevel;
	}

	public void setcmtLevel(int cmtLevel) {
		this.cmtLevel = cmtLevel;
	}

}

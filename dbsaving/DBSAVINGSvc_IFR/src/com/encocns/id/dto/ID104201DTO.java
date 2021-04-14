/**
 * @file ID104201DTO.java
 * @brief 산출정보조회 DTO
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
 * @brief 산출정보조회 DTO
 * @details 산출정보조회 DTO
 * @author : 차 상 길
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class ID104201DTO {

	private String clclIstgId;                       /* 산출대상ID */
	private String clclIstgCtnt;                     /* 산출대상명 */

	public String getClclIstgId() {
		return clclIstgId;
	}
	public void setClclIstgId(String clclIstgId) {
		this.clclIstgId = clclIstgId;
	}
	public String getClclIstgCtnt() {
		return clclIstgCtnt;
	}
	public void setClclIstgCtnt(String clclIstgCtnt) {
		this.clclIstgCtnt = clclIstgCtnt;
	}

}

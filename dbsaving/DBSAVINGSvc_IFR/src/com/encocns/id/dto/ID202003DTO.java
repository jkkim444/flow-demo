/**
 * @file ID202003DTO.java
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
public class ID202003DTO {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String cellId;                           /* 셀ID */
	private String cellCtnt;                         /* 셀내용 */
	private String bchnVal;                          /* 변경전값 */
	private String achnVal;                          /* 변경후값 */
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
	public String getCellCtnt() {
		return cellCtnt;
	}
	public void setCellCtnt(String cellCtnt) {
		this.cellCtnt = cellCtnt;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
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
	public String getBchnVal() {
		return bchnVal;
	}
	public void setBchnVal(String bchnVal) {
		this.bchnVal = bchnVal;
	}
	public String getAchnVal() {
		return achnVal;
	}
	public void setAchnVal(String achnVal) {
		this.achnVal = achnVal;
	}

}

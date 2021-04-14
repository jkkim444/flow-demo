package com.encocns.fw.dto;

public class FW106001DTO {

	private String grpId;                            /* 그룹ID */
	private String grpNm;                            /* 그룹명 */
	private int batCnt;                              /* 배치갯수 */
	private String rmkCntn;                          /* 비고 */
	private String usrId;                            /* 사용자ID */

	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public String getGrpNm() {
		return grpNm;
	}
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}

	public int getBatCnt() {
		return batCnt;
	}
	public void setBatCnt(int batCnt) {
		this.batCnt = batCnt;
	}
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}

package com.encocns.fw.dto;

public class FW107001DTO {

	private String job;                              /* job */
	private String grpInstanceId;                    /* 그룹인스턴스ID */
	private String bizLclsCd;                        /* 업무구분코드 */
	private String grpId;                            /* 그룹ID */
	private int seq;                                 /* 일련번호 */
	private String batId;                            /* 배치ID */
	private String batNm;                            /* 배치명 */
	private int excSeq;                              /* 실행일변번호 */
	private String batParam;                         /* 배치파라미터 */
	private String batPath;                          /* 배치경로 */
	private String rmkCntn;                          /* 비고 */
	private String usrId;                            /* 사용자ID */

	public String getGrpInstanceId() {
		return grpInstanceId;
	}
	public void setGrpInstanceId(String grpInstanceId) {
		this.grpInstanceId = grpInstanceId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBatId() {
		return batId;
	}
	public void setBatId(String batId) {
		this.batId = batId;
	}
	public String getBatNm() {
		return batNm;
	}
	public void setBatNm(String batNm) {
		this.batNm = batNm;
	}
	public int getExcSeq() {
		return excSeq;
	}
	public void setExcSeq(int excSeq) {
		this.excSeq = excSeq;
	}
	public String getBatParam() {
		return batParam;
	}
	public void setBatParam(String batParam) {
		this.batParam = batParam;
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
    public String getBatPath() {
        return batPath;
    }
    public void setBatPath(String batPath) {
        this.batPath = batPath;
    }


}

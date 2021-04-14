/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CCO_LOG_DVO.java
 * @brief
 */
/**
 * @namespace com.encocns.enfra.db.dvo
 * @brief
 */
package com.encocns.enfra.db.dvo;

public class CFW_LOG_DVO {

	private String tx_dd; 								// 거래일 > 일자(DD)
	private String log_dt; 								// 로그일자(YYYYMMDD)
	private int log_seqno; 								// 로그일련번호 > 업무로그 일련번호(시컨스)
	private String log_kind_dvcd; 						// 로그종류구분코드 > N:정상, E:오류
	private String guid; 								// GUID : 일자(8) + 전문생성시간(8) + 사번(6) + 일련번호(11)
	private int seqno; 									// 진행일련번호 > 001 : NUMBER(3)
	private String frst_trnm_ipad; 						// 최초전송IP주소
	private String scr_exe_info; 						//  화면 실행 정보 > 화면ID
	private String pgm_exe_info; 						//  프로그램 실행 정보 > 서비스ID
	private String pgm_exe_sub_info; 					//  프로그램 실행 상세 정보 (로그인정보등) : 세션ID | 사번(6)
	private String bank_cd;								// 은행코드 : 090(FIX)
	private String bzwk_sys_cd; 						// 업무시스템코드 > IFR(IFRS), ERM(리스크), MAS(관리회계)
	private String chnl_tycd; 							// 채널 유형 코드 > U(FIX)
	private String tx_dept_cd; 							//
	private int empno; 									//
	private String tx_strt_time; 						//
	private String tx_end_time; 						//
	private String output_msg_cd; 						//
	private String err_loct_ctnt; 						//
	private String bod_data_ctnt; 						//

    public String getTx_dd() {
        return tx_dd;
    }
    public void setTx_dd(String tx_dd) {
        this.tx_dd = tx_dd;
    }
    public String getLog_dt() {
        return log_dt;
    }
    public void setLog_dt(String log_dt) {
        this.log_dt = log_dt;
    }
    public int getLog_seqno() {
        return log_seqno;
    }
    public void setLog_seqno(int log_seqno) {
        this.log_seqno = log_seqno;
    }
    public String getLog_kind_dvcd() {
        return log_kind_dvcd;
    }
    public void setLog_kind_dvcd(String log_kind_dvcd) {
        this.log_kind_dvcd = log_kind_dvcd;
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    public int getSeqno() {
        return seqno;
    }
    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }
    public String getFrst_trnm_ipad() {
        return frst_trnm_ipad;
    }
    public void setFrst_trnm_ipad(String frst_trnm_ipad) {
        this.frst_trnm_ipad = frst_trnm_ipad;
    }
    public String getScr_exe_info() {
        return scr_exe_info;
    }
    public void setScr_exe_info(String scr_exe_info) {
        this.scr_exe_info = scr_exe_info;
    }
    public String getPgm_exe_info() {
        return pgm_exe_info;
    }
    public void setPgm_exe_info(String pgm_exe_info) {
        this.pgm_exe_info = pgm_exe_info;
    }
    public String getPgm_exe_sub_info() {
        return pgm_exe_sub_info;
    }
    public void setPgm_exe_sub_info(String pgm_exe_sub_info) {
        this.pgm_exe_sub_info = pgm_exe_sub_info;
    }
	public String getBank_cd() {
		return bank_cd;
	}
	public void setBank_cd(String bank_cd) {
		this.bank_cd = bank_cd;
	}
    public String getBzwk_sys_cd() {
        return bzwk_sys_cd;
    }
    public void setBzwk_sys_cd(String bzwk_sys_cd) {
        this.bzwk_sys_cd = bzwk_sys_cd;
    }
    public String getChnl_tycd() {
        return chnl_tycd;
    }
    public void setChnl_tycd(String chnl_tycd) {
        this.chnl_tycd = chnl_tycd;
    }
    public String getTx_dept_cd() {
        return tx_dept_cd;
    }
    public void setTx_dept_cd(String tx_dept_cd) {
        this.tx_dept_cd = tx_dept_cd;
    }
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getTx_strt_time() {
        return tx_strt_time;
    }
    public void setTx_strt_time(String tx_strt_time) {
        this.tx_strt_time = tx_strt_time;
    }
    public String getTx_end_time() {
        return tx_end_time;
    }
    public void setTx_end_time(String tx_end_time) {
        this.tx_end_time = tx_end_time;
    }
    public String getOutput_msg_cd() {
        return output_msg_cd;
    }
    public void setOutput_msg_cd(String output_msg_cd) {
        this.output_msg_cd = output_msg_cd;
    }
    public String getErr_loct_ctnt() {
        return err_loct_ctnt;
    }
    public void setErr_loct_ctnt(String err_loct_ctnt) {
        this.err_loct_ctnt = err_loct_ctnt;
    }
    public String getBod_data_ctnt() {
        return bod_data_ctnt;
    }
    public void setBod_data_ctnt(String bod_data_ctnt) {
        this.bod_data_ctnt = bod_data_ctnt;
    }

}

/*
 * Copyright KAKAO BANK.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of KAKAO BANK.,LTD. ("Confidential Information").
 */
/**
 * @file IdsConsts.java
 * @brief 주석공시 상수 Class
 */
/**
 * @namespace com.kakaobank.ifr.consts
 * @brief IFRS 주석공시 Service Package
 */
package com.encocns.id.consts;



/**
 * @brief 주석공시 상수 Class
 * @details 주석공시의 상수를 정의하는 Class이다.
 * @author : joy
 * @date : 2017. 05. 31
 * @version : 1.0.0
 */
public class IdsConsts {
    public final static String APLY_ENDT = "99991231";
    /** 헤더여부 헤더 */
    public final static String ISHEADER_1 = "1";
    /** 헤더여부 헤더아님(데이터) */
    public final static String ISHEADER_2 = "2";

    /** 보고서진행처리에서 보고서멀티다운시 데이터포함여부 D:데이터, F:폼 */
    public final static String CALL_TYPE_DATA = "D";
    /** 보고서진행처리에서 보고서멀티다운시 데이터포함여부 D:데이터, F:폼 */
    public final static String CALL_TYPE_FORM = "F";

    /** 산출값구분코드: DATE:날짜 */
    public static final String CLCL_VAL_DVCD_DATE = "DATE";
    /** 산출값구분코드: TEXT:문자열 */
    public static final String CLCL_VAL_DVCD_TEXT = "TEXT";
    /** 산출값구분코드: NUM:숫자 */
    public static final String CLCL_VAL_DVCD_NUM = "NUM";
    /** 산출값구분코드: PER:퍼센트 */
    public static final String CLCL_VAL_DVCD_PER = "PER";
    /** 산출값구분코드: CUR:통화 */
    public static final String CLCL_VAL_DVCD_CUR = "CUR";



    /** 공시진행상태코드:10:생성대기         */
    public static final String PBNF_PRGS_STCD_10 = "10";
    /** 공시진행상태코드:20:생성완료         */
    public static final String PBNF_PRGS_STCD_20 = "20";
    /** 공시진행상태코드:30:작성대기         */
    public static final String PBNF_PRGS_STCD_30 = "30";
    /** 공시진행상태코드:40:작성중           */
    public static final String PBNF_PRGS_STCD_40 = "40";
    /** 공시진행상태코드:41:승인대기         */
    public static final String PBNF_PRGS_STCD_41 = "41";
    /** 공시진행상태코드:50:검증대기         */
    public static final String PBNF_PRGS_STCD_50 = "50";
    /** 공시진행상태코드:60:검증중           */
    public static final String PBNF_PRGS_STCD_60 = "60";
    /** 공시진행상태코드:70:검증완료         */
    public static final String PBNF_PRGS_STCD_70 = "70";
    /** 공시진행상태코드:80:완료             */
    public static final String PBNF_PRGS_STCD_80 = "80";
    /** 공시진행상태코드:98:생성중오류(1단계)*/
    public static final String PBNF_PRGS_STCD_98 = "98";
    /** 공시진행상태코드:99:생성중오류(2단계)*/
    public static final String PBNF_PRGS_STCD_99 = "99";

    /** 공시진행세부상태코드:1A:사전검증실패         */
    public static final String PBNF_PRGS_DTLS_STCD_1A = "1A";
    /** 공시진행세부상태코드:1B:사전검증완료         */
    public static final String PBNF_PRGS_DTLS_STCD_1B = "1B";
    /** 공시진행세부상태코드:4A:작성중               */
    public static final String PBNF_PRGS_DTLS_STCD_4A = "4A";
    /** 공시진행세부상태코드:4B:승인대기             */
    public static final String PBNF_PRGS_DTLS_STCD_4B = "4B";
    /** 공시진행세부상태코드:4C:검증대기             */
    public static final String PBNF_PRGS_DTLS_STCD_4C = "4C";
    /** 공시진행세부상태코드:6A:검증실패             */
    public static final String PBNF_PRGS_DTLS_STCD_6A = "6A";
    /** 공시진행세부상태코드:6B:검증완료             */
    public static final String PBNF_PRGS_DTLS_STCD_6B = "6B";
    /** 공시진행세부상태코드:6C:작업중(데이터미존재) */
    public static final String PBNF_PRGS_DTLS_STCD_6C = "6C";
    /** 공시진행세부상태코드:6D:검증불필요           */
    public static final String PBNF_PRGS_DTLS_STCD_6D = "6D";

    /** 공시진행처리코드:A01:생성개시     */
    public static final String PBNF_PRGS_PROCS_CD_A01 = "A01";
    /** 공시진행처리코드:A02:BATCH        */
    public static final String PBNF_PRGS_PROCS_CD_A02 = "A02";
    /** 공시진행처리코드:A03:검토         */
    public static final String PBNF_PRGS_PROCS_CD_A03 = "A03";
    /** 공시진행처리코드:A04:저장         */
    public static final String PBNF_PRGS_PROCS_CD_A04 = "A04";
    /** 공시진행처리코드:A05:결재요청     */
    public static final String PBNF_PRGS_PROCS_CD_A05 = "A05";
    /** 공시진행처리코드:A06:반려         */
    public static final String PBNF_PRGS_PROCS_CD_A06 = "A06";
    /** 공시진행처리코드:A07:승인         */
    public static final String PBNF_PRGS_PROCS_CD_A07 = "A07";
    /** 공시진행처리코드:A08:재작성       */
    public static final String PBNF_PRGS_PROCS_CD_A08 = "A08";
    /** 공시진행처리코드:A09:검증         */
    public static final String PBNF_PRGS_PROCS_CD_A09 = "A09";
    /** 공시진행처리코드:A10:강제검증완료 */
    public static final String PBNF_PRGS_PROCS_CD_A10 = "A10";
    /** 공시진행처리코드:A11:검증완료     */
    public static final String PBNF_PRGS_PROCS_CD_A11 = "A11";
    /** 공시진행처리코드:A12:마감         */
    public static final String PBNF_PRGS_PROCS_CD_A12 = "A12";
    /** 공시진행처리코드:A13:작성요청     */
    public static final String PBNF_PRGS_PROCS_CD_A13 = "A13";

    /** 공시진행처리코드 문구:A06:반려         */
    public static final String PBNF_PRGS_RPOCS_CD_TXT_A06 = "반려";
    /** 공시진행처리코드 문구:A07:승인         */
    public static final String PBNF_PRGS_RPOCS_CD_TXT_A07 = "승인";



    /** 주석공시보고서검증결과코드.1A.사전검증실패 */
    public static final String CMT_PBNF_RPT_VALDTN_RSLT_CD_1A = "1A";
    /** 주석공시보고서검증결과코드.1B.사전검증완료 */
    public static final String CMT_PBNF_RPT_VALDTN_RSLT_CD_1B = "1B";
    /** 주석공시보고서검증결과코드.6A.검증오류     */
    public static final String CMT_PBNF_RPT_VALDTN_RSLT_CD_6A = "6A";
    /** 주석공시보고서검증결과코드.6B.검증완료     */
    public static final String CMT_PBNF_RPT_VALDTN_RSLT_CD_6B = "6B";
    /** 주석공시보고서검증결과코드.6C.검증실패     */
    public static final String CMT_PBNF_RPT_VALDTN_RSLT_CD_6C = "6C";
    /** 주석공시보고서검증결과코드.6D.검증불필요   */
    public static final String CMT_PBNF_RPT_VALDTN_RSLT_CD_6D = "6D";

    /** 관리단위코드.1.공시보고서별 */
    public static final String MGMT_UNIT_CD_1 = "1";
    /** 관리단위코드.2.공시항목별 */
    public static final String MGMT_UNIT_CD_2 = "2";


    /** 공백 " " */
    public static final String SPACE = " ";

    /** YN */
    public static final String YN_Y = "Y";
    public static final String YN_N = "N";

    /** 주석공시부점구분코드 0:총괄부서 */
    public static final String CMT_PBNF_BRN_DVCD_0 = "0";
    /** 주석공시부점구분코드 1:소관부서 */
    public static final String CMT_PBNF_BRN_DVCD_1 = "1";
    /** 주석공시부점구분코드 2:부소관부서 */
    public static final String CMT_PBNF_BRN_DVCD_2 = "2";

    /** 로우컬럼구분코드 0:로우 */
    public static final String ROW_CLMN_DVCD_0 = "0";
    /** 로우컬럼구분코드 1:컬럼 */
    public static final String ROW_CLMN_DVCD_1 = "1";


}

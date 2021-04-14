package com.encocns.ia.module;

public interface JlzConst {

	/** 분개처리결과코드 */	
	//정상
	public static final String JLZ_PRCS_RSLT_CD_NML = "1";
	//분개전표에러
	public static final String JLZ_PRCS_RSLT_CD_SLP_NO_ERR = "2";
	//분개규칙에러
	public static final String JLZ_PRCS_RSLT_CD_JLZ_RULE_ERR = "3";
	//처리에러
	public static final String JLZ_PRCS_RSLT_CD_PRCS_ERR = "4";
	
	/** 분개구분코드 */
	//분개내역작성
	public static final String IFRS_JLZ_DCD_WRT = "1";
	//정상분개
	public static final String IFRS_JLZ_DCD_NML = "2";
	//역분개
	public static final String IFRS_JLZ_DCD_REVERSE = "3";
	//역분개
	public static final String IFRS_JLZ_DCD_ERR= "4";
		
	/** 계정구분코드 */
	//자산
	public static final String IFRS_ACC_DCD_ASST = "1";
	//부채
	public static final String IFRS_ACC_DCD_DEBT = "2";
	//자본
	public static final String IFRS_ACC_DCD_CAPL = "3";
	//난외
	public static final String IFRS_ACC_DCD_ETC = "4";
	//수익
	public static final String IFRS_ACC_DCD_ERN = "5";
	//비용
	public static final String IFRS_ACC_DCD_CST = "6";
	
	
}

/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA528001DTO.java
 * @brief 유가증권기초내역 리스트 조회  엑셀 다운 management List Query DTO
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 12.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 유가증권기초내역 management List Query DTO
 * @details 유가증권기초내역 management List Query DTO
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 12.
 * @version : 1.0.0
 */
public class IA528001DTO {

	private String stdrYm;									/* 기준년월 */        
	private String acngBaseCd;                              /* 회계기준코드 */
	private String fnncGdsItmsNo;							/* 금융상품종목번호 */
	private String fnncGdsDivCd;							/* 금융상품구분코드 */
	private String fnncGdsDivNm;							/* 금융상품구분명 */
	private String fnncGdsItmsNm;							/* 금융상품종목명 */
	private String kgaapCtgrCd;                             /* KGAAP범주코드 */   
	private String kifrsCtgrCd;                             /* KIFRS범주코드 */
	private BigDecimal bassQty;								/* 기초 수량 */
	private BigDecimal bassAcbkAmt;                         /* 기초장부금액 */      
	private BigDecimal bassFvAmt;;                          /* 기초공정가치금액 */    
	private BigDecimal bassAociAmt;                         /* 기초AOCI금액 */    
	private BigDecimal bassImprLdqCmtl;                     /* 기초손상차손누계 */
	private BigDecimal thtrAcqsQty;							/* 당기취득수량 */
	private BigDecimal thtrAcqsBuyAmt;                      /* 당기취득매입금액 */
	private BigDecimal thtrDspslQty;						/* 당기처분수량 */
	private BigDecimal thtrDspslAcbkAmt;                    /* 당기처분장부금액 */    
	private BigDecimal thtrDspslOciAmt;                     /* 당기처분OCI금액 */   
	private BigDecimal thtrDspslPrftAmt;                    /* 당기처분이익금액 */    
	private BigDecimal thtrDspslLssAmt;                     /* 당기처분처분금액 */    
	private BigDecimal thtrImprLdq;                         /* 당기손상차손 */      
	private BigDecimal thtrImprLdqRetn;                     /* 당기손상차손환입 */
	private BigDecimal edtmQty;								/* 기말정보 수량 */
	private BigDecimal edtmAcbkAmt;                         /* 기말장부금액 */      
	private BigDecimal edtmFvAmt;                           /* 기말공정가치금액 */    
	private BigDecimal edtmEvprftPl;                        /* 기말평가이익PL */    
	private BigDecimal edtmEvlssPl;                         /* 기말평가손실PL */    
	private BigDecimal edtmEvprftOci;                       /* 기말평가이익OCI */   
	private BigDecimal edtmEvlssOci;                        /* 기말평가손실OCI */   
	private BigDecimal edtmAociAmt;                         /* 기말AOCI금액 */    
	private BigDecimal edtmImprLdqCmtl;                     /* 기말손상차손누계 */    
	private BigDecimal divdEarn;                            /* 배당금수익 */       
	private BigDecimal intEarn;                             /* 이자수익 */
	
	private String usrId;									/* 사용자ID */
	private int rNum;										/* 순번 */
	/**
	 * @return the stdrYm
	 */
	public String getStdrYm() {
		return stdrYm;
	}
	/**
	 * @param stdrYm the stdrYm to set
	 */
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	/**
	 * @return the acngBaseCd
	 */
	public String getAcngBaseCd() {
		return acngBaseCd;
	}
	/**
	 * @param acngBaseCd the acngBaseCd to set
	 */
	public void setAcngBaseCd(String acngBaseCd) {
		this.acngBaseCd = acngBaseCd;
	}
	/**
	 * @return the fnncGdsItmsNo
	 */
	public String getFnncGdsItmsNo() {
		return fnncGdsItmsNo;
	}
	/**
	 * @param fnncGdsItmsNo the fnncGdsItmsNo to set
	 */
	public void setFnncGdsItmsNo(String fnncGdsItmsNo) {
		this.fnncGdsItmsNo = fnncGdsItmsNo;
	}
	/**
	 * @return the fnncGdsDivCd
	 */
	public String getFnncGdsDivCd() {
		return fnncGdsDivCd;
	}
	/**
	 * @param fnncGdsDivCd the fnncGdsDivCd to set
	 */
	public void setFnncGdsDivCd(String fnncGdsDivCd) {
		this.fnncGdsDivCd = fnncGdsDivCd;
	}
	
	/**
	 * @return the fnncGdsItmsNm
	 */
	public String getFnncGdsItmsNm() {
		return fnncGdsItmsNm;
	}
	/**
	 * @param fnncGdsItmsNm the fnncGdsItmsNm to set
	 */
	public void setFnncGdsItmsNm(String fnncGdsItmsNm) {
		this.fnncGdsItmsNm = fnncGdsItmsNm;
	}
	/**
	 * @return the kgaapCtgrCd
	 */
	public String getKgaapCtgrCd() {
		return kgaapCtgrCd;
	}
	/**
	 * @param kgaapCtgrCd the kgaapCtgrCd to set
	 */
	public void setKgaapCtgrCd(String kgaapCtgrCd) {
		this.kgaapCtgrCd = kgaapCtgrCd;
	}
	/**
	 * @return the kifrsCtgrCd
	 */
	public String getKifrsCtgrCd() {
		return kifrsCtgrCd;
	}
	/**
	 * @param kifrsCtgrCd the kifrsCtgrCd to set
	 */
	public void setKifrsCtgrCd(String kifrsCtgrCd) {
		this.kifrsCtgrCd = kifrsCtgrCd;
	}
	/**
	 * @return the bassQty
	 */
	public BigDecimal getBassQty() {
		return bassQty;
	}
	/**
	 * @param bassQty the bassQty to set
	 */
	public void setBassQty(BigDecimal bassQty) {
		this.bassQty = bassQty;
	}
	/**
	 * @return the bassAcbkAmt
	 */
	public BigDecimal getBassAcbkAmt() {
		return bassAcbkAmt;
	}
	/**
	 * @param bassAcbkAmt the bassAcbkAmt to set
	 */
	public void setBassAcbkAmt(BigDecimal bassAcbkAmt) {
		this.bassAcbkAmt = bassAcbkAmt;
	}
	/**
	 * @return the bassFvAmt
	 */
	public BigDecimal getBassFvAmt() {
		return bassFvAmt;
	}
	/**
	 * @param bassFvAmt the bassFvAmt to set
	 */
	public void setBassFvAmt(BigDecimal bassFvAmt) {
		this.bassFvAmt = bassFvAmt;
	}
	/**
	 * @return the bassAociAmt
	 */
	public BigDecimal getBassAociAmt() {
		return bassAociAmt;
	}
	/**
	 * @param bassAociAmt the bassAociAmt to set
	 */
	public void setBassAociAmt(BigDecimal bassAociAmt) {
		this.bassAociAmt = bassAociAmt;
	}
	/**
	 * @return the bassImorLdqCmtl
	 */
	
	/**
	 * @return the thtrAcqsQty
	 */
	public BigDecimal getThtrAcqsQty() {
		return thtrAcqsQty;
	}
	/**
	 * @param thtrAcqsQty the thtrAcqsQty to set
	 */
	public void setThtrAcqsQty(BigDecimal thtrAcqsQty) {
		this.thtrAcqsQty = thtrAcqsQty;
	}
	
	/**
	 * @return the thtrDspslQty
	 */
	public BigDecimal getThtrDspslQty() {
		return thtrDspslQty;
	}
	/**
	 * @param thtrDspslQty the thtrDspslQty to set
	 */
	public void setThtrDspslQty(BigDecimal thtrDspslQty) {
		this.thtrDspslQty = thtrDspslQty;
	}
	/**
	 * @return the thtrDspslAcbkAmt
	 */
	public BigDecimal getThtrDspslAcbkAmt() {
		return thtrDspslAcbkAmt;
	}
	/**
	 * @param thtrDspslAcbkAmt the thtrDspslAcbkAmt to set
	 */
	public void setThtrDspslAcbkAmt(BigDecimal thtrDspslAcbkAmt) {
		this.thtrDspslAcbkAmt = thtrDspslAcbkAmt;
	}
	/**
	 * @return the thtrDspslOciAmt
	 */
	public BigDecimal getThtrDspslOciAmt() {
		return thtrDspslOciAmt;
	}
	/**
	 * @param thtrDspslOciAmt the thtrDspslOciAmt to set
	 */
	public void setThtrDspslOciAmt(BigDecimal thtrDspslOciAmt) {
		this.thtrDspslOciAmt = thtrDspslOciAmt;
	}
	/**
	 * @return the thtrDspslPrftAmt
	 */
	public BigDecimal getThtrDspslPrftAmt() {
		return thtrDspslPrftAmt;
	}
	/**
	 * @param thtrDspslPrftAmt the thtrDspslPrftAmt to set
	 */
	public void setThtrDspslPrftAmt(BigDecimal thtrDspslPrftAmt) {
		this.thtrDspslPrftAmt = thtrDspslPrftAmt;
	}
	/**
	 * @return the thtrDspslLssAmt
	 */
	public BigDecimal getThtrDspslLssAmt() {
		return thtrDspslLssAmt;
	}
	/**
	 * @param thtrDspslLssAmt the thtrDspslLssAmt to set
	 */
	public void setThtrDspslLssAmt(BigDecimal thtrDspslLssAmt) {
		this.thtrDspslLssAmt = thtrDspslLssAmt;
	}
	/**
	 * @return the thtrImprLdq
	 */
	public BigDecimal getThtrImprLdq() {
		return thtrImprLdq;
	}
	/**
	 * @param thtrImprLdq the thtrImprLdq to set
	 */
	public void setThtrImprLdq(BigDecimal thtrImprLdq) {
		this.thtrImprLdq = thtrImprLdq;
	}
	/**
	 * @return the thtrImprLdqRetn
	 */
	public BigDecimal getThtrImprLdqRetn() {
		return thtrImprLdqRetn;
	}
	/**
	 * @param thtrImprLdqRetn the thtrImprLdqRetn to set
	 */
	public void setThtrImprLdqRetn(BigDecimal thtrImprLdqRetn) {
		this.thtrImprLdqRetn = thtrImprLdqRetn;
	}
	/**
	 * @return the edtmAcbkAmt
	 */
	public BigDecimal getEdtmAcbkAmt() {
		return edtmAcbkAmt;
	}
	/**
	 * @param edtmAcbkAmt the edtmAcbkAmt to set
	 */
	public void setEdtmAcbkAmt(BigDecimal edtmAcbkAmt) {
		this.edtmAcbkAmt = edtmAcbkAmt;
	}
	/**
	 * @return the edtmFvAmt
	 */
	public BigDecimal getEdtmFvAmt() {
		return edtmFvAmt;
	}
	/**
	 * @param edtmFvAmt the edtmFvAmt to set
	 */
	public void setEdtmFvAmt(BigDecimal edtmFvAmt) {
		this.edtmFvAmt = edtmFvAmt;
	}
	/**
	 * @return the edtmEvprftPl
	 */
	public BigDecimal getEdtmEvprftPl() {
		return edtmEvprftPl;
	}
	/**
	 * @param edtmEvprftPl the edtmEvprftPl to set
	 */
	public void setEdtmEvprftPl(BigDecimal edtmEvprftPl) {
		this.edtmEvprftPl = edtmEvprftPl;
	}
	/**
	 * @return the edtmEvlssPl
	 */
	public BigDecimal getEdtmEvlssPl() {
		return edtmEvlssPl;
	}
	/**
	 * @param edtmEvlssPl the edtmEvlssPl to set
	 */
	public void setEdtmEvlssPl(BigDecimal edtmEvlssPl) {
		this.edtmEvlssPl = edtmEvlssPl;
	}
	/**
	 * @return the edtmEvprftOci
	 */
	public BigDecimal getEdtmEvprftOci() {
		return edtmEvprftOci;
	}
	/**
	 * @param edtmEvprftOci the edtmEvprftOci to set
	 */
	public void setEdtmEvprftOci(BigDecimal edtmEvprftOci) {
		this.edtmEvprftOci = edtmEvprftOci;
	}
	/**
	 * @return the edtmEvlssOci
	 */
	public BigDecimal getEdtmEvlssOci() {
		return edtmEvlssOci;
	}
	/**
	 * @param edtmEvlssOci the edtmEvlssOci to set
	 */
	public void setEdtmEvlssOci(BigDecimal edtmEvlssOci) {
		this.edtmEvlssOci = edtmEvlssOci;
	}
	/**
	 * @return the edtmAociAmt
	 */
	public BigDecimal getEdtmAociAmt() {
		return edtmAociAmt;
	}
	/**
	 * @param edtmAociAmt the edtmAociAmt to set
	 */
	public void setEdtmAociAmt(BigDecimal edtmAociAmt) {
		this.edtmAociAmt = edtmAociAmt;
	}
	/**
	 * @return the edtmImprLdqCmtl
	 */
	public BigDecimal getEdtmImprLdqCmtl() {
		return edtmImprLdqCmtl;
	}
	/**
	 * @param edtmImprLdqCmtl the edtmImprLdqCmtl to set
	 */
	public void setEdtmImprLdqCmtl(BigDecimal edtmImprLdqCmtl) {
		this.edtmImprLdqCmtl = edtmImprLdqCmtl;
	}
	/**
	 * @return the divdEarn
	 */
	public BigDecimal getDivdEarn() {
		return divdEarn;
	}
	/**
	 * @param divdEarn the divdEarn to set
	 */
	public void setDivdEarn(BigDecimal divdEarn) {
		this.divdEarn = divdEarn;
	}
	/**
	 * @return the intEarn
	 */
	public BigDecimal getIntEarn() {
		return intEarn;
	}
	/**
	 * @param intEarn the intEarn to set
	 */
	public void setIntEarn(BigDecimal intEarn) {
		this.intEarn = intEarn;
	}
	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * @return the edtmQty
	 */
	public BigDecimal getEdtmQty() {
		return edtmQty;
	}
	/**
	 * @param edtmQty the edtmQty to set
	 */
	public void setEdtmQty(BigDecimal edtmQty) {
		this.edtmQty = edtmQty;
	}
	/**
	 * @return the bassImprLdqCmtl
	 */
	public BigDecimal getBassImprLdqCmtl() {
		return bassImprLdqCmtl;
	}
	/**
	 * @param bassImprLdqCmtl the bassImprLdqCmtl to set
	 */
	public void setBassImprLdqCmtl(BigDecimal bassImprLdqCmtl) {
		this.bassImprLdqCmtl = bassImprLdqCmtl;
	}
	/**
	 * @return the thtrAcqsBuyAmt
	 */
	public BigDecimal getThtrAcqsBuyAmt() {
		return thtrAcqsBuyAmt;
	}
	/**
	 * @param thtrAcqsBuyAmt the thtrAcqsBuyAmt to set
	 */
	public void setThtrAcqsBuyAmt(BigDecimal thtrAcqsBuyAmt) {
		this.thtrAcqsBuyAmt = thtrAcqsBuyAmt;
	}
	/**
	 * @return the rNum
	 */
	public int getrNum() {
		return rNum;
	}
	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	/**
	 * @return the fnncGdsDivNm
	 */
	public String getFnncGdsDivNm() {
		return fnncGdsDivNm;
	}
	/**
	 * @param fnncGdsDivNm the fnncGdsDivNm to set
	 */
	public void setFnncGdsDivNm(String fnncGdsDivNm) {
		this.fnncGdsDivNm = fnncGdsDivNm;
	}        

}

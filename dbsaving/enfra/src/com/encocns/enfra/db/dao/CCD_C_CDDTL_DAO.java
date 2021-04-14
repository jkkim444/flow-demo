package com.encocns.enfra.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.enfra.db.config.EnfraSqlMapClient;
import com.encocns.enfra.db.dvo.CCD_C_CDDTL_DVO;

@Repository
public class CCD_C_CDDTL_DAO {

	@Autowired
	private EnfraSqlMapClient session;

	/**
	 * @코드상세 코드조회
	 */
	public List<CCD_C_CDDTL_DVO> selCodeList( CCD_C_CDDTL_DVO codeDvo ){
		List<CCD_C_CDDTL_DVO> cdList = session.selectList( "ccd_c_cddtl.selCodeList", codeDvo );
		return cdList;
	}


}
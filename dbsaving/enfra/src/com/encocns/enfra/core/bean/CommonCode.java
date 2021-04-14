package com.encocns.enfra.core.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.encocns.enfra.db.dao.CCD_C_CDDTL_DAO;
import com.encocns.enfra.db.dvo.CCD_C_CDDTL_DVO;

@Service
public class CommonCode {

	@Autowired
	private CCD_C_CDDTL_DAO daoCCD_C_CDDTL;

	@SuppressWarnings("unchecked")
	@Cacheable(value="commonCodeCache", key="{#codeDvo.lcl_cd, #codeDvo.cd_dmn_id}")
	public Object getCode(CCD_C_CDDTL_DVO codeDvo)
	{
		@SuppressWarnings("rawtypes")
		ArrayList<CCD_C_CDDTL_DVO> cdList = (ArrayList)daoCCD_C_CDDTL.selCodeList(codeDvo);
		return cdList;
	}

}

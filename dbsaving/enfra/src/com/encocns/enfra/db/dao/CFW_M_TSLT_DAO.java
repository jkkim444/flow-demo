package com.encocns.enfra.db.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

import com.encocns.enfra.db.config.EnfraSqlMapClient;

@Repository
public class CFW_M_TSLT_DAO {

	@Autowired
	private EnfraSqlMapClient session;

    /**
     * @다국어 라벨 조회
     */
    public String selTslt( HashMap<String, Object> mapTemp ){
        mapTemp.put("lclCd",LocaleContextHolder.getLocale().toString());
    	String strResult = session.selectOne( "cfw_m_tslt.selTslt", mapTemp );
    	return strResult;
    }
}
/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SqlMapClientImpl.java
 * @brief
 */
/**
 * @namespace com.encocns.enfra.db.config
 * @brief
 */
package com.encocns.enfra.db.config;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Repository("coreCommonDao")
public class EnfraSqlMapClientImpl implements EnfraSqlMapClient {

    @Autowired
    @Qualifier("sqlSessionTemplateCore")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public <T> T selectOne(String id) {
        return sqlSessionTemplate.selectOne(id);
    }

    @Override
    public <T> T selectOne(String id, Object param) {
        return sqlSessionTemplate.selectOne(id, param);
    }

	@Override
	public <E> List<E> selectList(String id) {
		return sqlSessionTemplate.selectList(id);
	}

	@Override
	public <E> List<E> selectList(String id, Object param) {
		return sqlSessionTemplate.selectList(id, param);
	}

    @Override
    public int insert(String id, Object param) {
        return sqlSessionTemplate.insert(id, param);
    }

    @Override
    public int update(String id, Object param) {
        return sqlSessionTemplate.update(id, param);
    }

    @Override
    public int delete(String id, Object param) {
        return sqlSessionTemplate.delete(id, param);
    }

}

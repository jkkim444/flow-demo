package com.encocns.enfra.db.config;

import java.util.List;

public interface EnfraSqlMapClient {

    public <T> T selectOne(String id);

    public <T> T selectOne(String id, Object param);

    public <E> List<E> selectList(String id);

    public <E> List<E> selectList(String id, Object param);

    public int insert(String id, Object param);

    public int update(String id, Object param);

    public int delete(String id, Object param);

}

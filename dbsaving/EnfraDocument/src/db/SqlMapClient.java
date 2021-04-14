/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SqlMapClient.java
 * @brief SqlMapClient Interface
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 10. 25. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.config.db
 * @brief Common DB Package
 */
package db;

import java.util.List;

/**
 * @brief SqlMapClient Interface
 * @details SqlMapClient Interface
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 25.
 * @version : 1.0.0
 */
public interface SqlMapClient {

    /**
     * @brief single item inquiry
     * @details single item inquiry(No Parameters)
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @return <T> T inquiry result
     */
    public <T> T selectOne(String id);

    /**
     * @brief single item inquiry
     * @details single item inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @param param Parameters
     * @return <T> T inquiry result
     */
    public <T> T selectOne(String id, Object param);

    /**
     * @brief multiple item inquiry
     * @details multiple item inquiry(No parameters)
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @return <E> List<E> inquiry result
     */
    public <E> List<E> selectList(String id);

    /**
     * @brief multiple item inquiry
     * @details multiple item inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @param param Parameters
     * @return <E> List<E> inquiry result
     */
    public <E> List<E> selectList(String id, Object param);

    /**
     * @brief INSERT
     * @details INSERT
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @param param Parameters
     * @return int Processing count
     */
    public int insert(String id, Object param);

    /**
     * @brief UPDATE
     * @details UPDATE
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @param param Parameters
     * @return int Processing count
     */
    public int update(String id, Object param);

    /**
     * @brief DELETE
     * @details DELETE
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @param id Mapper ID
     * @param param Parameters
     * @return int Processing count
     */
    public int delete(String id, Object param);


}

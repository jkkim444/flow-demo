/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SqlMapClientImpl.java
 * @brief SqlMapClient Implementation
 */
/**
 * @namespace com.encocns.fw.config.db
 * @brief Common DB Package
 */
package db;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.mapping.MappedStatement;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @brief SqlMapClient Implementation
 * @details SqlMapClient Implementation
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 25.
 * @version : 1.0.0
 */
@Repository("commonDao")
public class SqlMapClientImpl implements SqlMapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlMapClientImpl.class);

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * @brief single item inquiry
     * @details single item inquiry(No Parameters)
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @see com.encocns.fw.config.db.SqlMapClient#selectOne(java.lang.String)
     * @param id Mapper ID
     * @return <T> T inquiry result
     */
    @Override
    public <T> T selectOne(String id) {
    	
    	
    	MappedStatement ms = sqlSessionTemplate.getConfiguration().getMappedStatement("sql1.select1");   
//    	ms.getBoundSql(null).getSql();
//    			BoundSql boundSql = ms.getBoundSql(params);
//    			String sql = boundSql.getSql();
    			
    			
    	
    	
        int result = 0;

        T resultObject = null;

        try {
            resultObject = sqlSessionTemplate.selectOne(id);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (resultObject != null) {
            result = 1;
        }

        if (LOGGER.isInfoEnabled())
            LOGGER.info(MessageFormat.format("##### {0} > Select Count : {1} ", new Object[] { id, result }));

        return resultObject;
    }

    /**
     * @brief single item inquiry
     * @details single item inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @see com.encocns.fw.config.db.SqlMapClient#selectOne(java.lang.String,
     *      java.lang.Object)
     * @param id Mapper ID
     * @param param Parameters
     * @return <T> T inquiry result
     */
    @Override
    public <T> T selectOne(String id, Object param) {
        int result = 0;

        T resultObject = null;

        try {
            resultObject = sqlSessionTemplate.selectOne(id, param);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (resultObject != null) {
            result = 1;
        }

        if (LOGGER.isInfoEnabled())
            LOGGER.info(MessageFormat.format("##### {0} > Select Count : {1} > Parameters : {2}",
                    new Object[] { id, result, getFields(param) }));

        return resultObject;
    }

    /**
     * @brief multiple item inquiry
     * @details multiple item inquiry(No parameters)
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @see com.encocns.fw.config.db.SqlMapClient#selectList(java.lang.String)
     * @param id Mapper ID
     * @return <E> List<E> inquiry result list
     */
    @Override
    public <E> List<E> selectList(String id) {
        int result = 0;

        List<E> resultList = null;

        try {
            resultList = sqlSessionTemplate.selectList(id);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (resultList != null) {
            result = resultList.size();
        }

        if (LOGGER.isInfoEnabled())
            LOGGER.info(MessageFormat.format("##### {0} > Select Count : {1} ", new Object[] { id, result }));

        return resultList;
    }

    /**
     * @brief multiple item inquiry
     * @details multiple item inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @see com.encocns.fw.config.db.SqlMapClient#selectList(java.lang.String,
     *      java.lang.Object)
     * @param id Mapper ID
     * @param param Parameters
     * @return <E> List<E> inquiry result list
     */
    @Override
    public <E> List<E> selectList(String id, Object param) {
        int result = 0;

        List<E> resultList = null;

        try {
            resultList = sqlSessionTemplate.selectList(id, param);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (resultList != null) {
            result = resultList.size();
        }

        if (LOGGER.isInfoEnabled())
            LOGGER.info(MessageFormat.format("##### {0} > Select Count : {1} > Parameters : {2}", new Object[] { id, result, getFields(param) }));

        return resultList;
    }

    /**
     * @brief INSERT
     * @details INSERT
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 31.
     * @see com.encocns.fw.config.db.SqlMapClient#insert(java.lang.String,
     *      java.lang.Object)
     * @param id Mapper ID
     * @param param Parameters
     * @return int Processing Count
     */
    @Override
    public int insert(String id, Object param) {
        int result = 0;

        try {
            result = sqlSessionTemplate.insert(id, param);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (LOGGER.isInfoEnabled())
            LOGGER.info(MessageFormat.format("##### {0} > Insert Count : {1}", new Object[] { id, result }));

        return result;
    }

    /**
     * @brief UPDATE
     * @details UPDATE
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @see com.encocns.fw.config.db.SqlMapClient#update(java.lang.String,
     *      java.lang.Object)
     * @param id
     *            Mapper ID
     * @param param
     *            Parameters
     * @return int Processing Count
     */
    @Override
    public int update(String id, Object param) {
        int result = 0;

        try {
            result = sqlSessionTemplate.update(id, param);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (LOGGER.isInfoEnabled())
            LOGGER.info(MessageFormat.format("##### {0} > Update Count : {1} > Parameters : {2}",
                    new Object[] { id, result, getFields(param) }));

        return result;
    }

    /**
     * @brief DELETE
     * @details DELETE
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 25.
     * @see com.encocns.fw.config.db.SqlMapClient#delete(java.lang.String,
     *      java.lang.Object)
     * @param id
     *            Mapper ID
     * @param param
     *            Parameters
     * @return int Processing Count
     */
    @Override
    public int delete(String id, Object param) {
        int result = 0;

        try {
            result = sqlSessionTemplate.delete(id, param);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            throw e;
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(MessageFormat.format("##### {0} > Delete Count : {1} > Parameters : {2}",
                    new Object[] { id, result, getFields(param) }));
        }

        return result;
    }

    /**
     * @brief Invoke the object to create and return the Parameters string
     * @details Invoke the object to create and return the Parameters string
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 2.
     * @param obj
     * @return String Return Item for Parameter
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private String getFields(Object obj) {
        StringBuffer resultSB = new StringBuffer();
        boolean isNotFirst = false;
        try {
            Class dymClass = obj.getClass();

            if (dymClass.toString().endsWith("DTO") || dymClass.toString().endsWith("IN")) {
                Field[] fields = dymClass.getDeclaredFields();

                for (int i = 0; i < fields.length; i++) {
                    String methodName = fields[i].getName();

                    if (methodName.substring(0, 1).matches("[a-z]+") && methodName.substring(1, 2).matches("[A-Z]+")) {
                        methodName = "get" + methodName;
                    } else {
                        methodName = "get" + StringUtils.capitalize(methodName);
                    }

                    Method method = dymClass.getMethod(methodName, null);

                    String value = String.valueOf(method.invoke(obj, null));

                    if (isNotFirst) {
                        if (value != null && !"null".equals(value)) {
                            resultSB.append("," + fields[i].getName() + "=" + value);
                        }
                    } else {
                        if (value != null && !"null".equals(value)) {
                            resultSB.append(fields[i].getName() + "=" + value);
                        }
                    }

                    isNotFirst = true;
                }
            } else if (dymClass.toString().endsWith("String")) {
                resultSB.append("String=" + obj.toString());
            } else if (dymClass.toString().endsWith("int")) {
                resultSB.append("int=" + String.valueOf(obj));
            } else if (dymClass.toString().endsWith("HashMap")) {
                HashMap targetObj = (HashMap) obj;

                Iterator<String> iterator = targetObj.keySet().iterator();

                String key = "";
                isNotFirst = false;

                while (iterator.hasNext()) {
                    key = iterator.next();
                    Object value = targetObj.get(key);

                    if (isNotFirst) {
                        resultSB.append(",");
                    }

                    if (value != null) {
                        resultSB.append(key + "=" + value);
                    }

                    isNotFirst = true;
                }
            }
        } catch (IllegalArgumentException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        } catch (IllegalAccessException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        } catch (InvocationTargetException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }

        return resultSB.toString();
    }

    /**
     * @brief Byte Length Getter
     * @details Byte Length Getter ?ù¥?ã§.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 9.
     * @param str
     * @param charset
     * @return int Byte Length
     */
    @SuppressWarnings("unused")
    private int getByteLength(String str, String charset) {

        int strLength = 0;

        ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();

        try {
            requestOutputStream.write(str.getBytes(charset));
            strLength = requestOutputStream.size();
        } catch (UnsupportedEncodingException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        } catch (IOException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }

        return strLength;
    }

    /**
     * @brief Byte String Cutter
     * @details Byte String Cutter
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 9.
     * @param s
     *            ???ÉÅ Î¨∏Ïûê?ó¥
     * @param charset
     *            charset
     * @param startIdx
     *            Start Index
     * @param bytes
     *            Cut Byte
     * @return String Result
     */
    @SuppressWarnings("unused")
    private String getByteString(String s, String charset, int startIdx, int bytes) {
        ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();

        try {
            requestOutputStream.write(s.getBytes(charset));
            return new String(requestOutputStream.toByteArray(), startIdx, bytes, charset);
        } catch (UnsupportedEncodingException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        } catch (IOException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }

        return s;
    }


}

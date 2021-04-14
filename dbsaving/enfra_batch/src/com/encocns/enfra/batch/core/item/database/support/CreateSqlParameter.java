/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CreateSqlParameter.java
 * @brief SqlParameter CREATE
 */
/**
 * @namespace com.encocns.enfra.batch.core.item.database
 * @brief Core Item Database Package
 */
package com.encocns.enfra.batch.core.item.database.support;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.mapping.ParameterMapping;

/**
 * @brief SqlParameter CREATE
 * @details SqlParameter를 CREATE한다. 
 * @author : joy
 * @date : 2018. 2. 26.
 * @version : 1.0.0
 */
public class CreateSqlParameter {

	/**
	 * @brief DTO Class의 Getter를 Parse하여 Object 배열로 반환
	 * @details 
	 * <pre>
	 * DTO Class의 Getter를 Parse하여 Object 배열로 반환한다.
	 * EnfraItemReader Class에서 setPreparedStatementSetter시 사용한다.
	 * </pre>
	 * @author : joy
	 * @date : 2018. 3. 13.
	 * @param dto
	 * @param paramMapping
	 * @return Object[]
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object[] getParams(Object dto, List<ParameterMapping> paramMapping)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] mtd = dto.getClass().getDeclaredMethods();
		List<Object> listParam = new ArrayList<Object>();

		for (ParameterMapping pm : paramMapping) {
			String getMethod = "GET" + pm.getProperty().toUpperCase();
			for (Method m : mtd) {
				if (m.getName().toUpperCase().equals(getMethod)) {
					listParam.add(m.invoke(dto));
					continue;
				}
			}
		}

		return listParam.toArray();
	}

}

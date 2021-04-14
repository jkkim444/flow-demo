/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file RefreshableSqlSessionFactoryBean.java
 * @brief Mybatis Query Refresh SqlSessionFactory Bean
 */
/**
 * @namespace com.encocns.enfra.core.bean
 * @brief Core Bean Package
 */
package com.encocns.enfra.core.bean;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @brief Refreshable SqlSessionFactory Bean
 * @details Mybatis Query Refresh SqlSessionFactory Bean 이다.
 * @author : joy
 * @date : 2017. 4. 6.
 * @version : 1.0.0
 */
public class RefreshableSqlSessionFactory extends SqlSessionFactoryBean implements DisposableBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(RefreshableSqlSessionFactory.class);

	private SqlSessionFactory proxy;

	private int interval = 2000;

	private Timer timer;

	private TimerTask task;

	private Resource configLocation;

	private Resource[] mapperLocations;

	private Properties configurationProperties;

	public void setConfigurationProperties(Properties sqlSessionFactoryProperties) {
		super.setConfigurationProperties(sqlSessionFactoryProperties);
		this.configurationProperties = sqlSessionFactoryProperties;
	}

	private boolean running = false;

	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	private final Lock r = rwl.readLock();

	private final Lock w = rwl.writeLock();

	/**
	 * @brief Config Location Setter
	 * @details Config Location Setter이다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @param configLocation
	 */
	public void setConfigLocation(Resource configLocation) {
		super.setConfigLocation(configLocation);
		this.configLocation = configLocation;
	}

	/**
	 * @brief Mapper Locations Setter
	 * @details Mapper Location Setter이다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @param mapperLocations
	 */
	public void setMapperLocations(Resource[] mapperLocations) {
		super.setMapperLocations(mapperLocations);
		this.mapperLocations = mapperLocations;
	};

	/**
	 * @brief Interval Setter
	 * @details Query 변경 확인 주기(Interval) Setter이다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @param interval
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * @brief SqlSessionFactoryBean의 초기화 메소드 호출
	 * @details SqlSessionFactoryBean의 초기화 메소드를 호출한다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @throws Exception
	 */
	public void refresh() throws Exception {
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("##### refreshing SqlSessionFactory.");
		}

		w.lock();

		try {
			super.afterPropertiesSet();
		} finally {
			w.unlock();
		}
	}

	/**
	 * @brief SqlSessionFactoryBean의 초기화 메소드를 호출, setRefreshable 호출
	 * @details SqlSessionFactoryBean의 초기화 메소드를 호출하고setRefreshable 호출한다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @throws Exception
	 */
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		setRefreshable();
	}

	/**
	 * @brief 매핑된 Mybatis XML Query Refresh 처리
	 * @details 매핑된 Mybatis XML Query를 Refresh 처리한다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 */
	private void setRefreshable() {
		proxy = (SqlSessionFactory) Proxy.newProxyInstance(SqlSessionFactory.class.getClassLoader(),
				new Class[] { SqlSessionFactory.class},
					new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							return method.invoke(getParentObject(),  args);
						}
		});

		task = new TimerTask() {
			private Map<Resource, Long> map = new HashMap<Resource, Long>();

			public void run() {
				if(isModified()) {
					try {
						refresh();
					} catch(Exception e) {
						if(LOGGER.isErrorEnabled()) {
							LOGGER.error("##### caught exception", e);
						}
					}
				}
			}

			// 변경 여부 확인
			private boolean isModified() {
				boolean retVal = false;

				if(mapperLocations != null) {
					for(int i=0; i<mapperLocations.length; i++) {
						Resource mappingLocation = mapperLocations[i];

						retVal = findModifiedResource(mappingLocation);

						if(retVal) {
							break;
						}
					}
				} else if(configLocation != null) {
					Configuration configuration = null;

					XMLConfigBuilder xmlConfigBuilder = null;

					try {
						xmlConfigBuilder = new XMLConfigBuilder(configLocation.getInputStream(), null, configurationProperties);
						configuration = (Configuration) xmlConfigBuilder.getConfiguration();
					} catch(IOException e) {
						e.printStackTrace();
					}

					if(xmlConfigBuilder != null) {
						try {
							// Configuration Class의 protected member field인 loadedResources를 얻기 위해 reflection을 사용
							Field loadedResourcesField = Configuration.class.getDeclaredField("loadedResources");

							loadedResourcesField.setAccessible(true);

							@SuppressWarnings("unchecked")
							Set<String> loadedResources = (Set<String>) loadedResourcesField.get(configuration);

							for(Iterator<String> iterator = loadedResources.iterator(); iterator.hasNext();) {
								String resourceStr = (String)iterator.next();

								if(resourceStr.endsWith(".xml")) {
									Resource mappingLocation = new ClassPathResource(resourceStr);

									retVal = findModifiedResource(mappingLocation);

									if(retVal) {
										break;
									}
								}
							}
						} catch(Exception ex) {
							throw new RuntimeException("##### Failed to parse config resource: " + configLocation, ex);
						} finally {
							ErrorContext.instance().reset();
						}
					}
				}

				return retVal;
			}

			/**
			 * @brief 변경된 Resource가 있는지 여부 확인 true or false 반환
			 * @details 변경된 Resource가 있는지 여부 확인하고 변경되면 true 없다면 false를 반환한다.
			 * @author : joy
			 * @date : 2017. 4. 6.
			 * @param resource
			 * @return boolean true or false
			 */
			private boolean findModifiedResource(Resource resource) {
				boolean retVal = false;
				List<String> modifiedResources = new ArrayList<String>();

				try {
					long modified = resource.lastModified();

					if(map.containsKey(resource)) {
						long lastModified =((Long) map.get(resource)).longValue();

						if(lastModified != modified) {
							map.put(resource,  new Long(modified));

							modifiedResources.add(resource.getDescription());

							retVal = true;
						}
					} else {
						map.put(resource, new Long(modified));
					}
				} catch(IOException e) {
					if(LOGGER.isErrorEnabled()) LOGGER.error("##### caught exception", e);
				}

				if(retVal) {
					if(LOGGER.isInfoEnabled()) {
						LOGGER.info("##### modified files : " + modifiedResources);
					}
				}

				return retVal;
			}

		};

		timer = new Timer(true);
		resetInterval();
	}

	/**
	 * @brief 상위 SqlSessionFactory Object Getter
	 * @details 상위 SqlSessionFactory Object Getter이다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @return Object SqlSessionFactory
	 * @throws Exception
	 */
	private Object getParentObject() throws Exception {
		r.lock();

		try {
			return super.getObject();
		} finally {
			r.unlock();
		}
	}

	/**
	 * @brief SqlSessionFactory Object Getter
	 * @details SqlSessionFactory Object Getter이다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @return
	 */
	public SqlSessionFactory getObject() {
		return this.proxy;
	}

	/**
	 * @brief SqlSessionFactory Object Type Getter
	 * @details SqlSessionFactory Object Type Getter이다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @return
	 */
	public Class<? extends SqlSessionFactory> getObjectType() {
		return (this.proxy != null ? this.proxy.getClass() : SqlSessionFactory.class);
	}

	/**
	 * @brief timer 존재시 ResetInterval 호출
	 * @details timer 존재시 ResetInterval 호출한다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @param ms
	 */
	public void setCheckInterval(int ms) {
		interval = ms;

		if(timer != null) {
			resetInterval();
		}
	}

	/**
	 * @brief running중일때 timer를 취소하고 interval이 0이상이면 running상태로 변경
	 * @details running중일때 timer를 취소하고 interval이 0이상이면 running상태로 변경한다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 */
	private void resetInterval() {
		if(running) {
			timer.cancel();
			running = false;
		}

		if(interval > 0) {
			timer.schedule(task,  0, interval);
			running = true;
		}
	}

	/**
	 * @brief timer destroy
	 * @details timer를 destroy한다.
	 * @author : joy
	 * @date : 2017. 4. 6.
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		timer.cancel();
	}
}

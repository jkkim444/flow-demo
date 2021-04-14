package com.encocns.enfra.core.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.encocns.enfra.exception.EnfraCoreException;

@Component
public class BeanManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeanManager.class);

	@Autowired
	private ApplicationContext appContext;

	public BeanManager(){ 
		if(LOGGER.isDebugEnabled()) LOGGER.debug("BeanManager Constructor!"); 
	}

	public Object getBean( String beanName ) throws EnfraCoreException
	{
		Object beanObj = null;

		try
		{
			beanObj = appContext.getBean(beanName);
		}
		catch(BeansException e)
		{
			throw new EnfraCoreException("CE0006", e.getMessage());
		}

		return beanObj;
	}

}

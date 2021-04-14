package exe;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import config.Configuration;
import consts.ConfigConst;
import dao.BatchDesignDAO;
import dao.OnlineDesignDAO;
import db.CamelHashMap;
import document.DocumentBuilder;
import util.EncryptionUtil;

public class DocumentExecutor {
	
	public static void main(String[] args) throws Exception {
		
		DocumentExecutor executor = new DocumentExecutor();
		
		executor.loadBatchClassPath();
		ApplicationContext context = executor.loadSpring();
		
		DocumentBuilder codeDesign = (DocumentBuilder)context.getBean("codeDesign");
		DocumentBuilder programList = (DocumentBuilder)context.getBean("programList");
		DocumentBuilder screenList = (DocumentBuilder)context.getBean("screenList");
		DocumentBuilder tableList = (DocumentBuilder)context.getBean("tableList");
		DocumentBuilder tableDef = (DocumentBuilder)context.getBean("tableDef");
		DocumentBuilder onlineDesign = (DocumentBuilder)context.getBean("onlineDesign");
		DocumentBuilder batchDesign = (DocumentBuilder)context.getBean("batchDesign");
		 
//		 HashMap<String, String> parameter = new HashMap<String,String>();

		String type = args[0];
		
		if( "all".equals(type) ) {
			
			codeDesign.build();
			programList.build();
			screenList.build();
			tableList.build();
			tableDef.build();
			
			OnlineDesignDAO onlineDao = (OnlineDesignDAO)context.getBean("onlineDesignDAO");
			ArrayList<CamelHashMap> svcList = onlineDao.selectServiceList();
			
			for( CamelHashMap svc : svcList  ) {
				HashMap<String, String> parameter = new HashMap<String,String>();
				parameter.put("svcId", String.valueOf(svc.get("svcId")));
				onlineDesign.setParameter(parameter);
				onlineDesign.build();
			}
			
			
			BatchDesignDAO batchDao = (BatchDesignDAO)context.getBean("batchDesignDAO");
			ArrayList<CamelHashMap> batchList = batchDao.selectBatList();
			
			for( CamelHashMap batch : batchList  ) {
				HashMap<String, String> parameter = new HashMap<String,String>();
				parameter.put("batId", String.valueOf(batch.get("batId")));
				batchDesign.setParameter(parameter);
				batchDesign.build();
			}
			
		}
		else if( "BatchDesign".equals(type) ) {
			
			String type2 = args[1];
			if( type2==null ) throw new Exception("all or batchId required");
			
			if( "all".equals(type2) ) {
				BatchDesignDAO batchDao = (BatchDesignDAO)context.getBean("batchDesignDAO");
				ArrayList<CamelHashMap> batchList = batchDao.selectBatList();
				
				for( CamelHashMap batch : batchList  ) {
					HashMap<String, String> parameter = new HashMap<String,String>();
					parameter.put("batId", String.valueOf(batch.get("batId")));
					batchDesign.setParameter(parameter);
					batchDesign.build();
				}
			}
			else {
				HashMap<String, String> parameter = new HashMap<String,String>();
				parameter.put("batId", type2);
				batchDesign.setParameter(parameter);
				batchDesign.build();				
			}
			
		}
		else if( "OnlineDesign".equals(type) ) {
			
			String type2 = args[1];
			if( type2==null ) throw new Exception("all or svcId required");
			
			if( "all".equals(type2) ) {
				OnlineDesignDAO onlineDao = (OnlineDesignDAO)context.getBean("onlineDesignDAO");
				ArrayList<CamelHashMap> svcList = onlineDao.selectServiceList();
				
				for( CamelHashMap svc : svcList  ) {
					HashMap<String, String> parameter = new HashMap<String,String>();
					parameter.put("svcId", String.valueOf(svc.get("svcId")));
					onlineDesign.setParameter(parameter);
					onlineDesign.build();
				}
			}
			else {
				HashMap<String, String> parameter = new HashMap<String,String>();
				parameter.put("svcId", type2);
				onlineDesign.setParameter(parameter);
				onlineDesign.build();				
			}
			
		}
		else if( "CodeDesign".equals(type) ) {
			codeDesign.build();
		}
		else if( "TableList".equals(type) ) {
			tableList.build();
		}
		else if( "TableDef".equals(type) ) {
			tableDef.build();
		}
		else if( "ScreenList".equals(type) ) {
			screenList.build();
		}
		else if( "ProgramList".equals(type) ) {
			programList.build();
		}
		
	}
	
	public void loadBatchClassPath() throws Exception {
		
		 //Dynamic set Classpath
		 File file = new File(ConfigConst.commonProp().getProperty("batch.location")+"/bin");

		 ClassLoader currentThreadClassLoader = Thread.currentThread().getContextClassLoader();

		 // Add the conf dir to the classpath
		 // Chain the current thread classloader
		 URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toURL()}, currentThreadClassLoader);

		 // Replace the thread classloader - assumes
		 // you have permissions to do so
		 Thread.currentThread().setContextClassLoader(urlClassLoader);
		
	}
	
	
	public ApplicationContext loadSpring() {
		 
		//Spring Load
		ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
		 
		BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) ((GenericApplicationContext) context).getBeanFactory();
		 
		// DataSource ���
		Map<String,String> dataSource = new HashMap<String,String>();
		
		dataSource.put("driverClassName", "net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.put("url"            , ConfigConst.commonProp().getProperty("batch.db.url"));
		dataSource.put("username"       , ConfigConst.commonProp().getProperty("batch.db.username"));
		dataSource.put("password"       , EncryptionUtil.decrypt(ConfigConst.commonProp().getProperty("batch.db.password")));
		
		GenericBeanDefinition dataSourceBeanDefinition = new GenericBeanDefinition();
		dataSourceBeanDefinition.setBeanClass(BasicDataSource.class);
		dataSourceBeanDefinition.setDestroyMethodName("close");
		dataSourceBeanDefinition.setPropertyValues(new MutablePropertyValues(dataSource));
		beanFactory.registerBeanDefinition("batchDataSource", dataSourceBeanDefinition);
		
		// SqlSessionFactory ���
		AbstractBeanDefinition sqlSessionFactoryBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(SqlSessionFactoryBean.class)
		        .addPropertyReference("dataSource", "batchDataSource")
		        .addPropertyValue("configLocation", "classpath:config/properties/mybatis-config.xml")
		        .addPropertyValue("mapperLocations", "file:"+ConfigConst.commonProp().getProperty("batch.mapper.location"))
		        .getBeanDefinition();
		
		beanFactory.registerBeanDefinition("batchSqlSessionFactory", sqlSessionFactoryBeanDefinition);
		
		// SqlSessionTemplate ���
		AbstractBeanDefinition sqlSessionTemplateBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(SqlSessionTemplate.class)
		        .addConstructorArgReference("batchSqlSessionFactory")
		        .getBeanDefinition();
		
		beanFactory.registerBeanDefinition("batchSqlSessionTemplate", sqlSessionTemplateBeanDefinition);
		
		return context;
		
	}
	
	
}



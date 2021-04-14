package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.encocns.enfra.core.bean.RefreshableSqlSessionFactory;

@Configuration
public class MybatisConfig {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
    public RefreshableSqlSessionFactory sqlSessionFactoryBean() throws Exception {
		
		RefreshableSqlSessionFactory sessionFactory = new RefreshableSqlSessionFactory();
		
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setConfigLocation(applicationContext.getResource("classpath:config/properties/mybatis-config.xml"));
		sessionFactory.setMapperLocations(applicationContext.getResources("file:"+System.getProperty("user.dir")+"/mapper/*.xml"));
		
        return sessionFactory;
    }
	
	@Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean().getObject());
    }
	

}

package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import consts.ConfigConst;
import util.EncryptionUtil;

@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod="close")
    public BasicDataSource dataSource() {
		
		BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(ConfigConst.dbProp().getProperty("DB_DRIVER"));
        bds.setUrl(ConfigConst.dbProp().getProperty("DB_URL"));
        bds.setUsername(ConfigConst.dbProp().getProperty("DB_USERNAME"));
        bds.setPassword(EncryptionUtil.decrypt(ConfigConst.dbProp().getProperty("DB_PASSWORD")));
		
        return bds;
    }
	
//	@Bean()
//	@Lazy()
//    public DataSourceTransactionManager txManager() {
//		DataSourceTransactionManager txm = new DataSourceTransactionManager();
//		txm.setDataSource(dataSource());
//        return txm;
//    }
    

}

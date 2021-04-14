package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aop.BeanAspect;
import consts.ConfigConst;
import document.BatchDesign;
import document.CodeDesign;
import document.OnlineDesign;
import document.ProgramList;
import document.ScreenList;
import document.TableDef;
import document.TableList;

//@EnableAutoConfiguration
@org.springframework.context.annotation.Configuration
@ComponentScan({"config","aop","db","dao","document" })
//@PropertySource(value="classpath:config/properties/common.properties", encoding=ConfigConst.ENCODING)
//@PropertySource(value="classpath:config/properties/dbconnect.properties", encoding=ConfigConst.ENCODING)
@EnableAspectJAutoProxy
public class Configuration {

    String company;
	String clientName;
	String projectName;
	String templateLocation;
	String outputLocation;
	String writer;
	String version;
	String position;
	String date;
	String dbUserNm;
	String batchPrjLocation;
	
	public Configuration() {
	    company = ConfigConst.commonProp().getProperty("company");
		clientName = ConfigConst.commonProp().getProperty("clientName"); 
		projectName = ConfigConst.commonProp().getProperty("projectName");
		writer = ConfigConst.commonProp().getProperty("writer");
		version = ConfigConst.commonProp().getProperty("version");
		position = ConfigConst.commonProp().getProperty("position");
		date = ConfigConst.commonProp().getProperty("date");
		batchPrjLocation = ConfigConst.commonProp().getProperty("batch.location");
		dbUserNm = ConfigConst.dbProp().getProperty("DB_USERNAME");
		
		templateLocation = System.getProperty("user.dir")+"\\template";
		outputLocation = System.getProperty("user.dir")+"\\output";
	}
	
	@Bean
    public BeanAspect beanAspect() {
        return new BeanAspect();
    }
	
	@Bean
    public CodeDesign codeDesign() {
		CodeDesign codeDesign = new CodeDesign();
		
		codeDesign.setCompany(company);
		codeDesign.setClientName(clientName);
		codeDesign.setProjectName(projectName);
		codeDesign.setTemplateLocation(templateLocation);
		codeDesign.setOutputLocation(outputLocation);
		codeDesign.setWriter(writer);
		codeDesign.setVersion(version);
		codeDesign.setPosition(position);
		codeDesign.setDate(date);
		codeDesign.setDbUserNm(dbUserNm);
		
        return codeDesign;
    }
	
	@Bean
    public ProgramList programList() {
		ProgramList programList = new ProgramList();
		
		programList.setCompany(company);
		programList.setClientName(clientName);
		programList.setProjectName(projectName);
		programList.setTemplateLocation(templateLocation);
		programList.setOutputLocation(outputLocation);
		programList.setWriter(writer);
		programList.setVersion(version);
		programList.setPosition(position);
		programList.setDate(date);
		programList.setDbUserNm(dbUserNm);
		
        return programList;
    }
	
	@Bean
    public ScreenList screenList() {
		ScreenList screenList = new ScreenList();
		
		screenList.setCompany(company);
		screenList.setClientName(clientName);
		screenList.setProjectName(projectName);
		screenList.setTemplateLocation(templateLocation);
		screenList.setOutputLocation(outputLocation);
		screenList.setWriter(writer);
		screenList.setVersion(version);
		screenList.setPosition(position);
		screenList.setDate(date);
		screenList.setDbUserNm(dbUserNm);
		
        return screenList;
    }
	
	@Bean
    public TableList tableList() {
		TableList tableList = new TableList();
		
		tableList.setCompany(company);
		tableList.setClientName(clientName);
		tableList.setProjectName(projectName);
		tableList.setTemplateLocation(templateLocation);
		tableList.setOutputLocation(outputLocation);
		tableList.setWriter(writer);
		tableList.setVersion(version);
		tableList.setPosition(position);
		tableList.setDate(date);
		tableList.setDbUserNm(dbUserNm);
		
        return tableList;
    }
	
	@Bean
    public TableDef tableDef() {
		TableDef tableDef = new TableDef();
		
		tableDef.setCompany(company);
		tableDef.setClientName(clientName);
		tableDef.setProjectName(projectName);
		tableDef.setTemplateLocation(templateLocation);
		tableDef.setOutputLocation(outputLocation);
		tableDef.setWriter(writer);
		tableDef.setVersion(version);
		tableDef.setPosition(position);
		tableDef.setDate(date);
		tableDef.setDbUserNm(dbUserNm);
		
        return tableDef;
    }
	
	@Bean
    public OnlineDesign onlineDesign() {
		OnlineDesign onlineDesign = new OnlineDesign();
		
		onlineDesign.setCompany(company);
		onlineDesign.setClientName(clientName);
		onlineDesign.setProjectName(projectName);
		onlineDesign.setTemplateLocation(templateLocation);
		onlineDesign.setOutputLocation(outputLocation);
		onlineDesign.setWriter(writer);
		onlineDesign.setVersion(version);
		onlineDesign.setPosition(position);
		onlineDesign.setDate(date);
		onlineDesign.setDbUserNm(dbUserNm);
		
        return onlineDesign;
    }
	
	@Bean
    public BatchDesign batchDesign() {
		BatchDesign batchDesign = new BatchDesign();
		
		batchDesign.setCompany(company);
		batchDesign.setClientName(clientName);
		batchDesign.setProjectName(projectName);
		batchDesign.setTemplateLocation(templateLocation);
		batchDesign.setOutputLocation(outputLocation);
		batchDesign.setWriter(writer);
		batchDesign.setVersion(version);
		batchDesign.setPosition(position);
		batchDesign.setDate(date);
		batchDesign.setDbUserNm(dbUserNm);
		batchDesign.setBatchPrjLocation(batchPrjLocation);
		
        return batchDesign;
    }
	
}
	
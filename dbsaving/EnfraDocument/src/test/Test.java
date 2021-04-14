package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
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
import document.DocumentBuilder;

public class Test {

	public static void main(String[] args) throws Exception {
		
		 //Dynamic set Classpath
		 File file = new File("C:\\\\project\\\\workspace\\\\kakaobank_batch_ifr\\\\bin");

		 ClassLoader currentThreadClassLoader = Thread.currentThread().getContextClassLoader();

		 // Add the conf dir to the classpath
		 // Chain the current thread classloader
		 URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toURL()}, currentThreadClassLoader);

		 // Replace the thread classloader - assumes
		 // you have permissions to do so
		 Thread.currentThread().setContextClassLoader(urlClassLoader);
		 
		 //Spring Load
		 ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
		 
		 BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) ((GenericApplicationContext) context).getBeanFactory();
		 
         // DataSource 등록
		 Map<String,String> dataSource = new HashMap<String,String>();
				 
         dataSource.put("driverClassName", "net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
         dataSource.put("url", "jdbc:log4jdbc:oracle:thin:@192.168.0.202:1521:enco");
         dataSource.put("username", "TOSS");
         dataSource.put("password", "toss1");
		 
         GenericBeanDefinition dataSourceBeanDefinition = new GenericBeanDefinition();
         dataSourceBeanDefinition.setBeanClass(BasicDataSource.class);
         dataSourceBeanDefinition.setDestroyMethodName("close");
         dataSourceBeanDefinition.setPropertyValues(new MutablePropertyValues(dataSource));
         beanFactory.registerBeanDefinition("batchDataSource", dataSourceBeanDefinition);
         
         
         // SqlSessionFactory 등록
         AbstractBeanDefinition sqlSessionFactoryBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(SqlSessionFactoryBean.class)
                 .addPropertyReference("dataSource", "batchDataSource")
                 .addPropertyValue("configLocation", "classpath:config/properties/mybatis-config.xml")
                 .addPropertyValue("mapperLocations", "file:C:/project/workspace/kakaobank_batch_ifr/src/main/resources/com/kakaobank/**/mapper/*xml")
                 .getBeanDefinition();
         
         beanFactory.registerBeanDefinition("batchSqlSessionFactory", sqlSessionFactoryBeanDefinition);
         
         
         // SqlSessionTemplate 등록
         AbstractBeanDefinition sqlSessionTemplateBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(SqlSessionTemplate.class)
                 .addConstructorArgReference("batchSqlSessionFactory")
                 .getBeanDefinition();
         
         beanFactory.registerBeanDefinition("batchSqlSessionTemplate", sqlSessionTemplateBeanDefinition);
         
         
//		 DocumentBuilder batchDesign = (DocumentBuilder)context.getBean("batchDesign");
//		 HashMap<String, String> parameter = new HashMap<String,String>();
//		 parameter.put("batId", "CFWDB1001");
//		 batchDesign.setParameter(parameter);
//		 batchDesign.build();
//		 
//		 
//		 String localDir = System.getProperty("user.dir");
//		 System.err.println(localDir);
		 
		 
		 
		 String document = "test";
     	String fileName = document.replaceAll("\\\\", " ")
				.replaceAll("/", " ")
				.replaceAll(":", ";")
				.replaceAll("\\*", " ")
				.replaceAll("\"", "'")
				.replaceAll("<", "(")
				.replaceAll(">", ")")
				.replaceAll("\\|", ";");
		 
//		 DocumentBuilder codeDesign = (DocumentBuilder)context.getBean("codeDesign");
//		 codeDesign.build();
//		 
//		 DocumentBuilder programList = (DocumentBuilder)context.getBean("programList");
//		 programList.build();
//
//		 DocumentBuilder screenList = (DocumentBuilder)context.getBean("screenList");
//		 screenList.build();
//		 
//		 DocumentBuilder tableList = (DocumentBuilder)context.getBean("tableList");
//		 tableList.build();
//		 
//		 DocumentBuilder tableDef = (DocumentBuilder)context.getBean("tableDef");
//		 tableDef.build();
		 
//		 DocumentBuilder onlineDesign = (DocumentBuilder)context.getBean("onlineDesign");
//		 HashMap<String, String> parameter = new HashMap<String,String>();
//		 parameter.put("svcId", "FW1010");
//		 onlineDesign.setParameter(parameter);
//		 onlineDesign.build();
		 
			 
			 

		 
         /*
         
         SqlSessionTemplate template = (SqlSessionTemplate)context.getBean("batchSqlSessionTemplate");
         String sql = template.getConfiguration().getMappedStatement("CO3010.selectCodeDomainList").getBoundSql(null).getSql();
         
         SqlCommandType type = template.getConfiguration().getMappedStatement("CO3010.mergeCodeDomain").getSqlCommandType();
         System.out.println(type.name());
         
         System.out.println(sql);
		 
		 Statement statement = CCJSqlParserUtil.parse(sql);
//		 Select selectStatement = (Select) statement;
		 
		 Select update = (Select) statement;
//		 Update update = (Update) statement;
//		 Merge update = (Merge) statement;
		 TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//		 
		 List<String> tableList = tablesNamesFinder.getTableList(update);
		 
		 for( String t : tableList ) {
			 System.out.println(t);
		 }
		 
		 CompilationUnit compilationUnit = JavaParser.parse( new File("C:/project/workspace/kakaobank_batch_ifr/src/main/java/com/kakaobank/cfw/job/CFWDB1001.java"), Charset.forName(ConfigConst.ENCODING) );
		 
		 List<MethodCallExpr> varList3 = compilationUnit.findAll( MethodCallExpr.class );
		 List<VariableDeclarator> varList2 = compilationUnit.findAll( VariableDeclarator.class );
		 
		 //파일 객체 생성1
         File file = new File("C:/project/workspace/EnfraGridSvc/src/com/encocns/co/mapper/CO3010.xml");
         //입력 스트림 생성
         FileReader filereader = new FileReader(file);
         //입력 버퍼 생성
         BufferedReader bufReader = new BufferedReader(filereader);
         String line = "";
         String preline = "";
         while((line = bufReader.readLine()) != null){
        	 if( line.indexOf("selectCodeDtlList")>=0 ) {
        		 
        		 if( preline.indexOf("<!--")>=0 ) {
        			 System.out.println(preline.replaceAll("<!--\\s*(.+)\\s*-->", "$1").trim());
        		 }
        		 break;
        	 }
             
             preline = line;
         }
         //.readLine()은 끝에 개행문자를 읽지 않는다.
         bufReader.close();
		 
		 List<Comment> comments = compilationUnit.getComments();
		 
		 int i=0;
		 int preChkIdx = 1;
		 for( Comment cmt : comments ) {
			 
			 if( preChkIdx==2 && cmt.toString().indexOf("pre")>-1 ) {
				 System.out.println(cmt);
				 break;
			 }
			 
			 if( cmt.toString().indexOf("pre")>-1 ) preChkIdx++;
			 
			 i++;
		 }
		 
		 
		 for( MethodCallExpr mth : varList3 ) {
			 
			 String varName = mth.getChildNodes().get(0).toString();
			 String mthName = mth.getNameAsString().toUpperCase();
			 
			 for( VariableDeclarator var : varList2 ) {
				 
				 if( 
						 var.getNameAsString().equals(varName) &&
						 var.getTypeAsString().indexOf("JobParameters")>=0  ) {
					 
					 if( mthName.indexOf("GET")>-1 ) {
						 System.out.println(mth.getNameAsString());
						 System.out.println(mth.getArguments().get(0).toString().replace("\"", ""));
				 	 }
							 
				 }//JobParameters
					 
				 
				 else
				 if( 
						 var.getNameAsString().equals(varName) &&
						 (var.getTypeAsString().indexOf("EnfraItemReader")>=0 
						 || var.getTypeAsString().indexOf("EnfraItemWriter")>=0) ) {
					 
					 if( "INSERT".equals(mthName) ||
							 "UPDATE".equals(mthName) ||
							 "DELETE".equals(mthName) ||
							 "SELECTONE".equals(mthName) ||
							 "SELECTLIST".equals(mthName) ||
							 "SETQUERYID".equals(mthName) 
						 	) {
						 
						 if( mth.getArguments().size()>0 ) {
							 System.out.println(mth.getNameAsString());
							 System.out.println(mth.getArguments().get(0).toString().replace("\"", ""));
						 }
						 
						 System.out.println("=====================================");
					 }
					 
					 break;
				 }//queryId
				 
			 
			 }//end for
			 
			 
		 }//end for
		 
		 
		 */
		 
		 
	}//end main

}

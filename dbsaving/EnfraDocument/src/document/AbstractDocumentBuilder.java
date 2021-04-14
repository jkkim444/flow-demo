package document;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import consts.ConfigConst;
import consts.DocumentConst;
import db.CamelHashMap;

public abstract class AbstractDocumentBuilder implements DocumentBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDocumentBuilder.class);
	
	/* 파라미터 */
	private HashMap<String,String> parameter;
	
	/* 공통데이터 */
	private String company; //Project Name
	private String projectName; //Project Name
	private String clientName; //고객사
	private String templateLocation;
	private String outputLocation;
	private String dbUserNm;
	private String batchPrjLocation;
	
	/* 표지공통데이터 */
	private String writer;
	private String version;
	private String position;
	private String date;
	
	/* 산출물생성 공통데이터 */
	private String template; //산출물 TEMPLATE 파일명
	private String document; //산출물 파일명
	private String configFile; //Config filename
	private Properties properties;
	private Properties coverProperties;
	
	/* Excel */
    protected XSSFWorkbook workbook;
	
	public abstract void init();
	public abstract void makeBody() throws Exception ;
	
	public AbstractDocumentBuilder() {
		
		properties = new Properties();
		coverProperties = new Properties();
		parameter = new HashMap<String,String>();
		
		try {
			coverProperties.load( new InputStreamReader(new FileInputStream(ConfigConst.getDocConfigPath() + "Cover.properties") , Charset.forName(ConfigConst.ENCODING) ) );
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
	
	public void build() throws Exception {
		
		//초기화
		init();
		
		//표지생성
		makeCover();
		
		//산출물 생성
		makeBody();
		
		//파일생성
		write();
		
	}//build
	
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
	public void loadProperties( String configFile ) {
		setConfigFile(configFile);
		try {
			properties.load( new InputStreamReader(new FileInputStream(ConfigConst.getDocConfigPath() + configFile), Charset.forName(ConfigConst.ENCODING)));
		}
		catch(IOException e) {}
		
	}//loadProperties
	
	public void createExcel()  {
		
		try {
		    FileInputStream fis = new FileInputStream(seperateStrName(new String[]{templateLocation, template+DocumentConst.XLSX }, DocumentConst.FILE_SEPERATOR ));
		    workbook = new XSSFWorkbook(fis); // Excel 2007 이상
		}
		catch(FileNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		catch(IOException e) {
			LOGGER.error(e.getMessage());
		}
		
	}//createExcel
	
	
	public void makeCover() throws Exception {
		
		setField("표지", coverProperties.getProperty("표지_version"), "Version "+version);
		setField("표지", coverProperties.getProperty("표지_date"), date);
		
		setField("개정이력", coverProperties.getProperty("개정이력_table1"), new String[]{company, writer, position, date} );
		setField("개정이력", coverProperties.getProperty("개정이력_table2"), new String[]{version, "최조작성", "", date, writer} );
		
	}//makeCover

	
	public abstract String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) ;
	
	public void setList( String sheetName, String position, ArrayList<CamelHashMap> list ) throws Exception {
	
		String[] positions = position.split("_");
		
		if( positions.length!=3 ) {
			throw new Exception("invalid position format");
		}
		
		int r = Integer.parseInt(positions[0]);
		int initRow = r;
		
		int c = Integer.parseInt(positions[1]);
		int cMax = Integer.parseInt(positions[2]);
	
		Sheet sh = workbook.getSheet(sheetName);
		Row row = null;
		Cell cell = null;
		CellStyle style = null;
		CamelHashMap data = null;
		
		int lIndex = 0;
		
		for( int i=r; i<r+list.size(); i++ ) {
			
			data = list.get(lIndex);
					
		    if(i==initRow) row = sh.getRow(i);
		    else row = sh.createRow(i);
		        
		    int cIndex = 0;
			for( int col=c; col<c+cMax; col++  ) {
				
				style = sh.getRow(initRow).getCell(col).getCellStyle();
		       	
				if(i>initRow) {
		       		cell = row.createCell(col);
		       		cell.setCellStyle(style);
		       	}else {
		       		cell = row.getCell(col);
		       	}
				
				String value = getValue( sheetName, cell, data, i, col, lIndex, cIndex );
				cell.setCellValue( "null".equals(value)?"":value );
				
				cIndex++;
			}
			
			lIndex++;
			
		}//end forList
		
		
	}//setList
	
	
	public void setField( String sheetName, String position, String value ) throws Exception {
		
		String[] positions = position.split("_");
		
		if( positions.length!=3 ) {
			throw new Exception("invalid position format");
		}
		
		int r = Integer.parseInt(positions[0]);
		int c = Integer.parseInt(positions[1]);
		
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.getRow(r);
		Cell cell = row.getCell(c);
		
		cell.setCellValue( isNull(value) );
		
	}
	
	public void setField( String sheetName, String position, String[] value ) throws Exception {
		
		String[] positions = position.split("_");
		
		if( positions.length!=3 ) {
			throw new Exception("invalid position");
		}
		
		int r = Integer.parseInt(positions[0]);
		int c = Integer.parseInt(positions[1]);
		int cCnt = Integer.parseInt(positions[2]);
		
		
		if( cCnt!=value.length ) throw new Exception("Non Matching Column by Value index");
		
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.getRow(r);
		
		int cIndex = 0;
		for( int i=c; i<c+cCnt; i++ ) {
			Cell cell = row.getCell(i);
			cell.setCellValue( isNull(value[cIndex]) );
			cIndex++;
		}
		
	}
	
	public void setField( String sheetName, String position, String[] dataDef, CamelHashMap data) throws Exception {
		
		String[] positions = position.split("_");
		
		if( positions.length!=3 ) {
			throw new Exception("invalid position");
		}
		
		int r = Integer.parseInt(positions[0]);
		int c = Integer.parseInt(positions[1]);
		int cCnt = Integer.parseInt(positions[2]);
		
		
		if( cCnt!=dataDef.length ) throw new Exception("Non Matching Column by Value index");
		
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.getRow(r);
		
		int cIndex = 0;
		for( int i=c; i<c+cCnt; i++ ) {
			Cell cell = row.getCell(i);
			cell.setCellValue( isNull(String.valueOf(data.get(dataDef[cIndex]))) );
			cIndex++;
		}		
		
	}
	
	public void setVerticalField( String sheetName, String position, String[] value ) throws Exception {
		
		String[] positions = position.split("_");
		
		if( positions.length!=3 ) {
			throw new Exception("invalid position");
		}
		
		int r = Integer.parseInt(positions[0]);
		int c = Integer.parseInt(positions[1]);
//		int cCnt = Integer.parseInt(positions[2]);
		
		Sheet sh = workbook.getSheet(sheetName);
		Row row = null;
		Cell cell = null;
		
		int cIndex = 0;
		for( int i=r; i<r+value.length; i++ ) {
			
			row = sh.getRow(i);
			cell = row.getCell(c);
			
			cell.setCellValue( isNull(value[cIndex]) );
			
			cIndex++;
		}//end for
		
	}
	
	public void setVerticalField( String sheetName, String position, String[] dataDef, CamelHashMap data ) throws Exception {
		
		String[] positions = position.split("_");
		
		if( positions.length!=3 ) {
			throw new Exception("invalid position");
		}
		
		int r = Integer.parseInt(positions[0]);
		int c = Integer.parseInt(positions[1]);
//		int cCnt = Integer.parseInt(positions[2]);
		
		Sheet sh = workbook.getSheet(sheetName);
		Row row = null;
		Cell cell = null;
		
		int cIndex = 0;
		for( int i=r; i<r+dataDef.length; i++ ) {
			
			row = sh.getRow(i);
			cell = row.getCell(c);
			
			cell.setCellValue( isNull(String.valueOf(data.get(dataDef[cIndex]))) );
			
			cIndex++;
		}//end for
		
	}	
	
	public String isNull( String value ) {
		if(value==null || "null".equals(value.toLowerCase()) ) {
			return "";
		}
		
		return value;
	}
	
	
	private String createFileName() {
//		ENCOCNS_DB저축은행 IFRS구축_테이블목록_V0.1
		String fileName = document.replaceAll("\\\\", " ")
									.replaceAll("/", " ")
									.replaceAll(":", ";")
									.replaceAll("\\*", " ")
									.replaceAll("\"", "'")
									.replaceAll("<", "(")
									.replaceAll(">", ")")
									.replaceAll("\\|", ";");
		
		
		return seperateStrName(new String[]{ company
										   , clientName
										   , projectName
										   , fileName
										   , "V"+version+DocumentConst.XLSX}, DocumentConst.SEPERATOR);
	}
	
	
	private String seperateStrName( String[] names, String seperate ) {
		
		int i=1;
		StringBuffer sb = new StringBuffer();
		for( String fName : names ) {
			sb.append(fName);
			if( i<names.length ) sb.append(seperate);
			i++;
		}
		
		LOGGER.debug(">>>>seperateStrName : " + sb.toString());
		
		return sb.toString();
		
	}
	
	//파일생성
	public void write() throws FileNotFoundException, IOException {
		
        // 엑셀 출력
        FileOutputStream fos = new FileOutputStream( 
        		seperateStrName( new String[] { outputLocation , createFileName() }, DocumentConst.FILE_SEPERATOR ) );
        workbook.write(fos);
        workbook.close();
		
	}//write
	
	
	/* Setter/Getter */
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	public void setDocument(String document, String[] args) {
		this.document = MessageFormat.format(document, args);
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getConfigFile() {
		return configFile;
	}
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}
	public String getTemplateLocation() {
		return templateLocation;
	}
	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
	}
	public String getOutputLocation() {
		return outputLocation;
	}
	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}
	public String getDbUserNm() {
		return dbUserNm;
	}
	public void setDbUserNm(String dbUserNm) {
		this.dbUserNm = dbUserNm;
	}
	public HashMap<String, String> getParameter() {
		return parameter;
	}
	public void setParameter(HashMap<String, String> parameter) {
		this.parameter = parameter;
	}
	public String getBatchPrjLocation() {
		return batchPrjLocation;
	}
	public void setBatchPrjLocation(String batchPrjLocation) {
		this.batchPrjLocation = batchPrjLocation;
	}
	
	
	
}

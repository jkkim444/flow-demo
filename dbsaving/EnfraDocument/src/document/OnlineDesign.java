package document;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.OnlineDesignDAO;
import db.CamelHashMap;

public class OnlineDesign extends AbstractDocumentBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineDesign.class);
	
	@Autowired
	private OnlineDesignDAO onlineDesignDAO;
	
	private String svcId;
	
	@Override
	public void init() {
		
		svcId = getParameter().get("svcId");
		CamelHashMap svcInfo = onlineDesignDAO.selectClassDef(svcId);
		
		//Load Property
		super.loadProperties("OnlineDesign.properties");
		
		//산출물공통
		super.setTemplate(getProperty("template"));
		super.setDocument(getProperty("document"), new String[]{String.valueOf(svcInfo.get("app")),svcId,String.valueOf(svcInfo.get("description"))});
		
		super.createExcel();
	}
	
	
	@Override
	public void makeBody() throws Exception {
		
		String sheetName = "";
		String position = "";
		
		CamelHashMap data = null;
		ArrayList<CamelHashMap> dataList = null;
		
		/** Service Class Design Sheet */
		sheetName = "Service Class Design";
		
		position = getProperty("클래스디자인_subject");
		data = onlineDesignDAO.selectSubject(svcId);
		setVerticalField(sheetName, position, new String[]{"domain","appGroup","app"},  data);
		
		position = getProperty("클래스디자인_classDef");
		data = onlineDesignDAO.selectClassDef(svcId);
		setVerticalField(sheetName, position, new String[]{"pkg","clsName","typ","description"},  data);
		
		position = getProperty("클래스디자인_methodDefList");
		dataList = onlineDesignDAO.selectMethodDefList(svcId);
		setList(sheetName, position, dataList);
		
		
		/** Service Method Logic */
		sheetName = "Service Method Logic";
		position = getProperty("서비스로직_svcName");
		setField(sheetName, position, svcId);
		
		position = getProperty("서비스로직_methodList");
		dataList = onlineDesignDAO.selectMethodList(svcId);
		setList(sheetName, position, dataList);
		
	}//makeBody
	
	@Override
	public String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) {

		String value = "";
		
		if( "Service Class Design".equals(sheetName) ) {
			value = createMethodDef( cell, data, row, col, cIndex );
		}
		else if("Service Method Logic".equals(sheetName)) {
			value = createMethod( cell, data, row, col, cIndex );
		}
		return value;
		
	}
	
	private String createMethodDef( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"rnum","mthId","mthNm","relScr","rmkCntn"};
		return String.valueOf(data.get(key[cIndex]));
	}
	
	private String createMethod( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"mthId","mthNm","logicTyp","logicDesc","compTyp","no","relCompDomain","ruleId","compClass","compMethod"};
		return String.valueOf(data.get(key[cIndex]));
	}
	

}


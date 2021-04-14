package document;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.CodeDesignDAO;
import db.CamelHashMap;

public class CodeDesign extends AbstractDocumentBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodeDesign.class);
	
	@Autowired
	private CodeDesignDAO codeDesignDAO; 
	
	@Override
	public void init() {
		
		//Load Property
		super.loadProperties("CodeDesign.properties");
		
		//산출물공통
		super.setTemplate(getProperty("template"));
		super.setDocument(getProperty("document"));
		
		super.createExcel();
	}
	
	
	@Override
	public void makeBody() throws Exception {
		
		ArrayList<CamelHashMap> cdDmnList = codeDesignDAO.selectCdDmnList();
		
		String poisition = getProperty("코드목록_cdDomainList");
		setList( "코드목록", poisition,  cdDmnList );
		
		ArrayList<CamelHashMap> cdList = codeDesignDAO.selectCdList();
		
		String poisition2 = getProperty("코드설계서_cdList");
		setList( "코드설계서", poisition2,  cdList );
		
		
	}//makeBody
	
	@Override
	public String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) {

		String value = "";
		
		if( "코드목록".equals(sheetName) ) {
			value = createCodeDomain( cell, data, row, col, cIndex );
		}
		if( "코드설계서".equals(sheetName) ) {
			value = createCodeList( cell, data, row, col, cIndex );
		}
		
		return value;
		
	}
	
	private String createCodeDomain( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"rnum", "cdDmnId","cdDmnNm", "rmkCntn", "chngDv"};
		return String.valueOf(data.get(key[cIndex]));
	}
	
	private String createCodeList( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"rnum", "cdDmnId","cdDmnNm", "cd", "cdNm", "rmkCntn", "chngDv"};
		return String.valueOf(data.get(key[cIndex]));
	}
	

}


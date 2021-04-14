package document;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.ScreenListDAO;
import db.CamelHashMap;

public class ScreenList extends AbstractDocumentBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScreenList.class);
	
	@Autowired
	private ScreenListDAO screenListDAO; 
	
	@Override
	public void init() {
		
		//Load Property
		super.loadProperties("ScreenList.properties");
		
		//산출물공통
		super.setTemplate(getProperty("template"));
		super.setDocument(getProperty("document"));
		
		super.createExcel();
	}
	
	
	@Override
	public void makeBody() throws Exception {
		
		ArrayList<CamelHashMap> pgmList = screenListDAO.selectScrList();
		
		String poisition = getProperty("작성_scrList");
		setList( "작성", poisition,  pgmList );
		
		
	}//makeBody
	
	@Override
	public String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) {

		String value = "";
		
		if( "작성".equals(sheetName) ) {
			value = createScreenList( cell, data, row, col, cIndex );
		}
		
		return value;
		
	}
	
	private String createScreenList( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"rnum","taskSub","scrId","scrNm","scrDv","imp","lvl","rmkCntn"};
		return String.valueOf(data.get(key[cIndex]));
	}
	

}


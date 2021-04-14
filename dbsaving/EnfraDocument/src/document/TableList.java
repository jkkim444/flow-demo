package document;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.TableListDAO;
import db.CamelHashMap;

public class TableList extends AbstractDocumentBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(TableList.class);
	
	@Autowired
	private TableListDAO tableListDAO; 
	
	@Override
	public void init() {
		
		//Load Property
		super.loadProperties("TableList.properties");
		
		//산출물공통
		super.setTemplate(getProperty("template"));
		super.setDocument(getProperty("document"));
		
		super.createExcel();
	}
	
	
	@Override
	public void makeBody() throws Exception {
		ArrayList<CamelHashMap> tblList = tableListDAO.selectTblList(getDbUserNm());
		
		String poisition = getProperty("작성_tblList");
		setList( "작성", poisition,  tblList );
		
	}//makeBody
	
	@Override
	public String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) {

		String value = "";
		
		if( "작성".equals(sheetName) ) {
			value = createTableList( cell, data, row, col, cIndex );
		}
		
		return value;
		
	}
	
	private String createTableList( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"rnum","taskDv","tableName","comments", "tableDesc"};
		return String.valueOf(data.get(key[cIndex]));
	}
	

}


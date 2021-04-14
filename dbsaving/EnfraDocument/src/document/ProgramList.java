package document;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.ProgramListDAO;
import db.CamelHashMap;

public class ProgramList extends AbstractDocumentBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgramList.class);
	
	@Autowired
	private ProgramListDAO programListDAO; 
	
	@Override
	public void init() {
		
		//Load Property
		super.loadProperties("ProgramList.properties");
		
		//산출물공통
		super.setTemplate(getProperty("template"));
		super.setDocument(getProperty("document"));
		
		super.createExcel();
	}
	
	
	@Override
	public void makeBody() throws Exception {
		
		ArrayList<CamelHashMap> pgmList = programListDAO.selectPgmList();
		
		String poisition = getProperty("작성_pgmList");
		setList( "작성", poisition,  pgmList );
		
		
	}//makeBody
	
	@Override
	public String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) {

		String value = "";
		
		if( "작성".equals(sheetName) ) {
			value = createProgramList( cell, data, row, col, cIndex );
		}
		
		return value;
		
	}
	
	private String createProgramList( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
		String[] key = new String[]{"rnum","sysDv","taskNm","taskSub","taskSubDtl","pgmDv","scrDv","clsNm","pgmId","pgmNm"};
		return String.valueOf(data.get(key[cIndex]));
	}
	

}


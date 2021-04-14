package document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.poi.ss.usermodel.Cell;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.MethodCallExpr;

import consts.ConfigConst;
import dao.BatchDesignDAO;
import db.CamelHashMap;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.merge.Merge;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.TablesNamesFinder;

public class BatchDesign extends AbstractDocumentBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchDesign.class);
    
    @Autowired
    private BatchDesignDAO batchDesignDAO;
    
    @Autowired
    private ApplicationContext context;
    
    private String batId;
    private CamelHashMap batInfo; 
            
    @Override
    public void init() {
        
        batId = getParameter().get("batId");
        batInfo = batchDesignDAO.selectSubject(batId);
        
        //Load Property
        super.loadProperties("BatchDesign.properties");
        
        //산출물공통
        super.setTemplate(getProperty("template"));
        super.setDocument(getProperty("document"), new String[]{String.valueOf(batInfo.get("batId")),String.valueOf(batInfo.get("batNm"))});
        
        super.createExcel();
    }
    
    
    @Override
    public void makeBody() throws Exception {
        
        String sheetName = "";
        String position = "";
        
        ArrayList<CamelHashMap> dataList = null;
        
        /** Batch Design Sheet */
        sheetName = "Batch Design";
        
        position = getProperty("배치디자인_subject");
        setVerticalField(sheetName, position, new String[]{
                                                             "domain"
                                                            ,"appGroup"
                                                            ,"app"
                                                            ,"func"
                                                            ,"funcDtl"
                                                            ,"batId"
                                                            ,"batNm"
                                                            ,"batDesc"
                                                            ,"cdNm"
                                                            ,"preCond"
        },  batInfo);

        
        String batchPath  = String.valueOf(batInfo.get("batPath")).replaceAll("\\.","/");

        position = getProperty("배치디자인_desc");
        setField(sheetName, position, getBatDescriptoin(batchPath));
        
        position = getProperty("배치디자인_flow");
        ArrayList<CamelHashMap> flowList = new ArrayList<CamelHashMap>();

        ArrayList<String> mapperList = getMapperList(batchPath);
        
        int seq=1;
        for( String mapper : mapperList  ) {
            
            CamelHashMap data = new CamelHashMap();
            data.put("SEQ", seq);
            data.put("MAPPER_ID", mapper);
            data.put("MAPPER_DESC", getMapperDesc(batchPath, mapper));
            
            Map<String, String> tableMap = getTableList(mapper);
            data.put("INPUT_TYPE", "Table");
            data.put("INPUT_TABLE", tableMap.get("inputTable"));
            data.put("INPUT_SRC_TYPE", "N/A");
            data.put("INPUT_SRC_ID", "N/A");
            data.put("INPUT_SRC_NM", "N/A");
            data.put("LOGIC", "");
            data.put("OUTPUT_TYPE", "Table");
            data.put("OUTPUT_TABLE", tableMap.get("outputTable"));
            data.put("OUTPUT_SRC_TYPE", "N/A");
            data.put("OUTPUT_SRC_ID", "N/A");
            data.put("OUTPUT_SRC_NM", "N/A");
            
            flowList.add(data);
            
            seq++;
            
        }//end for
        
        setList(sheetName, position, flowList);
        
    }//makeBody
    
    
    public String getBatDescriptoin( String batPath ) throws Exception {
        
        String fullPath = getBatchPrjLocation() + "/src/main/java/" + batPath+".java";
        
        CompilationUnit compilationUnit = JavaParser.parse( new File(fullPath), Charset.forName(ConfigConst.ENCODING) );
        
        List<Comment> comments = compilationUnit.getComments();
        
        int i=0;
        int preChkIdx = 1;
        
        String description="";
        
        for( Comment cmt : comments ) {
         
            if( preChkIdx==2 && cmt.toString().indexOf("@details")>-1 ) {
//           System.out.println(cmt);
                description = cmt.toString();
                break;
            }
            if( cmt.toString().indexOf("@details")>-1 ) preChkIdx++;
            i++;
        }//end for
        
        return description;
    }
    
    
    public ArrayList<String> getMapperList( String batPath ) throws Exception {
        
         ArrayList<String> mapperList = new ArrayList<String>();
         
         String fullPath = getBatchPrjLocation() + "/src/main/java/" + batPath+".java";
         
//       CompilationUnit compilationUnit = JavaParser.parse( new File("C:/project/workspace/kakaobank_batch_ifr/src/src/main/java/com/kakaobank/cfw/job/CFWDB1001.java"), Charset.forName(ConfigConst.ENCODING) );
         CompilationUnit compilationUnit = JavaParser.parse( new File(fullPath), Charset.forName(ConfigConst.ENCODING) );
         
         List<MethodCallExpr> mthList = compilationUnit.findAll( MethodCallExpr.class );
         List<VariableDeclarator> varList = compilationUnit.findAll( VariableDeclarator.class );
         
         for( MethodCallExpr mth : mthList ) {
             
             String varName = mth.getChildNodes().get(0).toString();
             String mthName = mth.getNameAsString().toUpperCase();
             
             for( VariableDeclarator var : varList ) {
                 
                 if( 
                         var.getNameAsString().equals(varName) &&
                         var.getTypeAsString().indexOf("JobParameters")>=0  ) {
                     
                     if( mthName.indexOf("GET")>-1 ) {
//                       System.out.println(mth.getNameAsString());
//                       System.out.println(mth.getArguments().get(0).toString().replace("\"", ""));
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
//                           System.out.println(mth.getNameAsString());
//                           System.out.println(mth.getArguments().get(0).toString().replace("\"", ""));
                             mapperList.add(mth.getArguments().get(0).toString().replace("\"", ""));
                         }
                         
//                       System.out.println("=====================================");
                     }
                     
                     break;
                 }//queryId
                 
             
             }//end for
             
             
         }//end for
         
         return mapperList;
         
    }
    
    
    public Map<String, String> getTableList( String mapper ) throws Exception {
        
        SqlSessionTemplate batchSqlSessionTemplate = (SqlSessionTemplate)context.getBean("batchSqlSessionTemplate");
        
        Map<String, String> tableMap = new HashMap<String, String>();
        tableMap.put("inputTable", "");
        tableMap.put("outputTable", "");
        
        MappedStatement mappedStat = batchSqlSessionTemplate.getConfiguration().getMappedStatement(mapper);
        String sql = mappedStat.getBoundSql(null).getSql();
        SqlCommandType type = mappedStat.getSqlCommandType();
        String queryType = type.name();
         
        Statement statement = CCJSqlParserUtil.parse(sql);
         
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        ArrayList<String> inputTable = new ArrayList<String>();
        ArrayList<String> outputTable = new ArrayList<String>();
                
        if(SqlCommandType.SELECT.equals(type)) {
         
            List<String> tableList = tablesNamesFinder.getTableList((Select) statement);
            for( String t : tableList ) {
                inputTable.add(t);
            }
         
        }
        else if(SqlCommandType.DELETE.equals(type)) {
            List<String> tableList = tablesNamesFinder.getTableList((Delete) statement);
            int i=0;
            for( String t : tableList ) {
                if( i==0 ) {
                    outputTable.add(t);
                }
                else {
                    inputTable.add(t);
                }
                i++;
            }        
        }
        else if(SqlCommandType.INSERT.equals(type)) {
            
            List<String> tableList = null;
            
            if( sql.toUpperCase().indexOf("MERGE")>=0 ) {
                tableList = tablesNamesFinder.getTableList((Merge) statement);
            }
            else {
                tableList = tablesNamesFinder.getTableList((Insert) statement);
            }
            
            int i=0;
            for( String t : tableList ) {
                if( i==0 ) {
                    outputTable.add(t);
                }
                else {
                    inputTable.add(t);
                }
                i++;
            }
            
        }
        else if(SqlCommandType.UPDATE.equals(type)) {
         
            List<String> tableList = null;
            
            if( sql.toUpperCase().indexOf("MERGE")>=0 ) {
                tableList = tablesNamesFinder.getTableList((Merge) statement);
            }
            else {
                tableList = tablesNamesFinder.getTableList((Update) statement);
            }
            
            int i=0;
            for( String t : tableList ) {
                if( i==0 ) {
                    outputTable.add(t);                    
                }
                else {
                    inputTable.add(t);
                }
                i++;
            }
            
        }
        
        String strInputTable = StringUtils.join(inputTable, "\r\n");
        String strOutputTable= StringUtils.join(outputTable, "\r\n");
        
        tableMap.put("inputTable",  "".equals(strInputTable)?"N/A":strInputTable);
        tableMap.put("outputTable", "".equals(strOutputTable)?"N/A":strOutputTable);
        
        return tableMap;
        
    }
    
    
    public String getMapperDesc( String batPath, String mapper ) throws Exception {
        
        String mapperDesc = "";
        
//      String mapperId = mapper.split(".")[0];
        String queryId = mapper.split("\\.")[1];
        String filePath = getBatchPrjLocation() + "/src/main/resources/"+batPath.replace("/job", "/mapper")+".xml";
        
         //파일 객체 생성1
//        File file = new File("C:/project/workspace/EnfraGridSvc/src/com/encocns/co/mapper/CO3010.xml");
        File file = new File(filePath);
        
        //입력 스트림 생성
        FileReader filereader = new FileReader(file);
        //입력 버퍼 생성
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        String preline = "";
        while((line = bufReader.readLine()) != null){
         if( line.indexOf(queryId)>=0 ) {
             /* 이전라인 주석판단 */
             if( preline.indexOf("<!--")>=0 ) {
//                   System.out.println(preline.replaceAll("<!--\\s*(.+)\\s*-->", "$1").trim());
                 mapperDesc = preline.replaceAll("<!--\\s*(.+)\\s*-->", "$1").trim();
             }
             break;
         }
            
         preline = line;
        }
        //.readLine()은 끝에 개행문자를 읽지 않는다.
        bufReader.close();
        
        return mapperDesc;
        
    }
    
    @Override
    public String getValue(String sheetName, Cell cell, CamelHashMap data, int row, int col, int lIndex, int cIndex) {

        String value = createMapperFlow( cell, data, row, col, cIndex );
        return value;
        
    }
    
    private String createMapperFlow( Cell cell, CamelHashMap data, int row, int col, int cIndex ) {
        String[] key = new String[]{ "seq"
                                    ,"mapperId"
                                    ,"mapperDesc"
                                    ,"inputType"
                                    ,"inputTable"
                                    ,"inputSrcType"
                                    ,"inputSrcId"
                                    ,"inputSrcNm"
                                    ,"logic"
                                    ,"outputType"
                                    ,"outputTable"
                                    ,"outputSrcType"
                                    ,"outputSrcId"
                                    ,"outputSrcNm"};
        return String.valueOf(data.get(key[cIndex]));
        
    }
    

}


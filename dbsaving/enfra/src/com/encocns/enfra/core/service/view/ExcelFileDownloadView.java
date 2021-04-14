/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file FileDownloadView.java
 * @brief File Download View
 */
/**
 * @namespace com.encocns.fw.view
 * @brief View Package
 */
package com.encocns.enfra.core.service.view;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import com.encocns.enfra.exception.EnfraCoreException;

/**
 * @brief 파일 다운로드에 사용되는 View
 * @details 파일 다운로드에 사용되는 View
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 27.
 * @version : 1.0.0
 */
public class ExcelFileDownloadView  {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private String fileName;
    private String reportName; //required!
    private ArrayList<Map<String, Object>> sheetList; //required!

    public void excelInit( String fileName, String reportName, ArrayList<Map<String, Object>> sheetList, HttpServletRequest request, HttpServletResponse response ) {
        init();
        this.request = request;
        this.response = response;
        this.fileName = fileName;
        this.reportName = reportName;
        this.sheetList = sheetList;
        setHeader();
    }

    public void excelInit( String reportName, ArrayList<Map<String, Object>> sheetList, HttpServletRequest request, HttpServletResponse response  ) {
        init();
        this.request = request;
        this.response = response;
        this.reportName = reportName;
        this.sheetList = sheetList;
        setHeader();
    }

    private void setHeader() {
        response.setContentType("applicaiton/download;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Transfer-Encoding", "binary");
    }

    private void init() {
        request = null;
        response = null;
        fileName = null;
        reportName = null;
        sheetList = null;
    }


    public void excelDownload() throws EnfraCoreException, FileNotFoundException, IOException{

        if( reportName==null ) {
            throw new EnfraCoreException("Excel report Name required!");
        }

        if( sheetList==null ) {
            throw new EnfraCoreException("Excel sheetList required!");
        }


        if(fileName==null) fileName = reportName;

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/template");
        String excel = path + File.separator + reportName;

        FileInputStream fis = new FileInputStream(excel);
        OutputStream  os = response.getOutputStream();

        XSSFWorkbook wb = new XSSFWorkbook(fis); // Excel 2007 이상
        SXSSFWorkbook metaWb = new SXSSFWorkbook(1000);

        int iSheet = 0;

        try {

            for( Map<String, Object> sheetMap : sheetList ) {

                if( !sheetMap.containsKey("headerRow") ) throw new EnfraCoreException("headerRowIndex required!!!");
                if( Integer.valueOf(String.valueOf(sheetMap.get("headerRow")))<0 ) throw new EnfraCoreException("Invalid header row Index !!");

                Sheet sheet = wb.getSheetAt(iSheet);

                Sheet sh = null;
                if( sheetMap.containsKey("sheetName") )
                    sh = metaWb.createSheet(String.valueOf(sheetMap.get("sheetName")));
                else
                    sh = metaWb.createSheet();

                List<CellRangeAddress> merge = sheet.getMergedRegions();

                for(  CellRangeAddress addr : merge ) {
                    sh.addMergedRegion(addr);
                }


//                sheet.getColumnWidth(arg0)



                ArrayList<ArrayList<XSSFCell>> header = new ArrayList<ArrayList<XSSFCell>>();

                int rowCnt=Integer.valueOf(String.valueOf(sheetMap.get("headerRow")));
                int keyIndex=rowCnt+1;
                int dataIndex=rowCnt+2;

                for( int i=0; i<(rowCnt+1); i++ ) {

                    ArrayList<XSSFCell> headerCell = new ArrayList<XSSFCell>();

                    int col=0;

                    while(true) {

                        XSSFCell cell = (XSSFCell)sheet.getRow(i).getCell(col);

                        sh.setColumnWidth(col, sheet.getColumnWidth(col));

                        if(cell ==null) {
                            break;
                        }

                        headerCell.add(cell);
                        col++;
                    }//while


                    header.add(headerCell);

                }//for header

                //create datacellstyle
                ArrayList<CellStyle> cellStyleList = new ArrayList<CellStyle>();

                ArrayList<String> key = new ArrayList<String>();

                int col=0;
                while(true) {

                    XSSFCell cell = (XSSFCell)sheet.getRow(dataIndex).getCell(col);
                    XSSFCell keyCell = (XSSFCell)sheet.getRow(keyIndex).getCell(col);

                    if(cell ==null) {
                        break;
                    }

                    CellStyle style = metaWb.createCellStyle();
                    style.cloneStyleFrom(cell.getCellStyle());
                    cellStyleList.add(style);

                    //bindKeyList
                    key.add(keyCell.getStringCellValue());

                    col++;

                }//while


                Row row = null;
                Cell cell = null;

                int rowIndex=0;
                for( ArrayList<XSSFCell> headerCellList : header ) {
                    row = sh.createRow(rowIndex);
                    int j=0;
                    for( XSSFCell headerCell : headerCellList ) {

                        cell = row.createCell(j);

                        CellStyle style = metaWb.createCellStyle();
                        style.cloneStyleFrom(headerCell.getCellStyle());

                        cell.setCellStyle(style);

                        switch (headerCell.getCellTypeEnum()) {
                            case BOOLEAN:
                                cell.setCellValue(headerCell.getBooleanCellValue());
                                break;
                            case NUMERIC:
                                cell.setCellValue(headerCell.getNumericCellValue());
                                break;
                            case STRING:
                                cell.setCellValue(headerCell.getStringCellValue());
                                break;
                            case BLANK:
                                break;
                            default:
                                break;
                        }

//                        Comment src = headerCell.getCellComment();
//
//                        if( src!=null ) {
//                            Drawing drawing_master = sh.createDrawingPatriarch();
//                            Comment comment_master = drawing_master.createCellComment(src.getClientAnchor());
//                            comment_master.setString(src.getString());
//                            cell.setCellComment(comment_master);
//                        }

                        j++;
                    }

                    rowIndex++;

                }//for header

                //data
                if( !sheetMap.containsKey("data") ) {
                    throw new EnfraCoreException("data repuired!");
                }

                List<T> dataList = (List<T>)sheetMap.get("data");

                if( dataList==null ) {
                    throw new EnfraCoreException("data repuired!");
                }

                for(Object excelRow :  dataList) {

                    row = sh.createRow(keyIndex);

                    Class clz = excelRow.getClass();
                    row = sh.createRow(keyIndex);
                    int j=0;

                    for( CellStyle style : cellStyleList ) {
                        cell = row.createCell(j);
                        cell.setCellStyle(style);

                        String filedName = key.get(j);

                        if(filedName.substring(0,  1).matches("[a-z]+") &&
                                filedName.substring(1,  2).matches("[A-Z]+")
                                ) {
                            filedName = "get"+filedName;
                        } else {
                            filedName = "get"+StringUtils.capitalize(filedName);
                        }

                        try{

                            Field[] fields = clz.getDeclaredFields();

                            for( Field f : fields ) {

                                if( f.getName().equals(key.get(j)) ) {

                                    Method getMethod = excelRow.getClass().getMethod(filedName, null);
                                    Class returnType = getMethod.getReturnType();
                                    Object value = getMethod.invoke(excelRow, null);

                                    if( value==null ) continue;

                                    if (returnType.equals(String.class))
                                    {
                                        cell.setCellValue(String.valueOf(value));
                                    }
                                    else if (returnType.isPrimitive())
                                    {
                                        if (returnType.equals(Boolean.TYPE))
                                            cell.setCellValue(Boolean.valueOf(String.valueOf(value)));

                                        else if (returnType.equals(Byte.TYPE))
                                            cell.setCellValue(String.valueOf(value));

                                        else if (returnType.equals(Short.TYPE))
                                            cell.setCellValue(Double.valueOf(String.valueOf(value)));

                                        else if (returnType.equals(Integer.TYPE))
                                            cell.setCellValue(Double.valueOf(String.valueOf(value)));

                                        else if (returnType.equals(Long.TYPE))
                                            cell.setCellValue(Double.valueOf(String.valueOf(value)));

                                        else if (returnType.equals(Float.TYPE))
                                            cell.setCellValue(Double.valueOf(String.valueOf(value)));

                                        else if (returnType.equals(Double.TYPE))
                                            cell.setCellValue(Double.valueOf(String.valueOf(value)));
                                    }
                                    else if(returnType.equals(BigDecimal.class)) {
                                        cell.setCellValue(String.valueOf(value));
                                    }
                                    else if(returnType.equals(Double.class)) {
                                        cell.setCellValue(Double.valueOf(String.valueOf(value)));
                                    }
                                    else if(returnType.equals(Integer.class)) {
                                        cell.setCellValue(Double.valueOf(String.valueOf(value)));
                                    }
                                    else if(returnType.equals(Long.class)) {
                                        cell.setCellValue(Double.valueOf(String.valueOf(value)));
                                    }
                                    else if(returnType.equals(Float.class)) {
                                        cell.setCellValue(Double.valueOf(String.valueOf(value)));
                                    }
                                    else {
                                        cell.setCellValue(String.valueOf(value));
                                    }

                                    break;
                                }
                            }//


                        }catch(Exception e) {
                            e.printStackTrace();
                            System.out.println("error!!!");
                        }

                        j++;
                    }//for

                    keyIndex++;

                }//dataList


//                JsonElement je = JsonUtil.getObject(dataList);
//                JsonArray jArray = je.getAsJsonArray();
//
//                for( int i=0; i<jArray.size(); i++ ) {
//                    JsonObject jRow = jArray.get(i).getAsJsonObject();
//                    row = sh.createRow(keyIndex);
//                    int j=0;
//
//                    for( CellStyle style : cellStyleList ) {
//                        cell = row.createCell(j);
//                        cell.setCellStyle(style);
//
//                        if(jRow.has(key.get(j))) {
//                            cell.setCellValue(jRow.get(key.get(j)).getAsDouble());
//                        }
//
//                        j++;
//                    }//for
//
//                    keyIndex++;
//                }//for

                //add
                iSheet++;

            }//for sheetList

            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") );
            metaWb.write(os);
        }
        finally {
            os.close();
            fis.close();
        }
    }//init





    public void customExcelDownload() throws EnfraCoreException, FileNotFoundException, IOException{
        if( reportName==null ) {
            throw new EnfraCoreException("Excel report Name required!");
        }

        if( sheetList==null ) {
            throw new EnfraCoreException("Excel sheetList required!");
        }

        if(fileName==null) fileName = reportName;


        ArrayList<HashMap<String, Object>> reportList = (ArrayList<HashMap<String, Object>>) sheetList.get(0).get("data");
        OutputStream  os = response.getOutputStream();

        XSSFWorkbook workbook = new XSSFWorkbook();

        try {

            for( Map<String, Object> sheetData : reportList ) {

            	XSSFSheet sheet = workbook.createSheet((String) sheetData.get("sheetName"));
    			// 행 계산
    			int rowCount = 0;

    			// width 셋팅 (default 72 pixel)
    			if(sheetData.containsKey("width") && sheetData.get("width") != null){
    				ArrayList<Integer> widthData = (ArrayList<Integer>) sheetData.get("width");
    				for(int i=0; i<widthData.size(); i++){
    					sheet.setColumnWidth(i,widthData.get(i)*32);
    				}
    			}

    			// 헤더 셋팅
    			if(sheetData.containsKey("header") && sheetData.get("header") != null){
    				ArrayList<ArrayList<String>> headerData = (ArrayList<ArrayList<String>>) sheetData.get("header");
    				Row headerRow = null;
    				Cell headerCell = null;
    				CellStyle headerCs  = workbook.createCellStyle();
    				Font font = workbook.createFont();
    				font.setBold(true);

    				headerCs.setFillForegroundColor(HSSFColorPredefined.GREY_40_PERCENT.getIndex());
    				headerCs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    				headerCs.setAlignment(HorizontalAlignment.CENTER);
    				headerCs.setVerticalAlignment(VerticalAlignment.CENTER);
    				headerCs.setBorderTop(BorderStyle.THIN);
    				headerCs.setBorderRight(BorderStyle.THIN);
    				headerCs.setBorderBottom(BorderStyle.THIN);
    				headerCs.setBorderLeft(BorderStyle.THIN);

    				headerCs.setFont(font);
//    				CellStyle.ALIGN_GENERAL
//    				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

    				for(ArrayList<String> headers : headerData){

    					// 행 생성
    					headerRow = sheet.createRow(rowCount);
    					int colCount = 0;

    					for(String header : headers){
    						// 셀 생성
    						headerCell = headerRow.createCell(colCount);

    						headerCell.setCellValue(header);
    						headerCell.setCellStyle(headerCs);
    						colCount++;
    					}

    					rowCount++;
    				}
    			}
    			// 헤더 머지 셋팅
    			if(sheetData.containsKey("mergeHeader") && sheetData.get("mergeHeader") != null){
    				ArrayList<HashMap<String, Double>> mergeInfo = (ArrayList<HashMap<String, Double>>) sheetData.get("mergeHeader");
    				for(HashMap<String, Double> info : mergeInfo){
    					CellRangeAddress cellRangeAddress = new CellRangeAddress(info.get("fromRow").intValue(), info.get("toRow").intValue(), info.get("fromColumn").intValue(), info.get("toColumn").intValue());
    					sheet.addMergedRegion(cellRangeAddress);
    				}
    			}
    			// 데이터 셋팅
    			if(sheetData.containsKey("data") && sheetData.get("data") != null){
    				ArrayList<ArrayList<Object>> dataList = (ArrayList<ArrayList<Object>>) sheetData.get("data");
    				Row dataRow = null;
    				Cell dataCell = null;
    				Font dataFont  = workbook.createFont();

    				// 셀스타일 메모리 문제로 인한 재활용성 코드
    				CellStyle[][][][] dataCs = getStyleTemp(workbook);
    				int[] csValue = {0,0,0,0};

    				for(ArrayList<Object> datas : dataList){
    					// 행 생성
    					dataRow = sheet.createRow(rowCount);
    					int colCount = 0;

						for(Object data : datas){
							// 셀 생성
							dataCell = dataRow.createCell(colCount);

							if(data instanceof String){
								String cellData = (String) data;
	    						dataCell.setCellValue(cellData);
	    						dataCell.setCellStyle(dataCs[0][0][0][0]);
							}
							else if(data instanceof HashMap){
								for(int i=0; i<4; i++) csValue[i] = 0;

								HashMap<String, Object> cellData = (HashMap<String, Object>) data;
								dataCell.setCellValue((String)cellData.get("value"));
								if(cellData.containsKey("type") && cellData.get("type") != null){
									String type = (String) cellData.get("type");
									switch(type){
										case"num":
											if(String.valueOf(cellData.get("value")).matches("[-+]?\\d*\\.?\\d+")) {

												if(String.valueOf(cellData.get("value")).indexOf(".") > -1) {
													csValue[0] = 2;
					                    		} else {
					                    			csValue[0] = 1;
					                    		}
											}
										break;
										default:
									}
								}
								if(cellData.containsKey("align") && cellData.get("align") != null){
									String align = (String) cellData.get("align");
									switch(align){
										case"center":
											csValue[1] = 1;
										break;
										case"right":
											csValue[1] = 2;
										break;
										default:
											csValue[1] = 0;
									}
								}
								if(cellData.containsKey("color") && cellData.get("color") != null){
									String color = (String)cellData.get("color");
									switch(color){
										case"grey25":
											csValue[2] = 1;
										break;
										case"grey40":
											csValue[2] = 2;
										break;
										case"grey50":
											csValue[2] = 3;
										break;
										case"grey80":
											csValue[2] = 4;
										break;
										case"tan":
											csValue[2] = 5;
										break;
										case"yellow":
											csValue[2] = 6;
										break;
										case"red":
											csValue[2] = 7;
										break;
										case"pink":
											csValue[2] = 8;
										break;
										case"blue":
											csValue[2] = 9;
										break;
									}
								}
								if(cellData.containsKey("bold") && cellData.get("bold") != null){
									if((boolean)cellData.get("bold")) csValue[3] = 1;
								}

							}

							dataCell.setCellStyle(dataCs[csValue[0]][csValue[1]][csValue[2]][csValue[3]]);

							colCount++;
    					}

    					rowCount++;
    				}
    			}
    			// 데이터 머지 셋팅
    			if(sheetData.containsKey("mergeData") && sheetData.get("mergeData") != null){
    				ArrayList<HashMap<String, Double>> mergeInfo = (ArrayList<HashMap<String, Double>>) sheetData.get("mergeData");
    				for(HashMap<String, Double> info : mergeInfo){
    					CellRangeAddress cellRangeAddress = new CellRangeAddress(info.get("fromRow").intValue(), info.get("toRow").intValue(), info.get("fromColumn").intValue(), info.get("toColumn").intValue());
    					sheet.addMergedRegion(cellRangeAddress);
    				}
    			}
            }

            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") );
            workbook.write(os);
        }
        finally {
            os.close();
            workbook.close();
        }
    }

    // 재활용성 셀스타일 set 메소드
    private CellStyle setCs(XSSFWorkbook wb, String type, String align, String color, boolean bold){
    	CellStyle cs = wb.createCellStyle();
    	Font font  = wb.createFont();
    	font.setBold(bold);
    	cs.setVerticalAlignment(VerticalAlignment.CENTER);
    	cs.setBorderTop(BorderStyle.THIN);
    	cs.setBorderRight(BorderStyle.THIN);
    	cs.setBorderBottom(BorderStyle.THIN);
    	cs.setBorderLeft(BorderStyle.THIN);
    	cs.setFont(font);
    	XSSFDataFormat format = wb.createDataFormat();

    	// 타입
    	switch(type){
    		case"num":
    			cs.setDataFormat(format.getFormat("#,###"));
    		break;
    		case"decimal":
    			cs.setDataFormat(format.getFormat("#,##0.000"));
    		break;
    	}

    	// 정렬
    	switch(align){
			case"center":
				cs.setAlignment(HorizontalAlignment.CENTER);
			break;
			case"right":
				cs.setAlignment(HorizontalAlignment.RIGHT);
			break;
			default:
				cs.setAlignment(HorizontalAlignment.LEFT);
    	}

    	// 색상
    	switch(color){
    		case"grey25":
    			cs.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"grey40":
    			cs.setFillForegroundColor(HSSFColorPredefined.GREY_40_PERCENT.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"grey50":
    			cs.setFillForegroundColor(HSSFColorPredefined.GREY_50_PERCENT.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"grey80":
    			cs.setFillForegroundColor(HSSFColorPredefined.GREY_80_PERCENT.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"tan":
    			cs.setFillForegroundColor(HSSFColorPredefined.TAN.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"yellow":
    			cs.setFillForegroundColor(HSSFColorPredefined.LIGHT_YELLOW.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"red":
    			cs.setFillForegroundColor(HSSFColorPredefined.RED.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"pink":
    			cs.setFillForegroundColor(HSSFColorPredefined.ROSE.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    		case"blue":
    			cs.setFillForegroundColor(HSSFColorPredefined.LIGHT_BLUE.getIndex());
    			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		break;
    	}

    	return cs;
    }


    /*
     * 타입   		0      1      2
	 * 		  String, num, decimal
 	 * 정렬 		0      1       2
	 * 		   left, center, right
  	 * 색생  		0     1 2 3 4    5     6      7    8     9
	 * 		  white, grey25~80, tan, yellow, red, pink, blue
 	 * 굵기  		0     1
	 * 		  false, true
     */
    private CellStyle[][][][] getStyleTemp(XSSFWorkbook workbook){

    	CellStyle[][][][] dataCs = new CellStyle[3][3][10][2];

        dataCs[0][0][0][0] = setCs(workbook,"String","left","white",false);
		dataCs[0][0][0][1] = setCs(workbook,"String","left","white",true);
		dataCs[0][0][1][0] = setCs(workbook,"String","left","grey25",false);
		dataCs[0][0][1][1] = setCs(workbook,"String","left","grey25",true);
		dataCs[0][0][2][0] = setCs(workbook,"String","left","grey40",false);
		dataCs[0][0][2][1] = setCs(workbook,"String","left","grey40",true);
		dataCs[0][0][3][0] = setCs(workbook,"String","left","grey50",false);
		dataCs[0][0][3][1] = setCs(workbook,"String","left","grey50",true);
		dataCs[0][0][4][0] = setCs(workbook,"String","left","grey80",false);
		dataCs[0][0][4][1] = setCs(workbook,"String","left","grey80",true);
		dataCs[0][0][5][0] = setCs(workbook,"String","left","tan",false);
		dataCs[0][0][5][1] = setCs(workbook,"String","left","tan",true);
		dataCs[0][0][6][0] = setCs(workbook,"String","left","yellow",false);
		dataCs[0][0][6][1] = setCs(workbook,"String","left","yellow",true);
		dataCs[0][0][7][0] = setCs(workbook,"String","left","red",false);
		dataCs[0][0][7][1] = setCs(workbook,"String","left","red",true);
		dataCs[0][0][8][0] = setCs(workbook,"String","left","pink",false);
		dataCs[0][0][8][1] = setCs(workbook,"String","left","pink",true);
		dataCs[0][0][9][0] = setCs(workbook,"String","left","blue",false);
		dataCs[0][0][9][1] = setCs(workbook,"String","left","blue",true);

		dataCs[0][1][0][0] = setCs(workbook,"String","center","white",false);
		dataCs[0][1][0][1] = setCs(workbook,"String","center","white",true);
		dataCs[0][1][1][0] = setCs(workbook,"String","center","grey25",false);
		dataCs[0][1][1][1] = setCs(workbook,"String","center","grey25",true);
		dataCs[0][1][2][0] = setCs(workbook,"String","center","grey40",false);
		dataCs[0][1][2][1] = setCs(workbook,"String","center","grey40",true);
		dataCs[0][1][3][0] = setCs(workbook,"String","center","grey50",false);
		dataCs[0][1][3][1] = setCs(workbook,"String","center","grey50",true);
		dataCs[0][1][4][0] = setCs(workbook,"String","center","grey80",false);
		dataCs[0][1][4][1] = setCs(workbook,"String","center","grey80",true);
		dataCs[0][1][5][0] = setCs(workbook,"String","center","tan",false);
		dataCs[0][1][5][1] = setCs(workbook,"String","center","tan",true);
		dataCs[0][1][6][0] = setCs(workbook,"String","center","yellow",false);
		dataCs[0][1][6][1] = setCs(workbook,"String","center","yellow",true);
		dataCs[0][1][7][0] = setCs(workbook,"String","center","red",false);
		dataCs[0][1][7][1] = setCs(workbook,"String","center","red",true);
		dataCs[0][1][8][0] = setCs(workbook,"String","center","pink",false);
		dataCs[0][1][8][1] = setCs(workbook,"String","center","pink",true);
		dataCs[0][1][9][0] = setCs(workbook,"String","center","blue",false);
		dataCs[0][1][9][1] = setCs(workbook,"String","center","blue",true);

		dataCs[0][2][0][0] = setCs(workbook,"String","right","white",false);
		dataCs[0][2][0][1] = setCs(workbook,"String","right","white",true);
		dataCs[0][2][1][0] = setCs(workbook,"String","right","grey25",false);
		dataCs[0][2][1][1] = setCs(workbook,"String","right","grey25",true);
		dataCs[0][2][2][0] = setCs(workbook,"String","right","grey40",false);
		dataCs[0][2][2][1] = setCs(workbook,"String","right","grey40",true);
		dataCs[0][2][3][0] = setCs(workbook,"String","right","grey50",false);
		dataCs[0][2][3][1] = setCs(workbook,"String","right","grey50",true);
		dataCs[0][2][4][0] = setCs(workbook,"String","right","grey80",false);
		dataCs[0][2][4][1] = setCs(workbook,"String","right","grey80",true);
		dataCs[0][2][5][0] = setCs(workbook,"String","right","tan",false);
		dataCs[0][2][5][1] = setCs(workbook,"String","right","tan",true);
		dataCs[0][2][6][0] = setCs(workbook,"String","right","yellow",false);
		dataCs[0][2][6][1] = setCs(workbook,"String","right","yellow",true);
		dataCs[0][2][7][0] = setCs(workbook,"String","right","red",false);
		dataCs[0][2][7][1] = setCs(workbook,"String","right","red",true);
		dataCs[0][2][8][0] = setCs(workbook,"String","right","pink",false);
		dataCs[0][2][8][1] = setCs(workbook,"String","right","pink",true);
		dataCs[0][2][9][0] = setCs(workbook,"String","right","blue",false);
		dataCs[0][2][9][1] = setCs(workbook,"String","right","blue",true);

		dataCs[1][0][0][0] = setCs(workbook,"num","left","white",false);
		dataCs[1][0][0][1] = setCs(workbook,"num","left","white",true);
		dataCs[1][0][1][0] = setCs(workbook,"num","left","grey25",false);
		dataCs[1][0][1][1] = setCs(workbook,"num","left","grey25",true);
		dataCs[1][0][2][0] = setCs(workbook,"num","left","grey40",false);
		dataCs[1][0][2][1] = setCs(workbook,"num","left","grey40",true);
		dataCs[1][0][3][0] = setCs(workbook,"num","left","grey50",false);
		dataCs[1][0][3][1] = setCs(workbook,"num","left","grey50",true);
		dataCs[1][0][4][0] = setCs(workbook,"num","left","grey80",false);
		dataCs[1][0][4][1] = setCs(workbook,"num","left","grey80",true);
		dataCs[1][0][5][0] = setCs(workbook,"num","left","tan",false);
		dataCs[1][0][5][1] = setCs(workbook,"num","left","tan",true);
		dataCs[1][0][6][0] = setCs(workbook,"num","left","yellow",false);
		dataCs[1][0][6][1] = setCs(workbook,"num","left","yellow",true);
		dataCs[1][0][7][0] = setCs(workbook,"num","left","red",false);
		dataCs[1][0][7][1] = setCs(workbook,"num","left","red",true);
		dataCs[1][0][8][0] = setCs(workbook,"num","left","pink",false);
		dataCs[1][0][8][1] = setCs(workbook,"num","left","pink",true);
		dataCs[1][0][9][0] = setCs(workbook,"num","left","blue",false);
		dataCs[1][0][9][1] = setCs(workbook,"num","left","blue",true);

		dataCs[1][1][0][0] = setCs(workbook,"num","center","white",false);
		dataCs[1][1][0][1] = setCs(workbook,"num","center","white",true);
		dataCs[1][1][1][0] = setCs(workbook,"num","center","grey25",false);
		dataCs[1][1][1][1] = setCs(workbook,"num","center","grey25",true);
		dataCs[1][1][2][0] = setCs(workbook,"num","center","grey40",false);
		dataCs[1][1][2][1] = setCs(workbook,"num","center","grey40",true);
		dataCs[1][1][3][0] = setCs(workbook,"num","center","grey50",false);
		dataCs[1][1][3][1] = setCs(workbook,"num","center","grey50",true);
		dataCs[1][1][4][0] = setCs(workbook,"num","center","grey80",false);
		dataCs[1][1][4][1] = setCs(workbook,"num","center","grey80",true);
		dataCs[1][1][5][0] = setCs(workbook,"num","center","tan",false);
		dataCs[1][1][5][1] = setCs(workbook,"num","center","tan",true);
		dataCs[1][1][6][0] = setCs(workbook,"num","center","yellow",false);
		dataCs[1][1][6][1] = setCs(workbook,"num","center","yellow",true);
		dataCs[1][1][7][0] = setCs(workbook,"num","center","red",false);
		dataCs[1][1][7][1] = setCs(workbook,"num","center","red",true);
		dataCs[1][1][8][0] = setCs(workbook,"num","center","pink",false);
		dataCs[1][1][8][1] = setCs(workbook,"num","center","pink",true);
		dataCs[1][1][9][0] = setCs(workbook,"num","center","blue",false);
		dataCs[1][1][9][1] = setCs(workbook,"num","center","blue",true);

		dataCs[1][2][0][0] = setCs(workbook,"num","right","white",false);
		dataCs[1][2][0][1] = setCs(workbook,"num","right","white",true);
		dataCs[1][2][1][0] = setCs(workbook,"num","right","grey25",false);
		dataCs[1][2][1][1] = setCs(workbook,"num","right","grey25",true);
		dataCs[1][2][2][0] = setCs(workbook,"num","right","grey40",false);
		dataCs[1][2][2][1] = setCs(workbook,"num","right","grey40",true);
		dataCs[1][2][3][0] = setCs(workbook,"num","right","grey50",false);
		dataCs[1][2][3][1] = setCs(workbook,"num","right","grey50",true);
		dataCs[1][2][4][0] = setCs(workbook,"num","right","grey80",false);
		dataCs[1][2][4][1] = setCs(workbook,"num","right","grey80",true);
		dataCs[1][2][5][0] = setCs(workbook,"num","right","tan",false);
		dataCs[1][2][5][1] = setCs(workbook,"num","right","tan",true);
		dataCs[1][2][6][0] = setCs(workbook,"num","right","yellow",false);
		dataCs[1][2][6][1] = setCs(workbook,"num","right","yellow",true);
		dataCs[1][2][7][0] = setCs(workbook,"num","right","red",false);
		dataCs[1][2][7][1] = setCs(workbook,"num","right","red",true);
		dataCs[1][2][8][0] = setCs(workbook,"num","right","pink",false);
		dataCs[1][2][8][1] = setCs(workbook,"num","right","pink",true);
		dataCs[1][2][9][0] = setCs(workbook,"num","right","blue",false);
		dataCs[1][2][9][1] = setCs(workbook,"num","right","blue",true);

		dataCs[2][0][0][0] = setCs(workbook,"decimal","left","white",false);
		dataCs[2][0][0][1] = setCs(workbook,"decimal","left","white",true);
		dataCs[2][0][1][0] = setCs(workbook,"decimal","left","grey25",false);
		dataCs[2][0][1][1] = setCs(workbook,"decimal","left","grey25",true);
		dataCs[2][0][2][0] = setCs(workbook,"decimal","left","grey40",false);
		dataCs[2][0][2][1] = setCs(workbook,"decimal","left","grey40",true);
		dataCs[2][0][3][0] = setCs(workbook,"decimal","left","grey50",false);
		dataCs[2][0][3][1] = setCs(workbook,"decimal","left","grey50",true);
		dataCs[2][0][4][0] = setCs(workbook,"decimal","left","grey80",false);
		dataCs[2][0][4][1] = setCs(workbook,"decimal","left","grey80",true);
		dataCs[2][0][5][0] = setCs(workbook,"decimal","left","tan",false);
		dataCs[2][0][5][1] = setCs(workbook,"decimal","left","tan",true);
		dataCs[2][0][6][0] = setCs(workbook,"decimal","left","yellow",false);
		dataCs[2][0][6][1] = setCs(workbook,"decimal","left","yellow",true);
		dataCs[2][0][7][0] = setCs(workbook,"decimal","left","red",false);
		dataCs[2][0][7][1] = setCs(workbook,"decimal","left","red",true);
		dataCs[2][0][8][0] = setCs(workbook,"decimal","left","pink",false);
		dataCs[2][0][8][1] = setCs(workbook,"decimal","left","pink",true);
		dataCs[2][0][9][0] = setCs(workbook,"decimal","left","blue",false);
		dataCs[2][0][9][1] = setCs(workbook,"decimal","left","blue",true);

		dataCs[2][1][0][0] = setCs(workbook,"decimal","center","white",false);
		dataCs[2][1][0][1] = setCs(workbook,"decimal","center","white",true);
		dataCs[2][1][1][0] = setCs(workbook,"decimal","center","grey25",false);
		dataCs[2][1][1][1] = setCs(workbook,"decimal","center","grey25",true);
		dataCs[2][1][2][0] = setCs(workbook,"decimal","center","grey40",false);
		dataCs[2][1][2][1] = setCs(workbook,"decimal","center","grey40",true);
		dataCs[2][1][3][0] = setCs(workbook,"decimal","center","grey50",false);
		dataCs[2][1][3][1] = setCs(workbook,"decimal","center","grey50",true);
		dataCs[2][1][4][0] = setCs(workbook,"decimal","center","grey80",false);
		dataCs[2][1][4][1] = setCs(workbook,"decimal","center","grey80",true);
		dataCs[2][1][5][0] = setCs(workbook,"decimal","center","tan",false);
		dataCs[2][1][5][1] = setCs(workbook,"decimal","center","tan",true);
		dataCs[2][1][6][0] = setCs(workbook,"decimal","center","yellow",false);
		dataCs[2][1][6][1] = setCs(workbook,"decimal","center","yellow",true);
		dataCs[2][1][7][0] = setCs(workbook,"decimal","center","red",false);
		dataCs[2][1][7][1] = setCs(workbook,"decimal","center","red",true);
		dataCs[2][1][8][0] = setCs(workbook,"decimal","center","pink",false);
		dataCs[2][1][8][1] = setCs(workbook,"decimal","center","pink",true);
		dataCs[2][1][9][0] = setCs(workbook,"decimal","center","blue",false);
		dataCs[2][1][9][1] = setCs(workbook,"decimal","center","blue",true);

		dataCs[2][2][0][0] = setCs(workbook,"decimal","right","white",false);
		dataCs[2][2][0][1] = setCs(workbook,"decimal","right","white",true);
		dataCs[2][2][1][0] = setCs(workbook,"decimal","right","grey25",false);
		dataCs[2][2][1][1] = setCs(workbook,"decimal","right","grey25",true);
		dataCs[2][2][2][0] = setCs(workbook,"decimal","right","grey40",false);
		dataCs[2][2][2][1] = setCs(workbook,"decimal","right","grey40",true);
		dataCs[2][2][3][0] = setCs(workbook,"decimal","right","grey50",false);
		dataCs[2][2][3][1] = setCs(workbook,"decimal","right","grey50",true);
		dataCs[2][2][4][0] = setCs(workbook,"decimal","right","grey80",false);
		dataCs[2][2][4][1] = setCs(workbook,"decimal","right","grey80",true);
		dataCs[2][2][5][0] = setCs(workbook,"decimal","right","tan",false);
		dataCs[2][2][5][1] = setCs(workbook,"decimal","right","tan",true);
		dataCs[2][2][6][0] = setCs(workbook,"decimal","right","yellow",false);
		dataCs[2][2][6][1] = setCs(workbook,"decimal","right","yellow",true);
		dataCs[2][2][7][0] = setCs(workbook,"decimal","right","red",false);
		dataCs[2][2][7][1] = setCs(workbook,"decimal","right","red",true);
		dataCs[2][2][8][0] = setCs(workbook,"decimal","right","pink",false);
		dataCs[2][2][8][1] = setCs(workbook,"decimal","right","pink",true);
		dataCs[2][2][9][0] = setCs(workbook,"decimal","right","blue",false);
		dataCs[2][2][9][1] = setCs(workbook,"decimal","right","blue",true);

		return dataCs;
    }

}

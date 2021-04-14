/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ExcelDownloadHandler.java
 * @brief 
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2019. 12. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.enfra.core.service
 * @brief 
 */
package com.encocns.enfra.core.service.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @brief 
 * 간략 설명을 작성한다.
 * @details 
 * <pre>
 * 상세 설명을 작성한다.
 * </pre>
 * @author : 홍길동
 * @date : 2019. 12. 26.
 * @version : 1.0.0
 */
public class ExcelDownloadHandler implements ControllerHandler {
    
    private String fileName;
    private String reportName; //required!
    private ArrayList<Map<String, Object>> sheetList;
    
    public ExcelDownloadHandler(){
        sheetList = new ArrayList<Map<String, Object>>();
    }
    
    public void init() {
        this.fileName = null;
        this.reportName =null; //required!
        this.sheetList.clear();         
    }

    public void addData( int headerRow, List<?> data ){
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("headerRow", headerRow);
        map.put("data", data);
        
        sheetList.add(  map );
    }
    
    public void addData( int headerRow, String sheetName, List<?> data ) {
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("headerRow", headerRow);
        map.put("sheetName", sheetName);
        map.put("data", data);
        
        sheetList.add( map );
        
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public ArrayList<Map<String, Object>> getSheetList() {
        return sheetList;
    }

    public String getFileName() {
        return fileName;
    }

}

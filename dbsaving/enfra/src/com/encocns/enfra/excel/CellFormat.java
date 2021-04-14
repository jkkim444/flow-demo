/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CellFormat.java
 * @brief 
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2019. 12. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.enfra.excel
 * @brief 
 */
package com.encocns.enfra.excel;

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
public abstract class CellFormat {

    public static final short FORMAT_0 = 0; //General
    public static final short FORMAT_1 = 1; //0
    public static final short FORMAT_2 = 2; //0.00
    public static final short FORMAT_3 = 3; //#,##0
    public static final short FORMAT_4 = 4; //#,##0.00
    public static final short FORMAT_5 = 5; //$#,##0_);($#,##0)
    public static final short FORMAT_6 = 6; //$#,##0_);[Red]($#,##0)
    public static final short FORMAT_7 = 7; //$#,##0.00);($#,##0.00)
    public static final short FORMAT_8 = 8; //$#,##0.00_);[Red]($#,##0.00)
    public static final short FORMAT_9 = 9; //0%
    public static final short FORMAT_0xa = 0xa; //0.00%
    public static final short FORMAT_0xb = 0xb; //0.00E+00
    public static final short FORMAT_0xc = 0xc; //# ?/?
    public static final short FORMAT_0xd = 0xd; //# ??/??
    public static final short FORMAT_0xe = 0xe; //m/d/yy
    public static final short FORMAT_0xf = 0xf; //d-mmm-yy
    public static final short FORMAT_0x10 = 0x10; //d-mmm
    public static final short FORMAT_0x11 = 0x11; //mmm-yy
    public static final short FORMAT_0x12 = 0x12; //h:mm AM/PM
    public static final short FORMAT_0x13 = 0x13; //h:mm:ss AM/PM
    public static final short FORMAT_0x14 = 0x14; //h:mm
    public static final short FORMAT_0x15 = 0x15; //h:mm:ss
    public static final short FORMAT_0x16 = 0x16; //m/d/yy h:mm
    public static final short FORMAT_0x26 = 0x26; //#,##0_);[Red](#,##0)
    public static final short FORMAT_0x27 = 0x27; //#,##0.00_);(#,##0.00)
    public static final short FORMAT_0x28 = 0x28; //#,##0.00_);[Red](#,##0.00)
    public static final short FORMAT_0x29 = 0x29; //_(* #,##0_);_(* (#,##0);_(* \-\"_);_(@_)"
    public static final short FORMAT_0x2a = 0x2a; //_($* #,##0_);_($* (#,##0);_($* \-\"_);_(@_)"
    public static final short FORMAT_0x2b = 0x2b; //_(* #,##0.00_);_(* (#,##0.00);_(* \-\"??_);_(@_)"
    public static final short FORMAT_0x2c = 0x2c; //_($* #,##0.00_);_($* (#,##0.00);_($* \-\"??_);_(@_)"
    public static final short FORMAT_0x2d = 0x2d; //mm:ss
    public static final short FORMAT_0x2e = 0x2e; //[h]:mm:ss
    public static final short FORMAT_0x2f = 0x2f; //mm:ss.0
    public static final short FORMAT_0x30 = 0x30; //##0.0E+0
    public static final short FORMAT_0x31 = 0x31; //@ - This is text format.
    
    public static boolean isNumber( short format ) {
        
        if( CellFormat.FORMAT_1==format
        || CellFormat.FORMAT_2==format
        || CellFormat.FORMAT_3==format
        || CellFormat.FORMAT_4==format
        || CellFormat.FORMAT_5==format
        || CellFormat.FORMAT_6==format
        || CellFormat.FORMAT_7==format
        || CellFormat.FORMAT_8==format
        || CellFormat.FORMAT_9==format
        || CellFormat.FORMAT_0xa==format
        || CellFormat.FORMAT_0xb==format
        || CellFormat.FORMAT_0xc==format
        || CellFormat.FORMAT_0xd==format
        || CellFormat.FORMAT_0x26==format
        || CellFormat.FORMAT_0x27==format
        || CellFormat.FORMAT_0x28==format
        || CellFormat.FORMAT_0x29==format
        || CellFormat.FORMAT_0x2a==format
        || CellFormat.FORMAT_0x2b==format
        || CellFormat.FORMAT_0x2c==format
        || CellFormat.FORMAT_0x30==format )
            return true;
        
        return false;
    }
    
    public static void main(String[] args) {
        short a = 164;
        
        System.out.println(CellFormat.isNumber(a));
                
                
    }
}

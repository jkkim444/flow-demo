/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO201003IN.java
 * @brief 메뉴 관리 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 메뉴 관리 IN
 * @details 메뉴 관리 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO201003IN {

	private String bizLclsCd;                        /* 업무구분코드 */
	private String menuId;                           /* 메뉴ID */

    public String getBizLclsCd() {
        return bizLclsCd;
    }
    public void setBizLclsCd(String bizLclsCd) {
        this.bizLclsCd = bizLclsCd;
    }
    public String getMenuId() {
        return menuId;
    }
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}

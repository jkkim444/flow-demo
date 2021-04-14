/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO401003OUT.java
 * @brief 공지사항 삭제 OUT
 * @section Major History
 * <pre>
 *   - 최호연 | 2020. 10. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.ArrayList;

import com.encocns.enfra.core.component.vo.FileVO;

/**
 * @brief 공지사항 삭제 OUT
 * @details 공지사항 삭제 OUT
 * @author : 최호연
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class CO401003OUT {

	private ArrayList<FileVO> fileList;
	private int iResult;

	public int getiResult() {
		return iResult;
	}

	public void setiResult(int iResult) {
		this.iResult = iResult;
	}

	public ArrayList<FileVO> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<FileVO> fileList) {
		this.fileList = fileList;
	}


}

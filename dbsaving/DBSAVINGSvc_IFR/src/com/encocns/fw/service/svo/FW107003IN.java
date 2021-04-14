package com.encocns.fw.service.svo;

import java.util.ArrayList;

import com.encocns.fw.dto.FW107001DTO;

public class FW107003IN {

	private String grpId;                            /* 그룹ID */
	private ArrayList<FW107001DTO> arrList;          /* 배치조회 */

	public String getGrpId() {
		return grpId;
	}

	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	public ArrayList<FW107001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<FW107001DTO> arrList) {
		this.arrList = arrList;
	}


}

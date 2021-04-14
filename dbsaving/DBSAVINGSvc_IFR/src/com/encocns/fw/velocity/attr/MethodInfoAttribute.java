/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file MethodAttribute.java
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - HONG, GIL-DONG | 2019. 9. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.velocity.attr
 * @brief 
 */
package com.encocns.fw.velocity.attr;

import java.util.ArrayList;

/**
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @details 
 * <pre>
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * </pre>
 * @author : HONG, GIL-DONG
 * @date : 2019. 9. 26.
 * @version : 1.0.0
 */
public class MethodInfoAttribute {
    
    private String name;
    private String desc;
    private ClassInfoAttribute inSvo;
    private ClassInfoAttribute outSvo;
    private ClassInfoAttribute dto;
    private ArrayList<VariableInfoAttribute> inSvoVar;
    private ArrayList<VariableInfoAttribute> outSvoVar;
    private ArrayList<VariableInfoAttribute> dtoVar;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public ClassInfoAttribute getInSvo() {
        return inSvo;
    }
    public void setInSvo(ClassInfoAttribute inSvo) {
        this.inSvo = inSvo;
    }
    public ClassInfoAttribute getOutSvo() {
        return outSvo;
    }
    public void setOutSvo(ClassInfoAttribute outSvo) {
        this.outSvo = outSvo;
    }
    public ClassInfoAttribute getDto() {
        return dto;
    }
    public void setDto(ClassInfoAttribute dto) {
        this.dto = dto;
    }
	public ArrayList<VariableInfoAttribute> getInSvoVar() {
		return inSvoVar;
	}
	public void setInSvoVar(ArrayList<VariableInfoAttribute> inSvoVar) {
		this.inSvoVar = inSvoVar;
	}
	public ArrayList<VariableInfoAttribute> getOutSvoVar() {
		return outSvoVar;
	}
	public void setOutSvoVar(ArrayList<VariableInfoAttribute> outSvoVar) {
		this.outSvoVar = outSvoVar;
	}
	public ArrayList<VariableInfoAttribute> getDtoVar() {
		return dtoVar;
	}
	public void setDtoVar(ArrayList<VariableInfoAttribute> dtoVar) {
		this.dtoVar = dtoVar;
	}
    
    
}

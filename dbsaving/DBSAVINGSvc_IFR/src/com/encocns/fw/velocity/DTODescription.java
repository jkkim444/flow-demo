package com.encocns.fw.velocity;

import java.util.ArrayList;

import com.encocns.fw.velocity.attr.FileInfoAttribute;
import com.encocns.fw.velocity.attr.VariableInfoAttribute;

public class DTODescription extends FileInfoAttribute {

    private ArrayList<VariableInfoAttribute> varList;

    public ArrayList<VariableInfoAttribute> getVarList() {
        return varList;
    }

    public void setVarList(ArrayList<VariableInfoAttribute> varList) {
        this.varList = varList;
    }
    
    
    
}

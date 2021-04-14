package com.encocns.fw.velocity;

import java.util.ArrayList;

import com.encocns.fw.velocity.attr.FileInfoAttribute;
import com.encocns.fw.velocity.attr.MethodInfoAttribute;

public class JavaScriptDescription extends FileInfoAttribute {

    private ArrayList<MethodInfoAttribute> methodList;

    public ArrayList<MethodInfoAttribute> getMethodList() {
        return methodList;
    }

    public void setMethodList(ArrayList<MethodInfoAttribute> methodList) {
        this.methodList = methodList;
    }
    
    
    
}

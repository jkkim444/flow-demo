package com.encocns.fw.velocity;

import java.util.ArrayList;

import com.encocns.fw.velocity.attr.FileInfoAttribute;
import com.encocns.fw.velocity.attr.MethodInfoAttribute;

public class DAODescription extends FileInfoAttribute {
    
    private String namespace;
    private ArrayList<MethodInfoAttribute> methodList;

    
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public ArrayList<MethodInfoAttribute> getMethodList() {
        return methodList;
    }

    public void setMethodList(ArrayList<MethodInfoAttribute> methodList) {
        this.methodList = methodList;
    }
    
}

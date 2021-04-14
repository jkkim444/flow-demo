package com.encocns.fw.velocity;

import java.util.ArrayList;

import com.encocns.fw.velocity.attr.ClassInfoAttribute;
import com.encocns.fw.velocity.attr.FileInfoAttribute;
import com.encocns.fw.velocity.attr.MethodInfoAttribute;

public class ServiceDescription extends FileInfoAttribute {

    
    private ClassInfoAttribute dao;
    private ArrayList<MethodInfoAttribute> methodList;

    
    public ClassInfoAttribute getDao() {
        return dao;
    }

    public void setDao(ClassInfoAttribute dao) {
        this.dao = dao;
    }

    public ArrayList<MethodInfoAttribute> getMethodList() {
        return methodList;
    }

    public void setMethodList(ArrayList<MethodInfoAttribute> methodList) {
        this.methodList = methodList;
    }
    
}

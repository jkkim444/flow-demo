package com.encocns.fw.velocity;

import java.util.ArrayList;

import com.encocns.fw.velocity.attr.FileInfoAttribute;
import com.encocns.fw.velocity.attr.QueryInfoAttribute;

public class MapperDescription extends FileInfoAttribute {

    
    ArrayList<QueryInfoAttribute> queryList;

    public ArrayList<QueryInfoAttribute> getQueryList() {
        return queryList;
    }

    public void setQueryList(ArrayList<QueryInfoAttribute> queryList) {
        this.queryList = queryList;
    }
    
    
    
    
}

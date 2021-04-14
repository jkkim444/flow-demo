package com.encocns.fw.velocity;

import com.encocns.fw.velocity.attr.FileInfoAttribute;

public class JspDescription extends FileInfoAttribute {
    
    private String splitYn;

    public String getSplitYn() {
        return splitYn;
    }

    public void setSplitYn(String splitYn) {
        this.splitYn = splitYn;
    }
}

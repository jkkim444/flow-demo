package com.encocns.enfra.validator.rule;

public class FixedLengthRule implements Rule {
    
    // 문자열 길이
    private int len;

    public FixedLengthRule(int len) {
        super();
        this.len = len;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target == null) {
            return false;
        }

        int length = (String.valueOf(target)).length();
        
        if(length != len) {
            return false;
        }
        return true;
    }
}

package com.encocns.enfra.validator.rule;

public class MaxLengthRule implements Rule {
    
    // 체크할 최대 길이
    private int maxlength = Integer.MAX_VALUE;

    public MaxLengthRule(int maxlength) {
        this.maxlength = maxlength;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target == null) {
            return false;
        }

        int length = (String.valueOf(target)).length();
//        int length = (int) target.getClass().getMethod("length").invoke(target);
        
        if(length > maxlength) {
            return false;
        }
        
        return true;
    }
}

package com.encocns.enfra.validator.rule;

public class MinLengthRule implements Rule {

    // 체크할 문자열 최소 길이
    private int minlength = Integer.MIN_VALUE;

    public MinLengthRule(int minlength) {
        this.minlength = minlength;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target == null) {
            return false;
        }

        int length = (String.valueOf(target)).length();
//        int length = (int) target.getClass().getMethod("length").invoke(target);
        
        if(length < minlength) {
            return false;
        }
        
        return true;
    }
    
}

package com.encocns.enfra.validator.rule;

public class MinRule implements Rule {

    // 체크할 최소값
    private int min = Integer.MIN_VALUE;

    public MinRule(int min) {
        this.min = min;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target != null && (int)target < min) {
            return false;
        }
        
        return true;
    }

}

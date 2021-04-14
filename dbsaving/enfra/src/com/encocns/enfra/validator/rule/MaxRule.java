package com.encocns.enfra.validator.rule;

public class MaxRule implements Rule {

    // 체크할 최대값
    private int max = Integer.MAX_VALUE;

    public MaxRule(int max) {
        this.max = max;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target != null && (int)target > max) {
            return false;
        }
        return true;
    }

}

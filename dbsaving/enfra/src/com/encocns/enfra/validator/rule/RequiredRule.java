package com.encocns.enfra.validator.rule;

import org.apache.commons.lang.StringUtils;

public class RequiredRule implements Rule {

    /// 필수값 체크 여부(체크 : true, 체크안함 : false)
    boolean required = true;

    public RequiredRule() {
        super();
    }

    public RequiredRule(boolean required) {
        this.required = required;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target == null) {
            return false;
        }

        if(required && StringUtils.isEmpty(String.valueOf(target))) {
            return false;
        }

        return true;
    }

}

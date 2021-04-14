
package com.encocns.enfra.validator.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternRule implements Rule {
    
    // 체크할 정규 표현식
    private String regex;

    public PatternRule(String regex) {
        super();
        this.regex = regex;
    }

    @Override
    public boolean checkRule(Object target) throws Exception {
        if(target == null) {
            return false;
        }

        String value = String.valueOf(target);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
    
}

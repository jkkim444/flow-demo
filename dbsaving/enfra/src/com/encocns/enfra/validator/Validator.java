package com.encocns.enfra.validator;

import com.encocns.enfra.validator.ruleset.RuleSet;

public class Validator {
 
    public static void validation(Object param, RuleSet ruleSet) {
        ruleSet.checkRules(param);
    }
    
}
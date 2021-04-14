package com.encocns.enfra.validator.ruleset;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.encocns.enfra.exception.EnfraValidationException;
import com.encocns.enfra.validator.rule.Rule;

public class RuleSet {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RuleSet.class);
    
    private Map<String, Rule[]> ruleSet = new LinkedHashMap<String, Rule[]>();
    
    public void addRule(String keyName, Rule...rule) {
        ruleSet.put(keyName, rule);
    }
    
    public void checkRules(Object param) {
        Iterator<String> ruleSetKeys = ruleSet.keySet().iterator();
        String ruleSetKey;
        Rule[] rules;
        Rule rule;
        Object paramValue = null;
        
        Class<? extends Object> paramClass = param.getClass();
        Method[] paramMethods = paramClass.getDeclaredMethods();

        while(ruleSetKeys.hasNext()) {
            ruleSetKey = ruleSetKeys.next();
            rules = ruleSet.get(ruleSetKey);

            for(Method paramMethod : paramMethods) {
                if(paramMethod.getName().toUpperCase().equals(("GET" + ruleSetKey).toUpperCase())) {
                    try {
                        paramValue = paramClass.getMethod(paramMethod.getName()).invoke(param);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                            | NoSuchMethodException | SecurityException e) {
                        throw new EnfraValidationException("CE0004", e.getMessage());
                    }
                    break;
                }
            }
            
            // ruleKey 기준으로 paramter 를 check
            if(LOGGER.isInfoEnabled()) LOGGER.info("key : {}, paramValue : {}", ruleSetKey, paramValue);
            
            if(paramValue == null) {
                throw new EnfraValidationException("CE0004", ruleSetKey + " is null!");
            }
            
            if(rules != null && rules.length > 0) {
                for(int i=0; i<rules.length; i++) {
                    rule = rules[i];

                    if(LOGGER.isInfoEnabled()) LOGGER.info("rule : {}", rule.getClass().getSimpleName());

                    // validation check
                    try {
                        if(paramValue.getClass().isArray()) { // array
                            for(int j=0; j<Array.getLength(paramValue); j++) {
                                if(LOGGER.isInfoEnabled()) LOGGER.info(Array.get(paramValue, j).toString());
                                Object obj = Array.get(paramValue, j);

                                if(!rule.checkRule(obj)) {
                                    if(LOGGER.isInfoEnabled()) LOGGER.info("{} validation error!! ==> key : {}[{}] value : {}"
                                            , rule.getClass().getSimpleName(), ruleSetKey, j, obj);
                                    throw new EnfraValidationException("CE0004", rule.getClass().getSimpleName() + " error!");
                                }
                            }
                        } else { // obj
                            if(!rule.checkRule(paramValue)) {
                                if(LOGGER.isInfoEnabled()) LOGGER.info("{} validation error!! ==> key : {} value : {}"
                                        , rule.getClass().getSimpleName(), ruleSetKey, paramValue);
                                throw new EnfraValidationException("CE0004", rule.getClass().getSimpleName() + " error!");
                            }
                        }
                    } catch (Exception e) {
                        throw new EnfraValidationException("CE0004", e.getMessage());
                    }
                }
            }
        } // end of while(ruleSetKeys.hasNext())
    }

}

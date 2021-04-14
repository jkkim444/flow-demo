/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file JsonUtil.java
 * @brief 
 */
/**
 * @namespace com.encocns.enfra.core.util
 * @brief 
 */
package com.encocns.enfra.core.component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.encocns.enfra.core.annotation.Masking;

/**
 * @brief 
 * @details 
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 26.
 * @version : 1.0.0
 */
@Component
public class MaskingComponent {
    
    @Value("#{globalContext}")
    protected Properties globalContextProp;
    
    public Map<String, String> getMaskingList() {
        String[] maskingList = null;
        Map<String, String> mapMasking = new HashMap<String, String>();
        
        if(globalContextProp.getProperty("MASKING_LIST") != null) {
            maskingList = globalContextProp.getProperty("MASKING_LIST").split(",");
            
            String[] arrMasking = null;
            for(String masking : maskingList) {
                arrMasking = masking.split("[|]");
                mapMasking.put(arrMasking[0], arrMasking[1]);
            }
        }
        
        return mapMasking;
    }
    
    public Map<String, String> getDtoMaskingMap(Object getObject, Field oField) {
        
        Map<String, String> maskPolicy = getMaskingList();
        
        Map<String, String> map = new HashMap<String, String>();
        
        if(oField.getGenericType() instanceof ParameterizedType) {
            ParameterizedType osvoParamterGenericType = (ParameterizedType)oField.getGenericType();
            
            Class<?> genericClazz = null;
            
            if( osvoParamterGenericType.getActualTypeArguments()[0] instanceof Class<?>) {
                genericClazz = (Class<?>)osvoParamterGenericType.getActualTypeArguments()[0];
                
                Field[] genericClazzFields = genericClazz.getDeclaredFields();
                
                for(Field genericClazzField : genericClazzFields) {
                    if(genericClazzField.getAnnotation(Masking.class) != null && maskPolicy.containsKey(genericClazzField.getAnnotation(Masking.class).policy())) {
                        map.put(genericClazzField.getName(), maskPolicy.get(genericClazzField.getAnnotation(Masking.class).policy()));
                    } 
                }
            }
        } else {
            if(oField.getType().toString().startsWith("class")) {
                Field[] dtoFields = getObject.getClass().getDeclaredFields();
                
                for(Field dtoField : dtoFields) {
                    if(dtoField.getAnnotation(Masking.class) != null && maskPolicy.containsKey(dtoField.getAnnotation(Masking.class).policy())) {
                        map.put(dtoField.getName(), maskPolicy.get(dtoField.getAnnotation(Masking.class).policy()));
                    } 
                }
            }
        }
        
        return map;
    }
    
    public void setDtoMaskingProcessing(Field[] dtoFields, Map<String, String> mapDtoMask, Object getObject) {
        Method getterDtoMethod = null;
        
        Field dtoField = null;
        try {
            for(int j=0; j<dtoFields.length; j++) {
                dtoField = dtoFields[j];
              
                if( dtoField.getName().length() > 2 && mapDtoMask.containsKey(dtoField.getName()) ) {
                    getterDtoMethod = getObject.getClass().getMethod("get"+StringUtils.capitalize(dtoField.getName()));
                    Object resultGetInvoke = getterDtoMethod.invoke(getObject);
                    
                    if(resultGetInvoke != null) {
                        Object objMaskingResult = setMaskingProcessing(resultGetInvoke, mapDtoMask.get(dtoField.getName()));
                        BeanUtils.setProperty(getObject, dtoField.getName(), objMaskingResult);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public Object setMaskingProcessing(Object maskTarget, String maskPolicy) {
        Object result = "";
        String maskTargetTrim = "";
        String[] policySplit = maskPolicy.split(" ");
        String regExp = "^";
        
        for( String strTemp : policySplit ) {
            
            String word = "";
            String digit = "";
            
            if( strTemp.startsWith("W") ) {
                word = ".";
                digit = strTemp.substring(1);
                if( "*".equals(digit) ) 
                    regExp += "(" + word + digit + ")";
                else 
                    regExp += "(" + word + "{" + digit + "})";
            }
            else if( strTemp.startsWith("M") ) {
                word = ".";
                digit = strTemp.substring(1);                
                if( "*".equals(digit) ) 
                    regExp += "(" + word + digit + ")";
                else 
                    regExp += "(" + word + "{" + digit + "}" + ")";
            }
            else 
                continue;
        }
        
        regExp += "$";
        
        if(maskTarget instanceof String){
            maskTargetTrim = ((String)maskTarget).replaceAll("\\s", "");
        }
        
        try {
            int cnt = 1;
            while( !"".equals(maskTargetTrim.replaceAll(regExp, "$"+cnt )) ) {
                if( policySplit[cnt-1].startsWith("M") ) 
                    result += maskTargetTrim.replaceAll(regExp, "$"+cnt ).replaceAll(".", "*");
                else 
                    result += maskTargetTrim.replaceAll(regExp, "$"+cnt );
                
                cnt++;
            }
        } catch( Exception e ) {
//            e.printStackTrace();
        }
        
        return result;
    }
    
}

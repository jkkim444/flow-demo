package com.encocns.enfra.core.vo;

import java.util.Iterator;
import java.util.Set;

import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.reflection.MethodReflection;
import com.google.gson.JsonObject;

/**
 * @author rouz
 * JSON -> VO 변환클래스
 */
public class ConvertJSONtoVO {
    
    private String stringJson;
    private String voClassName;
    private Object VO;
    
    public ConvertJSONtoVO(String voClassName, String stringJson) throws Exception {
        this.setVoClassName(voClassName);
        this.setStringJson(stringJson);
        converJSONtoVO();
    }
    
    public void converJSONtoVO() throws Exception {
        converJSONtoVO( this.stringJson );
    }
    
    public void converJSONtoVO(String stringJson) throws Exception {
    	
        Class<?> voClass = null;
        Object voObject = null;
        MethodReflection mtf = null;
        
        try {
            voClass = Class.forName( voClassName );
            voObject = voClass.newInstance();
            mtf = new MethodReflection( voObject );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
//        JSONObject json = JSONObject.fromObject(stringJson);
        JsonObject json = JsonUtil.toJsonObject(stringJson);
        
        Set set = json.keySet();
        Iterator<String> ita = set.iterator();
        
        while (ita.hasNext()) {
            String column = ita.next();
            Object value = json.get(column);
            mtf.setterMethod( column , value );
        }//while
        
        this.setVO( voObject );
    }
    

    public String getStringJson() {
        return this.stringJson;
    }
    
    public void setStringJson(String stringJson) {
        this.stringJson = stringJson;
    }

    public String getVoClassName() {
        return voClassName;
    }

    public void setVoClassName(String voClassName) {
        this.voClassName = voClassName;
    }

    public void setVO(Object vO) {
        this.VO = vO;
    }
    
    public Object getVO() {
        return this.VO;
    }
}

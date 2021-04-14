package com.encocns.enfra.core.component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.exception.EnfraCoreException;
import com.encocns.enfra.reflection.MethodReflection;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component("serviceVOConverter")
public class ServiceVOConverter {

    @Autowired
    private VOConverter voConverter;

    @Autowired
    private MaskingComponent maskingComponent;
    
    @Value("#{globalContext}")
    protected Properties globalContextProp;
    
    private JsonObject param;

    public Object createISVO( Object isvoObj) throws EnfraCoreException
    {
        voConverter = new VOConverter();
        
        Object svo = null;

        try
        {
            svo = isvoObj.getClass().newInstance();

            MethodReflection mtf = new MethodReflection( svo );

            for(Field field : isvoObj.getClass().getDeclaredFields())
            {
                //array field
                if( List.class.equals(field.getType()) || ArrayList.class.equals(field.getType()) )
                {
                    ParameterizedType voParams = (ParameterizedType)field.getGenericType();

                    Class<?> genericClazz = null;
                    Object instanceGenericClazz = null;
                    
                    if( voParams.getActualTypeArguments()[0] instanceof Class<?>) {
                    } else if( voParams.getActualTypeArguments()[0].toString().indexOf("Map")>0) {
                    } else if( voParams.getActualTypeArguments()[0] instanceof HashMap ) {
                    } else {
                        continue;
                    }

                    JsonArray _array = (JsonArray)param.get(field.getName());
                    
                    if(_array==null || _array.isJsonNull() || !_array.isJsonArray())
                    {
                        continue;
                    }
                    
                    ArrayList<Object> templist = new ArrayList<Object>();
                    
                    for( JsonElement el  : _array ) 
                    {
                      Type gernericType = voParams.getActualTypeArguments()[0];
                        
                      if( gernericType instanceof Class<?>) {
                          
                          Object value = null;
                          
                          if (gernericType.equals(String.class)){
                              value = el.getAsString();
                          }
                          else if (gernericType.equals(Boolean.class)){
                              value = el.getAsBoolean();
                          }
                          else if (gernericType.equals(Byte.class)){
                              value = el.getAsByte();
                          }
                          else if (gernericType.equals(Short.class)){
                              value = el.getAsShort();
                          }
                          else if (gernericType.equals(Integer.class)){
                              if("".equals(el.getAsString())) {
                                  value = 0;
                              }else {
                                  value = el.getAsInt();
                              }
                          }
                          else if (gernericType.equals(Long.class)) {
                              if("".equals(el.getAsString().trim())) {
                                  value = 0;
                              }else {
                                  value = el.getAsLong();
                              }
                          }
                          else if (gernericType.equals(Float.class)) {
                              if("".equals(el.getAsString().trim())) {
                                  value = 0;
                              }else {
                                  value = el.getAsFloat();
                              }
                          }
                          else if (gernericType.equals(Double.class)) {
                              if("".equals(el.getAsString().trim())) {
                                  value = 0;
                              }else {
                                  value = el.getAsDouble();
                              }
                          }
                          else {
                              genericClazz = (Class<?>)voParams.getActualTypeArguments()[0];
                              instanceGenericClazz = genericClazz.newInstance();
                              value = voConverter.fromJsonString(el.getAsJsonObject(), instanceGenericClazz);
                          }
                          
                          templist.add(value);
                          
                      } else if( gernericType.toString().indexOf("Map")>0) {
                          instanceGenericClazz = Class.forName("java.util.HashMap").newInstance();
                          HashMap hs = new HashMap();
                          hs = JsonUtil.gson.fromJson(el.getAsJsonObject(), hs.getClass());
                          templist.add(hs);
                      } 
                    }
                    
                    mtf.setterMethod(field.getName(), templist);
                }
                //single field
                else
                {
                    if(param.has(field.getName())) {
                        if( field.getType().toString().indexOf("BigDecimal")>=0  ) {
                            if( StringUtils.isEmpty(param.get(field.getName()).getAsString()) ){
//                            param.addProperty(field.getName(), "0");
                                continue;
                            }
                        }
                        
                        mtf.setterMethod(field.getName(), param.get(field.getName()));
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new EnfraCoreException("CE0005", e.getMessage());
        }

        return svo;
    }

      public JsonObject createOSVO(Object osvo) throws EnfraCoreException {
        
        JsonObject ojson = new JsonObject();
        
        try
        {
            Class<?> osvoCls = osvo.getClass();
            Field[] oFields = osvoCls.getDeclaredFields();

            String fieldName = null;
            
            for (Field oField : oFields) {
                fieldName = oField.getName();

                Method getterMtd = null;

//                if(fieldName.length() > 2) {

                    if(fieldName.length() > 2 && fieldName.substring(0,  1).matches("[a-z]+") &&
                            fieldName.substring(1,  2).matches("[A-Z]+")
                            ) {
                        if(oField.getType().getName().endsWith("boolean")) {
                            getterMtd = osvoCls.getMethod("is"+fieldName);
                        }
                        else
                        {
                            getterMtd = osvoCls.getMethod("get"+fieldName);
                        }
                    } else {
                        if(oField.getType().getName().endsWith("boolean")) {
                            getterMtd = osvoCls.getMethod(fieldName);
                        }
                        else
                        {
                            getterMtd = osvoCls.getMethod("get"+StringUtils.capitalize(fieldName));
                        }
                    }
//                }

                Object getObject = getterMtd.invoke( osvo );
                
                //그리드 데이터 uid처리
                if (getObject instanceof ArrayList) {
                    
                    Map<String, String> fieldsPolicy = maskingComponent.getDtoMaskingMap(getObject, oField);
                    
                    JsonArray jsonArray = JsonUtil.toJsonArray(getObject); 
                    JsonArray osvoArray = new JsonArray();

                    long i=0;
                    for (Object obj : jsonArray) {
                        JsonObject jsonObj = (JsonObject)obj;
                        jsonObj.addProperty("__resRowIdx", i);
                        
                        if( null != fieldsPolicy ) {
                            if( !fieldsPolicy.isEmpty() ) {
                                Set<Map.Entry<String, JsonElement>> entrySet = jsonObj.entrySet();
                                
                                for( Map.Entry<String, JsonElement> entry : entrySet ) {
                                    if( fieldsPolicy.containsKey(entry.getKey()) ) {
                                        Object maskResultObj = maskingComponent.setMaskingProcessing( entry.getValue().getAsString(), fieldsPolicy.get(entry.getKey()));
                                        jsonObj.addProperty(entry.getKey(), maskResultObj.toString());
                                    }
                                }
                            }
                        }
                        
                        osvoArray.add(jsonObj);
                        i++;
                    }
                    ojson.add( fieldName, osvoArray);
                } else {
                    if(getObject != null && oField.getType().toString().startsWith("class")) {
                        Field[] dtoFields = getObject.getClass().getDeclaredFields();
                        
                        Map<String, String> mapDtoMask = null;
                        
                        if(getObject != null) {
                            mapDtoMask = maskingComponent.getDtoMaskingMap(getObject, oField);
                        }
                        
                        maskingComponent.setDtoMaskingProcessing(dtoFields, mapDtoMask, getObject);
                    }
                    
                    ojson.add(fieldName, JsonUtil.getObject(getObject));
                }
            }
        }
        catch(Exception e)
        {
            throw new EnfraCoreException("CE0005", e.getMessage());
        }

        return ojson;
    }

    public JsonObject getParam() {
        return param;
    }

    public void setParam(JsonObject param) {
        this.param = param;
    }
    
}

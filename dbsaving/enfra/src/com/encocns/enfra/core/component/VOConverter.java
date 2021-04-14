package com.encocns.enfra.core.component;

import java.io.Writer;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.encocns.enfra.core.util.JsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

@Component("voConverter")
public class VOConverter implements Converter {

    private Object voObject;
    private String[] includeColumn;

    public void setVoObject(Object voObject) {
        this.voObject = voObject;
    }

    public void setIncludeColumn(String[] includeColumn) {
        this.includeColumn = includeColumn;
    }

    /**
     * VO를 JSON 문자열로 변환
     *
     * @param clazz
     *            JSON 문자열로 변환할 VO
     * @return 변환된 JSON 문자열
     */
    public String toJsonString(Object clazz) {
        XStream xstream4JSON = new XStream(new JettisonMappedXmlDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });
        xstream4JSON.registerConverter(this);
        return xstream4JSON.toXML(clazz);
    }

    /**
     * JSON 문자열을 VO로 변환
     *
     * @param jsonString
     *            VO로 변환할 JSON 문자열
     * @param clazz
     *            변환될 VO
     * @return 변환된 VO
     */
    public Object fromJsonString(JsonObject jsonObject, Object voObject) throws Exception {
        this.setVoObject(voObject);
        
//        XStream xstream4JSON = new XStream(new JettisonMappedXmlDriver());
//        String convertStr = "{\"" + voObject.getClass().getName() + "\":" + jsonObject.toString().replaceAll("\n", "")
//                + "}";
        
//        xstream4JSON.registerConverter(this);
//        System.out.println(convertStr);
        
        Method[] methodArr = voObject.getClass().getDeclaredMethods();
        
        for (Method mt : methodArr)
        {
            
            if(mt.getName().indexOf("set")!=0  ) continue;
            
            String key = mt.getName().replaceFirst("set", "");
            key = key.substring(0,1).toLowerCase() + key.substring(1);
            
            Class[] paramType = mt.getParameterTypes();
            Object[] argArr = new Object[paramType.length];
            
            if( jsonObject.get(key)==null ) continue;

            JsonElement je = jsonObject.get(key);
            Object param=null;
            
            for (int i = 0, loop = paramType.length; i < loop; i++)
            {
                if (paramType[i].equals(String.class))
                {
                    param = je.getAsString();
                }
                else if (paramType[i].isPrimitive())
                {
                    if (paramType[i].equals(Boolean.TYPE))
                        param = je.getAsBoolean();
                    else if (paramType[i].equals(Byte.TYPE))
                        param = je.getAsByte();
                    else if (paramType[i].equals(Short.TYPE))
                        param = je.getAsShort();
                    else if (paramType[i].equals(Integer.TYPE)) {
                        if("".equals(je.getAsString().trim())) {
                            param = 0;
                        }else {
                            param = je.getAsInt();
                        }
                    }
                    else if (paramType[i].equals(Long.TYPE)) {
                        if("".equals(je.getAsString().trim())) {
                            param = 0;
                        }else {
                            param = je.getAsLong();
                        }
                    }
                    else if (paramType[i].equals(Float.TYPE)) {
                        if("".equals(je.getAsString().trim())) {
                            param = 0;
                        }else {
                            param = je.getAsFloat();
                        }
                    }
                    else if (paramType[i].equals(Double.TYPE)) {
                        if("".equals(je.getAsString().trim())) {
                            param = 0;
                        }else {
                            param = je.getAsDouble();
                        }
                    }
                    else {
                        throw new NoSuchMethodException();
                    }
                }
                else if (paramType[i].equals(BigDecimal.class))
                {
                    try {
                        if(je.isJsonPrimitive()) {
                            if( "".equals(je.getAsString()) ) {
                                param = null;
                            }
                            else {
                                param = new BigDecimal(je.getAsString());
                            }
                        }
                        else {
                            param = je.getAsBigDecimal();
                        }
                    }
                    catch(Exception e) {
                        param = null;
                    }

                }
                else
                {
                    if( paramType[i].getName().indexOf("HashMap")>-1 ) {
                        HashMap hs = new HashMap();
                        hs = JsonUtil.gson.fromJson(je.getAsJsonObject(), hs.getClass());
                        param = hs;
                    }else if( paramType[i].getName().indexOf("Map")>-1 ) {
                        Map hs = new HashMap();
                        hs = JsonUtil.gson.fromJson(je.getAsJsonObject(), hs.getClass());
                        param = hs;
                    }
                }
            }
            
            mt.invoke(voObject, param);
            
        }//for method
        
        return voObject;
    }

    // VO->jSON
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {

        Method[] methodArr = value.getClass().getDeclaredMethods();

        for (Method mt : methodArr) {
            for (String s : includeColumn) {
                if (!mt.getName().toUpperCase().equals("GET" + s.toUpperCase())) {
                    continue;
                }

                writer.startNode(s);

                try {
                    writer.setValue(mt.invoke(value).toString());
                } catch (Exception e) {
                    writer.setValue("");
                    e.printStackTrace();
                }

                writer.endNode();
                break;
            }
        }
    }

    // JSON->VO
    @Deprecated
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context)
    {
        Method[] methodArr = voObject.getClass().getDeclaredMethods();
        
        try
        {
            while (reader.hasMoreChildren())
            {
                reader.moveDown();
                
                if( reader.hasMoreChildren() ) continue;
                
                for (Method mt : methodArr)
                {
                  if (!mt.getName().toUpperCase().equals("SET" + reader.getNodeName().toUpperCase()))
                  {
                      continue;
                  }

                    Class[] paramType = mt.getParameterTypes();
                    Object[] argArr = new Object[paramType.length];
//                    Constructor ct = null;

                    for (int i = 0, loop = paramType.length; i < loop; i++)
                    {
                        if (paramType[i].equals(String.class))
                        {
                            argArr[i] = reader.getValue();
                        }
                        else if (paramType[i].isPrimitive())
                        {
                            if (paramType[i].equals(Boolean.TYPE))
                                argArr[i] = Boolean.parseBoolean(reader.getValue());

                            else if (paramType[i].equals(Byte.TYPE))
                                argArr[i] = Byte.parseByte(reader.getValue());

                            else if (paramType[i].equals(Short.TYPE))
                                argArr[i] = Short.parseShort(reader.getValue());

                            else if (paramType[i].equals(Integer.TYPE))
                                argArr[i] = Integer.parseInt(reader.getValue());

                            else if (paramType[i].equals(Long.TYPE))
                                argArr[i] = Long.parseLong(reader.getValue());

                            else if (paramType[i].equals(Float.TYPE))
                                argArr[i] = Float.parseFloat(reader.getValue());

                            else if (paramType[i].equals(Double.TYPE))
                                argArr[i] = Double.parseDouble(reader.getValue());
                            else {
                                throw new NoSuchMethodException();
                            }
                        }
                        else
                        {
                            if( paramType[i].getName().indexOf("HashMap")>-1 ) {
                                argArr[i] = JsonUtil.gson.fromJson(reader.getValue(), HashMap.class);
                            }else if( paramType[i].getName().indexOf("Map")>-1 ) {
                                argArr[i] = JsonUtil.gson.fromJson(reader.getValue(), Map.class);
                            }
                        }
                    }
                    
                    mt.invoke(voObject, argArr);
                    break;
                    
                }//method

                reader.moveUp();
            
            }//while
            
        } catch (Exception e) {
            e.printStackTrace();
            voObject = null;
        }

        return voObject;
    }

    @Override
    public boolean canConvert(Class paramClass) {
        return true;
    }

    

}

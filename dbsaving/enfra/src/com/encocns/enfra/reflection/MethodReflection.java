package com.encocns.enfra.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.encocns.enfra.core.component.VOConverter;
import com.encocns.enfra.core.util.JsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MethodReflection {

    private Object clsObj;
    private String clsName;
    private Class<?> cls;

    public MethodReflection(Object clsObj) throws Exception {
        this.clsObj = clsObj;
        this.clsName = clsObj.getClass().getName();

        try {
            cls = Class.forName(this.clsName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void setterMethod(String methodName, JsonElement value) throws Exception {

        Method[] methodArr = cls.getDeclaredMethods();

        for (Method mt : methodArr)
        {
            if (!mt.getName().toUpperCase().equals("SET" + methodName.toUpperCase()))
            {
                continue;
            }

            Class[] paramType = mt.getParameterTypes();
            Constructor ct = null;

            for (int i = 0, loop = paramType.length; i < loop; i++)
            {
                if (paramType[i].equals(String.class))
                {
                    mt.invoke(clsObj, value.getAsString());
                }
                else if (paramType[i].isPrimitive())
                {
                    if (paramType[i].equals(Boolean.TYPE))
                        mt.invoke(clsObj, value.getAsBoolean());
                    else if (paramType[i].equals(Byte.TYPE))
                        mt.invoke(clsObj, value.getAsByte());
                    else if (paramType[i].equals(Short.TYPE))
                        mt.invoke(clsObj, value.getAsShort());
                    else if (paramType[i].equals(Integer.TYPE)) {
                        if("".equals(value.getAsString().trim())) {
                            mt.invoke(clsObj, 0);
                        }else {
                            mt.invoke(clsObj, value.getAsInt());
                        }
                    }
                    else if (paramType[i].equals(Long.TYPE)) {
                        if("".equals(value.getAsString().trim())) {
                            mt.invoke(clsObj, 0);
                        }else {
                            mt.invoke(clsObj, value.getAsLong());
                        }
                    }
                    else if (paramType[i].equals(Float.TYPE)) {
                        if("".equals(value.getAsString().trim())) {
                            mt.invoke(clsObj, 0);
                        }else {
                            mt.invoke(clsObj, value.getAsFloat());
                        }
                    }
                    else if (paramType[i].equals(Double.TYPE)) {
                        if("".equals(value.getAsString().trim())) {
                            mt.invoke(clsObj, 0);
                        }else {
                            mt.invoke(clsObj, value.getAsDouble());
                        }
                    }
                    else {
                        throw new NoSuchMethodException();
                    }
                }
                else if (paramType[i].equals(List.class) || paramType[i].equals(ArrayList.class))
                {
                    mt.invoke(clsObj, value);
                }
                else if (paramType[i].equals(BigDecimal.class))
                {
                    mt.invoke(clsObj, new BigDecimal(value.getAsString()));
                }
                else
                {
                    try
                    {
//                        ct = paramType[i].getConstructor(String.class);
//                        ct = paramType[i].getConstructor();
//                        ct.newInstance(value);
//                        ct.newInstance();
                        Class dtoClz = Class.forName(paramType[i].getName());
                        Object paramDto = dtoClz.newInstance();
                        VOConverter vo = new VOConverter();
                        
                        Object dto = vo.fromJsonString(value.getAsJsonObject(), paramDto);
                        mt.invoke(clsObj, dto);
                    }
                    catch (NoSuchMethodException e)
                    {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
            break;
        }
    }
    
    public void setterMethod(String methodName, Object value) throws Exception {

        Method[] methodArr = cls.getDeclaredMethods();

        for (Method mt : methodArr)
		{
			if (!mt.getName().toUpperCase().equals("SET" + methodName.toUpperCase()))
			{
				continue;
			}

			Class[] paramType = mt.getParameterTypes();
			Constructor ct = null;

			for (int i = 0, loop = paramType.length; i < loop; i++)
			{
				if (paramType[i].equals(String.class))
				{
					mt.invoke(clsObj, value);
				}
				else if (paramType[i].isPrimitive())
				{
					if (paramType[i].equals(Boolean.TYPE))
						mt.invoke(clsObj, value);
					else if (paramType[i].equals(Byte.TYPE))
						mt.invoke(clsObj, value);
					else if (paramType[i].equals(Short.TYPE))
						mt.invoke(clsObj, value);
					else if (paramType[i].equals(Integer.TYPE))
						mt.invoke(clsObj, value);
					else if (paramType[i].equals(Long.TYPE))
						mt.invoke(clsObj, value);
					else if (paramType[i].equals(Float.TYPE))
						mt.invoke(clsObj, value);
					else if (paramType[i].equals(Double.TYPE))
						mt.invoke(clsObj, value);
					else {
						throw new NoSuchMethodException();
					}
				}
				else if (paramType[i].equals(List.class) || paramType[i].equals(ArrayList.class))
				{
					mt.invoke(clsObj, value);
				}
				else if (paramType[i].equals(BigDecimal.class))
				{
					mt.invoke(clsObj, new BigDecimal(String.valueOf(value)));
				}
				else
				{
					try
					{
						ct = paramType[i].getConstructor(String.class);
						ct.newInstance(value);
						mt.invoke(clsObj, ct);
					}
					catch (NoSuchMethodException e)
					{
						e.printStackTrace();
						continue;
					}
				}
			}
			break;
		}
    }//setter

    public Object getterMethod(String methodName) {
        Object rtnValue = null;
        Method getMethod = null;

        try {
        	if(methodName.length() > 2) {
        		if(methodName.substring(0,  1).matches("[a-z]+") &&
        				methodName.substring(1,  2).matches("[A-Z]+")
        				) {
        			getMethod = cls.getMethod("get"+methodName);
        		} else {
        			getMethod = cls.getMethod("get"+StringUtils.capitalize(methodName));
        		}
        	}

            rtnValue = getMethod.invoke( clsObj );
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }

        return rtnValue;
    }
    
    public static void main(String[] args) throws Exception{
        
        
        Object svo = new TestDTO();
        svo = svo.getClass().newInstance();

        MethodReflection mtf = new MethodReflection( svo );
        
        String strJson = "{\"a\":\"abcd\",\"empnm\":\"\",\"deptCd\":\"\",\"deptNm\":\"\",\"dto\":{\"test\":\"test\"}}";
        
        JsonObject json = JsonUtil.toJsonObject(strJson);
        
        mtf.setterMethod("dto", json.get("dto") );
        
        SubDTO a = (SubDTO)mtf.getterMethod("dto");
        
        System.out.println(mtf.getterMethod("abc"));
        System.out.println(a.getTest());
        
    }
}

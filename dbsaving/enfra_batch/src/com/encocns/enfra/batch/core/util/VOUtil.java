package com.encocns.enfra.batch.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.springframework.util.StringUtils;

public class VOUtil {

    /**
     * VO 설정 소스 생성 : 목표VO의 필드에 해당하는 소스VO의 필드 값을 설정
     * @param sourceVo : 소스VO, sourceName : 소스VO 오브젝트명, targetVo : 목표VO, targetName : 목표VO 오브젝트명
     * @return void
     */
	public static void printVOSetter(Object sourceVo, String sourceName, Object targetVo, String targetName) {
		Field[] sourceFields = sourceVo.getClass().getDeclaredFields();
		Field[] targetFields = targetVo.getClass().getDeclaredFields();

		if (sourceFields.length <= 0) {
			System.out.println("sourceFields of sourceVo is nothing!!");
			return;
		}

		if (targetFields.length <= 0) {
			System.out.println("targetFields of targetVo is nothing!!");
			return;
		}

		ArrayList<String> sourceFieldsName = new ArrayList<String>();
		for (Field sourceField : sourceFields) {
			sourceFieldsName.add(sourceField.getName());
		}

		ArrayList<String> targetFieldsName = new ArrayList<String>();
		for (Field targetField : targetFields) {
			targetFieldsName.add(targetField.getName());
		}

		boolean searchFlag = false;
		for (String sourceFieldName : sourceFieldsName) {
			searchFlag = false;
			for (int i = 0; i < targetFieldsName.size() && searchFlag == false; i++) {
				if (sourceFieldName.equals(targetFieldsName.get(i))) {
					System.out.println(targetName + ".set" + targetFieldsName.get(i) + "(" + sourceName + ".get" + sourceFieldName + "());");
					searchFlag = true;
				}
			}
		}
	}

	/**
     * VO 설정 소스 생성 : 정렬된 목표VO의 필드에 해당하는 소스VO의 필드 값을 설정
     * @param sourceVo : 소스VO, sourceName : 소스VO 오브젝트명, targetVo : 목표VO, targetName : 목표VO 오브젝트명
     * @return void
     */
	public static void printSortVOSetter(Object sourceVo, String sourceName, Object targetVo, String targetName) {
		Field[] sourceFields = sourceVo.getClass().getDeclaredFields();
		Field[] targetFields = targetVo.getClass().getDeclaredFields();

		if (sourceFields.length <= 0) {
			System.out.println("sourceFields of sourceVo is nothing!!");
			return;
		}

		if (targetFields.length <= 0) {
			System.out.println("targetFields of targetVo is nothing!!");
			return;
		}

		ArrayList<String> sourceFieldsName = new ArrayList<String>();
		for (Field sourceField : sourceFields) {
			sourceFieldsName.add(sourceField.getName());
		}
		sourceFieldsName.sort(null);

		ArrayList<String> targetFieldsName = new ArrayList<String>();
		for (Field targetField : targetFields) {
			targetFieldsName.add(targetField.getName());
		}
		targetFieldsName.sort(null);

		int targetIndex = 0;
		boolean searchFlag = false;
		for (String sourceFieldName : sourceFieldsName) {
			searchFlag = false;
			for (int i = targetIndex; i < targetFieldsName.size() && searchFlag == false; i++) {
				if (sourceFieldName.equals(targetFieldsName.get(i))) {
					System.out.println(targetName + ".set" + targetFieldsName.get(i) + "(" + sourceName + ".get" + sourceFieldName + "());");
					targetIndex = i + 1;
					searchFlag = true;
				}
			}
		}
	}

	/**
     * VO 로그 출력
     * @param vo : 로그대상, logger : 로거
     * @return void
     */
	public static void printLogVO(Object vo, Logger logger) throws Exception {
		String voName = vo.getClass().getSimpleName();
		Field[] voFields = vo.getClass().getDeclaredFields();

		ArrayList<String> voFieldsName = new ArrayList<String>();
		for (Field voField : voFields) {
			voFieldsName.add(voField.getName());
		}

		Class<?> voClass = vo.getClass();
		String voGetterName = "";
		Method voGetter = null;

		if(logger.isDebugEnabled()) {
			logger.debug("==========================================================");
			logger.debug("========== VO Name : " + voName + " ==========");
			logger.debug("==========================================================");
			String fieldName = "";
			StringBuffer sb = null;
			for (Field voField : voFields) {
	
				if (voField.getType().isArray()) {
					voField.getType().getName();
				}
	
				fieldName = voField.getName();
				sb = new StringBuffer();
				sb.append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));
				voGetterName = "get" +  sb.toString();
				voGetter = voClass.getMethod(voGetterName);
				logger.debug(voField.getName() + " : [" + voGetter.invoke(vo) + "]");
			}
			logger.debug("==========================================================");
		}
	}
	
    /**
     * VO 설정 소스 생성 : 목표VO의 소스VO 필드 값 복사
     * @param sourceVo : 소스VO, targetVo : 목표VO
     * @return void
     */
    public static void copyVO( Object sourceVo, Object targetVo ) throws Exception  {
        
        Field[] sourceFields = sourceVo.getClass().getDeclaredFields();
        
        Class<?> sourceClass = sourceVo.getClass();
        Class<?> targetClass = targetVo.getClass();
        
        String fieldName = "";
        
        Method voGetter = null;
        Method voSetter = null;
        
        for( Field sourceField : sourceFields ) {
            fieldName = StringUtils.capitalize(sourceField.getName()); 
            voGetter = sourceClass.getMethod("get" + fieldName);
            Object rtn = voGetter.invoke(sourceVo);
            voSetter = targetClass.getMethod("set" + fieldName, sourceField.getType() );
            voSetter.invoke(targetVo, rtn);
        }
    }

	/**
     * VO isnull
     * @param vo : vo
     * @return boolean
     */
	public static boolean isNull( Object vo ) {

		if( vo==null )
		{
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
//		IVL990510SVO osvo = new IVL990510SVO();
//		IVL990510DVO dvo = new IVL990510DVO();
//
//      printVoSetter(dvo, "dvo", osvo, "osvo");
    }

	@SuppressWarnings("rawtypes")
	public static LinkedHashMap<String, Object> getFields(Object obj) {

		LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();

		try {
			Class dymClass = obj.getClass();
			Field[] fields = dymClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				String methodName = fields[i].getName();

	    		if(methodName.substring(0,  1).matches("[a-z]+") &&
	    				methodName.substring(1,  2).matches("[A-Z]+")
	    				) {
	    			methodName = "get"+methodName;
	    		} else {
	    			methodName = "get"+StringUtils.capitalize(methodName);
	    		}

				Method method = obj.getClass().getMethod(methodName, null);

				String value = String.valueOf(method.invoke(obj, null));

				result.put("c" + (i+1) , value);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}

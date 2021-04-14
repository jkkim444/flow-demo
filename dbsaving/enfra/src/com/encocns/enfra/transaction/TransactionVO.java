package com.encocns.enfra.transaction;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;

import com.encocns.enfra.core.util.JsonUtil;
import com.google.gson.JsonObject;

public class TransactionVO implements Serializable {

	private static final long serialVersionUID = 6219893045700639635L;
	
	private String service;
	private String method;
//	private String param;
	private Map<String,Object> param;
	private JsonObject paramJson;
	private Object serviceObj;
	private Class<?> isvoCls;
	private	Class<?> osvoCls;
	private Object isvoObj;
	private Object osvoObj;
	private String menuId;
	private String screenId;
	private String txStrtTime;
	private JsonObject headerJson;

	//setter getter
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	public Map<String,Object> getParam() {
		return param;
	}
//	public void setParam(Map<String,Object> param) {
////		this.setParamJson( JSONObject.fromObject(param) );
//		this.setParamJson( JsonUtil.toJsonObject(param) );
//		this.param = param;
//	}
	public void setParam(Map<String, Object> param) {
	    this.setParamJson( JsonUtil.toJsonObject(param) );
	    this.param = param;
	}
	
	public Object getServiceObj() {
		return serviceObj;
	}
    public void setServiceObj(Object serviceObj) {
		this.serviceObj = serviceObj;
		getServiceSVO();
	}
	public Class<?> getIsvoCls() {
		return isvoCls;
	}
	public void setIsvoCls(Class<?> isvoCls) {
		this.isvoCls = isvoCls;
	}
	public Class<?> getOsvoCls() {
		return osvoCls;
	}
	public void setOsvoCls(Class<?> osvoCls) {
		this.osvoCls = osvoCls;
	}
	public Object getIsvoObj() {
		return isvoObj;
	}
	public void setIsvoObj(Object isvoObj) {
		this.isvoObj = isvoObj;
	}
	public Object getOsvoObj() {
		return osvoObj;
	}
	public void setOsvoObj(Object osvoObj) {
		this.osvoObj = osvoObj;
	}
	public String getTxStrtTime() {
        return txStrtTime;
    }
    public void setTxStrtTime(String txStrtTime) {
        this.txStrtTime = txStrtTime;
    }
    private void getServiceSVO()
	{
		Method[] methodArr = serviceObj.getClass().getDeclaredMethods();
		
		for( Method mth : methodArr )
		{
			if(mth.getName().equals(this.method))
			{
				this.setIsvoCls(mth.getParameterTypes()[0]);
				this.setOsvoCls(mth.getReturnType());
				
				try
				{
					this.setIsvoObj(mth.getParameterTypes()[0].newInstance());
					this.setOsvoObj(mth.getReturnType().newInstance());
				}
				catch(Exception e){ e.printStackTrace(); }
				
				break;
			}
		}
	}
	public JsonObject getParamJson() {
		return paramJson;
	}
	public void setParamJson(JsonObject paramJson) {
		this.paramJson = paramJson;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
    /**
     * @return the screenId
     */
    public String getScreenId() {
        return screenId;
    }
    /**
     * @param screenId the screenId to set
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
    public JsonObject getHeaderJson() {
        return headerJson;
    }
    public void setHeaderJson(JsonObject headerJson) {
        this.headerJson = headerJson;
    }
    

    
}

/*
 * Copyright KAKAO BANK.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of KAKAO BANK.,LTD. ("Confidential Information").
 */
/**
 * @file CCO11000100.java
 * @brief 로그인 정보 Service
 */
/**
 * @namespace com.encocns.cfw.service.cco
 * @brief 공통 Service Package
 */
package com.encocns.fw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @brief Generator 서비스
 * @details
 * 
 *          <pre>
 *          </pre>
 * 
 * @author : alvin
 * @date : 2016. 8. 1.
 * @version : 1.0.0
 */
@Service
public class GeneratorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorService.class);

//	@Autowired
//	private GENERATORDAO generatorDao;

//	public int startGenerator(JSONObject inputData, String dataArray) {
//
//		int result = 0;
//
//		try {
//
//			GENERATOR01DTO generDto = new GENERATOR01DTO();
//
//			if (LOGGER.isDebugEnabled())
//				LOGGER.debug("----- generator -----");
//
//			String menuId = (String) inputData.get("menuId");
//			String menuNm = (String) inputData.get("menuNm");
//			String screenId = (String) inputData.get("screenId");
//			String screenNm = (String) inputData.get("screenNm");
//			String serviceId = (String) inputData.get("serviceId");
//			String serviceNm = (String) inputData.get("serviceNm");
//			String methodId = (String) inputData.get("methodId");
//			String methodNm = (String) inputData.get("methodNm");
//			String rmkcntn = (String) inputData.get("rmkcntn");
//			String tableNm = (String) inputData.get("tableNm");
//			String hgrkMenuId = "";
//
//			if (menuId.substring(5).equals("00")) {
//				hgrkMenuId = menuId.substring(0, 3) + "000000";
//			} else {
//				hgrkMenuId = menuId.substring(0, 5) + "0000";
//			}
//
//			generDto.setPrj_id("ENCO");
//			generDto.setMenuId(menuId);
//			generDto.setMenuNm(menuNm);
//			generDto.setScreenId(screenId);
//			generDto.setScreenNm(screenNm);
//			generDto.setServiceId(serviceId);
//			generDto.setServiceNm(serviceNm);
//			generDto.setMethodId("svc_" + methodId);
//			generDto.setMethodNm(methodNm);
//			generDto.setRmkcntn(rmkcntn);
//			generDto.setLccd(menuId.substring(0, 3).toUpperCase());
//			generDto.setHgrkMenuId(hgrkMenuId);
//
//			generatorDao.delMenu(generDto);
//			generatorDao.delScreen(generDto);
//			generatorDao.delService(generDto);
//			generatorDao.insMenu(generDto);
//			generatorDao.insScreen(generDto);
//			generatorDao.insService(generDto);
//			//////////////////////////////////
//			generDto.setMethodId("btn_clear");
//			generDto.setMethodNm("초기화");
//			/////////////////////////////////
//
//			/*
//			// DTO
//			createGetSet("DTO", serviceId, JSONObject.fromObject(dataArray).getJSONArray("myGrid3"));
//			// ISVO
//			createGetSet("ISVO", serviceId, JSONObject.fromObject(dataArray).getJSONArray("myGrid4"));
//			// OSVO
//			createGetSet("OSVO", serviceId, JSONObject.fromObject(dataArray).getJSONArray("myGrid5"));
//			// MAPPER
//			createXml(serviceId, methodId, tableNm, JSONObject.fromObject(dataArray).getJSONArray("myGrid3"),
//					JSONObject.fromObject(dataArray).getJSONArray("myGrid4"));
//			// DAO
//			createDao(serviceId, methodId);
//			// SERVICE
//			createService(serviceId, methodId);
//			// JSP
//			createJsp(screenId, methodId, JSONObject.fromObject(dataArray).getJSONArray("myGrid4"));
//			*/
//			// JS
////			createJs(screenId, methodId, JSONObject.fromObject(dataArray).getJSONArray("myGrid3"),
////			JSONObject.fromObject(dataArray).getJSONArray("myGrid4"));
//		} catch (Exception e) {
//
//			result = 1;
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	private void createGetSet(String div, String className, JSONArray jsonData) {
//		try {
//			String templateFile = "com/encocns/pms/velocity/GerneratorGetSetTemplet.vm";
//
//			String _className = className + "_01" + div;
//			String dtoName = className + "_01DTO";
//
//			JSONArray classData = jsonData;
//
//			VelocityGetSetImportDescriptor cdImporter = new VelocityGetSetImportDescriptor();
//
//			Attributes attr = new Attributes();
//			attr.putValue("name", _className);
//
//			String createPath = "";
//			String packagePath = "";
//			if (div.equals("DTO")) {
//				packagePath = "dto." + _className.substring(0, 3).toLowerCase();
//				createPath = "C:/project/workspace/encoPMS/src/com/encocns/pms/dto/";
//			} else {
//				packagePath = "service.svo." + _className.substring(0, 3).toLowerCase();
//				createPath = "C:/project/workspace/encoPMS/src/com/encocns/pms/service/svo/";
//			}
//
//			attr.putValue("path", packagePath);
//
//			attr.putValue("importClass", "");
//			for (int i = 0; i < classData.size(); i++) {
//				JSONObject jsonObj = JSONObject.fromObject(classData.get(i));
//				if (jsonObj.get("type").toString().equals("DTO")) {
//					attr.putValue("importClass",
//							"import com.encocns.pms.dto." + _className.substring(0, 3).toLowerCase() + "." + dtoName + ";");
//				}
//			}
//
//			cdImporter.startElement("", "Class", "", attr);
//
//			for (int i = 0; i < classData.size(); i++) {
//				JSONObject jsonObj = JSONObject.fromObject(classData.get(i));
//
//				Attributes attr2 = new Attributes();
//				attr2.putValue("uppername", jsonObj.get("column_name").toString().substring(0, 1).toUpperCase()
//						+ jsonObj.get("column_name").toString().substring(1));
//				attr2.putValue("name", jsonObj.get("column_name").toString());
//
//				String type = "";
//				if (jsonObj.get("type").toString().equals("VARCHAR2")) {
//					type = "String";
//				} else if (jsonObj.get("type").toString().equals("NUMBER")) {
//					type = "BigDecimal";
//				} else if (jsonObj.get("type").toString().equals("DTO")) {
//					type = "ArrayList<" + dtoName + ">";
//				} else {
//					type = "String";
//				}
//				attr2.putValue("type", type);
//				attr2.putValue("comment", jsonObj.get("column_comment").toString());
//
//				cdImporter.startElement("", "Attribute", "", attr2);
//			}
//
//			// 생성순서
//			// DTO -> ISVO -> OSVO -> XML -> DAO ->SERVICE -> JSP -> JS
//
//			// DTO -> 서비스ID + 01 + DTO
//			// ISVO -> 서비스ID + 01 +ISVO
//			// OSVO -> 서비스ID + 01 +OSVO
//			// XML -> 서비스ID
//			// DAO -> 서비스ID + DAO
//			// SERVICE -> 서비스ID
//			// JSP -> 화면ID + SC
//			// JS -> 화면ID + SC
//			ArrayList classes = cdImporter.getClasses(); // VelocityClassDescriptor
//																										// Array
//			fileWrite("CLASS", classes, createPath + _className.substring(0, 3).toLowerCase() + "/" + _className + ".java",
//					templateFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private void createXml(String nameSpace, String methodId, String tableNm, JSONArray dtoData, JSONArray isvoData) {
//		try {
//			String templateFile = "com/encocns/pms/velocity/GerneratorXmlTemplet.vm";
//
//			VelocityXmlImportDescriptor cdImporter = new VelocityXmlImportDescriptor();
//
//			Attributes attr = new Attributes();
//			attr.putValue("namespace", nameSpace);
//			attr.putValue("methodNm", methodId);
//			attr.putValue("resultType",
//					"com.encocns.pms.dto." + nameSpace.substring(0, 3).toLowerCase() + "." + nameSpace.toUpperCase() + "_01DTO");
//			attr.putValue("parameterType", "com.encocns.pms.service.svo." + nameSpace.substring(0, 3).toLowerCase() + "."
//					+ nameSpace.toUpperCase() + "_01ISVO");
//			attr.putValue("tableNm", tableNm.toUpperCase());
//
//			cdImporter.startElement("", "Class", "", attr);
//
//			JSONArray _dtoData = dtoData;
//			JSONArray _isvoData = isvoData;
//
//			String comaDiv = "  ";
//			for (int i = 0; i < _dtoData.size(); i++) {
//				JSONObject jsonObj = JSONObject.fromObject(_dtoData.get(i));
//
//				Attributes attr2 = new Attributes();
//
//				attr2.putValue("columnName", jsonObj.get("column_name").toString());
//				attr2.putValue("upperColumnName", comaDiv + jsonObj.get("column_name").toString().toUpperCase());
//				attr2.putValue("columnComment", jsonObj.get("column_comment").toString());
//
//				cdImporter.startElement("", "Attribute1", "", attr2);
//				comaDiv = ", ";
//			}
//
//			comaDiv = "    ";
//			for (int i = 0; i < _isvoData.size(); i++) {
//				JSONObject jsonObj = JSONObject.fromObject(_isvoData.get(i));
//
//				Attributes attr2 = new Attributes();
//				attr2.putValue("columnName", jsonObj.get("column_name").toString());
//				attr2.putValue("upperColumnName", comaDiv + jsonObj.get("column_name").toString().toUpperCase());
//				attr2.putValue("columnComment", jsonObj.get("column_comment").toString());
//
//				cdImporter.startElement("", "Attribute2", "", attr2);
//				comaDiv = "AND ";
//			}
//
//			// 생성순서
//			// DTO -> ISVO -> OSVO -> XML -> DAO ->SERVICE -> JSP -> JS
//
//			// DTO -> 서비스ID + 01 + DTO
//			// ISVO -> 서비스ID + 01 +ISVO
//			// OSVO -> 서비스ID + 01 +OSVO
//			// XML -> 서비스ID
//			// DAO -> 서비스ID + DAO
//			// SERVICE -> 서비스ID
//			// JSP -> 화면ID + SC
//			// JS -> 화면ID + SC
//			ArrayList classes = cdImporter.getClasses(); // VelocityClassDescriptor
//																										// Array
//			fileWrite("XML", classes, "C:/project/workspace/encoPMS/src/com/encocns/pms/mapper/"
//					+ nameSpace.substring(0, 3).toLowerCase() + "/" + nameSpace + ".xml", templateFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void createDao(String serviceId, String methodId) {
//		try {
//			String templateFile = "com/encocns/pms/velocity/GerneratorDaoTemplet.vm";
//
//			VelocityDaoImportDescriptor cdImporter = new VelocityDaoImportDescriptor();
//
//			Attributes attr = new Attributes();
//			attr.putValue("serviceId", serviceId);
//			attr.putValue("methodId", methodId);
//			attr.putValue("lscs", serviceId.substring(0, 3).toLowerCase());
//
//			cdImporter.startElement("", "Class", "", attr);
//
//			// 생성순서
//			// DTO -> ISVO -> OSVO -> XML -> DAO ->SERVICE -> JSP -> JS
//
//			// DTO -> 서비스ID + 01 + DTO
//			// ISVO -> 서비스ID + 01 +ISVO
//			// OSVO -> 서비스ID + 01 +OSVO
//			// XML -> 서비스ID
//			// DAO -> 서비스ID + DAO
//			// SERVICE -> 서비스ID
//			// JSP -> 화면ID + SC
//			// JS -> 화면ID + SC
//			ArrayList classes = cdImporter.getClasses(); // VelocityClassDescriptor
//																										// Array
//			fileWrite("DAO", classes, "C:/project/workspace/encoPMS/src/com/encocns/pms/dao/"
//					+ serviceId.substring(0, 3).toLowerCase() + "/" + serviceId + "_DAO" + ".java", templateFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private void createService(String serviceId, String methodId) {
//		try {
//			String templateFile = "com/encocns/pms/velocity/GerneratorServiceTemplet.vm";
//
//			VelocityServiceImportDescriptor cdImporter = new VelocityServiceImportDescriptor();
//
//			Attributes attr = new Attributes();
//			attr.putValue("serviceId", serviceId);
//			attr.putValue("methodId", methodId);
//			attr.putValue("lscs", serviceId.substring(0, 3).toLowerCase());
//
//			cdImporter.startElement("", "Class", "", attr);
//
//			// 생성순서
//			// DTO -> ISVO -> OSVO -> XML -> DAO ->SERVICE -> JSP -> JS
//
//			// DTO -> 서비스ID + 01 + DTO
//			// ISVO -> 서비스ID + 01 +ISVO
//			// OSVO -> 서비스ID + 01 +OSVO
//			// XML -> 서비스ID
//			// DAO -> 서비스ID + DAO
//			// SERVICE -> 서비스ID
//			// JSP -> 화면ID + SC
//			// JS -> 화면ID + SC
//			ArrayList classes = cdImporter.getClasses(); // VelocityClassDescriptor
//																										// Array
//			fileWrite("SERVICE", classes, "C:/project/workspace/encoPMS/src/com/encocns/pms/service/"
//					+ serviceId.substring(0, 3).toLowerCase() + "/" + serviceId + ".java", templateFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void createJsp(String screenId, String methodId, JSONArray isvoData) {
//
//		try {
//			String templateFile = "com/encocns/pms/velocity/GerneratorJspTemplet.vm";
//
//			VelocityJspImportDescriptor cdImporter = new VelocityJspImportDescriptor();
//
//			Attributes attr = new Attributes();
//			attr.putValue("screenId", screenId);
//			attr.putValue("methodId", methodId);
//
//			cdImporter.startElement("", "Class", "", attr);
//
//			JSONArray _isvoData = isvoData;
//
//			int sumCol = 0;
//			for (int i = 0; i < 8; i++) {
//
//				Attributes attr3 = new Attributes();
//
//				int[] colArray = { 10, 15 };
//				attr3.putValue("colWidth", "<col width='" + colArray[i % 2] + "%'>");
//				cdImporter.startElement("", "Attribute1", "", attr3);
//				sumCol += colArray[i % 2];
//
//				if (_isvoData.size() * 2 == i + 1) {
//					attr3.putValue("colWidth", "<col width='" + (100 - sumCol) + "%'>");
//					cdImporter.startElement("", "Attribute1", "", attr3);
//					break;
//				}
//			}
//
//			int tdCount = 1;
//			String inputdata = "";
//
//			for (int i = 0; i < _isvoData.size() + 1; i++) {
//
//				if (tdCount == 5)
//					tdCount = 1;
//				Attributes attr2 = new Attributes();
//
//				if (i == _isvoData.size()) {
//
//					if (tdCount == 1)
//						break;
//					tdCount = tdCount - 1;
//					attr2.putValue("inputData", "");
//					attr2.putValue("columnComment", "");
//					if (4 - tdCount > 0) {
//						attr2.putValue("startTd", "<td colspan='" + (4 - tdCount) * 2 + "'>");
//					} else {
//						attr2.putValue("startTd", "<td>");
//					}
//
//					attr2.putValue("endTd", "</td>");
//					attr2.putValue("tdCount", "4");
//
//					cdImporter.startElement("", "Attribute2", "", attr2);
//
//					break;
//				}
//
//				JSONObject jsonObj = JSONObject.fromObject(_isvoData.get(i));
//
//				inputdata = "<input class='AXInput' id='i_" + jsonObj.get("column_name").toString() + "' type='text'>";
//				attr2.putValue("tdCount", String.valueOf(tdCount));
//				attr2.putValue("startTd", "<td>");
//				attr2.putValue("endTd", "</td>");
//				attr2.putValue("inputData", inputdata);
//				attr2.putValue("columnComment", "<th>" + jsonObj.get("column_comment").toString() + "</th>");
//
//				cdImporter.startElement("", "Attribute2", "", attr2);
//
//				tdCount++;
//			}
//
//			// 생성순서
//			// DTO -> ISVO -> OSVO -> XML -> DAO ->SERVICE -> JSP -> JS
//
//			// DTO -> 서비스ID + 01 + DTO
//			// ISVO -> 서비스ID + 01 +ISVO
//			// OSVO -> 서비스ID + 01 +OSVO
//			// XML -> 서비스ID
//			// DAO -> 서비스ID + DAO
//			// SERVICE -> 서비스ID
//			// JSP -> 화면ID + SC
//			// JS -> 화면ID + SC
//			ArrayList classes = cdImporter.getClasses(); // VelocityClassDescriptor
//																										// Array
//			fileWrite("JSP", classes, "C:/project/workspace/encoPMS/WebContent/WEB-INF/views/"
//					+ screenId.substring(0, 3).toLowerCase() + "/" + screenId + ".jsp", templateFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void createJs(String screenId, String methodId, JSONArray dtoData, JSONArray isvoData) {
//		try {
//			String templateFile = "com/encocns/pms/velocity/GerneratorJsTemplet.vm";
//
//			VelocityJsImportDescriptor cdImporter = new VelocityJsImportDescriptor();
//
//			Attributes attr = new Attributes();
//			attr.putValue("screenId", screenId);
//			attr.putValue("methodId", methodId);
//
//			cdImporter.startElement("", "Class", "", attr);
//
//			JSONArray _isvoData = isvoData;
//			JSONArray _dtoData = dtoData;
//
//			String comaDiv = "  ";
//			for (int i = 0; i < _isvoData.size(); i++) {
//				JSONObject jsonObj = JSONObject.fromObject(_isvoData.get(i));
//
//				Attributes attr2 = new Attributes();
//
//				attr2.putValue("columnName", jsonObj.get("column_name").toString());
//				attr2.putValue("coma", comaDiv);
//
//				cdImporter.startElement("", "Attribute1", "", attr2);
//				comaDiv = ", ";
//			}
//
//			comaDiv = "  ";
//			for (int i = 0; i < _dtoData.size(); i++) {
//				JSONObject jsonObj = JSONObject.fromObject(_dtoData.get(i));
//
//				Attributes attr2 = new Attributes();
//				attr2.putValue("columnName", jsonObj.get("column_name").toString());
//				if (jsonObj.get("column_comment").toString().trim().equals("")
//						|| jsonObj.get("column_comment").toString() == null) {
//					attr2.putValue("columnComment", jsonObj.get("column_name").toString());
//				} else {
//					attr2.putValue("columnComment", jsonObj.get("column_comment").toString());
//				}
//				attr2.putValue("coma", comaDiv);
//				
//				int iSize = 0;
//				
//				iSize = !jsonObj.containsKey("type_size")?0:Integer.parseInt(jsonObj.getString("type_size"));
////				iSize = Integer.parseInt(jsonObj.get("type_size").toString());
//				iSize = iSize * 20;
//
//				String align = "";
//
//				if (jsonObj.get("type").toString().equals("VARCHAR2")) {
//					align = "left";
//				} else if (jsonObj.get("type").toString().equals("NUMBER")) {
//					align = "right";
//				} else if (jsonObj.get("type").toString().equals("TIMESTAMP(6)")) {
//					align = "center";
//				} else {
//					align = "left";
//				}
//
//				attr2.putValue("align", align);
//				attr2.putValue("width", String.valueOf(iSize > 250 ? 250 : iSize));
//				cdImporter.startElement("", "Attribute2", "", attr2);
//				comaDiv = ", ";
//			}
//
//			// 생성순서
//			// DTO -> ISVO -> OSVO -> XML -> DAO ->SERVICE -> JSP -> JS
//
//			// DTO -> 서비스ID + 01 + DTO
//			// ISVO -> 서비스ID + 01 +ISVO
//			// OSVO -> 서비스ID + 01 +OSVO
//			// XML -> 서비스ID
//			// DAO -> 서비스ID + DAO
//			// SERVICE -> 서비스ID
//			// JSP -> 화면ID + SC
//			// JS -> 화면ID + SC
//			ArrayList classes = cdImporter.getClasses(); // VelocityClassDescriptor
//																										// Array
//			fileWrite("JS", classes, "C:/project/workspace/encoPMS/WebContent/WEB-INF/scripts/"
//					+ screenId.substring(0, 3).toLowerCase() + "/" + screenId + ".js", templateFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void fileWrite(String div, ArrayList mappingList, String path, String templetPath) {
//
//		try {
//			VelocityEngine velocityEngine = new VelocityEngine();
//			velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//			velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//
//			velocityEngine.init();
//
//			for (int i = 0; i < mappingList.size(); i++) {
//				VelocityContext context = new VelocityContext();
//				switch (div) {
//				case "CLASS":
//					VelocityGetSetClassDescriptor classDc = (VelocityGetSetClassDescriptor) mappingList.get(i);
//					context.put("class", classDc);
//					break;
//				case "XML":
//					VelocityXmlClassDescriptor xmlDc = (VelocityXmlClassDescriptor) mappingList.get(i);
//					context.put("class", xmlDc);
//					break;
//				case "DAO":
//					VelocityDaoClassDescriptor daoDc = (VelocityDaoClassDescriptor) mappingList.get(i);
//					context.put("class", daoDc);
//					break;
//				case "SERVICE":
//					VelocityServiceClassDescriptor serviceDc = (VelocityServiceClassDescriptor) mappingList.get(i);
//					context.put("class", serviceDc);
//					break;
//				case "JSP":
//					VelocityJspClassDescriptor jspDc = (VelocityJspClassDescriptor) mappingList.get(i);
//					context.put("class", jspDc);
//					break;
//				case "JS":
//					VelocityJsClassDescriptor jsDc = (VelocityJsClassDescriptor) mappingList.get(i);
//					context.put("class", jsDc);
//					break;
//				}
//				// context.put("utility", utility);
//
//				Template template = velocityEngine.getTemplate(templetPath, "UTF-8");
//
//				// BufferedWriter writer = new BufferedWriter(new FileWriter(path));
//				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
//
//				template.merge(context, writer);
//
//				writer.flush();
//				writer.close();
//
//				System.out.println("Class " + path + " generated!");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}

/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1050.java
 * @brief Log Level Adjustment Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief FW Service Package
 */
package com.encocns.fw.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.service.svo.FW105001IN;
import com.encocns.fw.service.svo.FW105001OUT;
import com.encocns.fw.service.svo.FW105002IN;
import com.encocns.fw.service.svo.FW105002OUT;

/**
 * @brief 로그 레벨 설정 Service
 * @details 로그 레벨 설정 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW1050 {

	private static final Logger LOGGER = LoggerFactory.getLogger(FW1050.class);

	@Value("#{globalContext}")
	protected Properties globalContextProp;

    @Autowired
    private Environment env;


    /**
     * @brief logback.xml file read
     * @details logback.xml file read
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW105001IN
     * @return FW105001OUT
     */
	public FW105001OUT selectLogLevel( FW105001IN inSvo ) throws EnfraBusinessException
	{
	    FW105001OUT outSvo = new FW105001OUT();

	    // online log level search
        String sOnlineLogBackPath = globalContextProp.getProperty("LOGBACK_ONLINE_PATH1");
        outSvo.setOnlineLevel(getLogLevel(sOnlineLogBackPath));

        // batch log level search
        String sBatchLogBackPath = globalContextProp.getProperty("LOGBACK_BATCH_PATH");
        outSvo.setBatchLevel(getLogLevel(sBatchLogBackPath));

        LOGGER.debug("online : " + sOnlineLogBackPath );
        LOGGER.debug("batch : " + sBatchLogBackPath );

		return outSvo;
	}

    /**
     * @brief logback.xml file write
     * @details logback.xml file write
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW105002IN
     * @return FW105002OUT
     */
    public FW105002OUT updateLogLevel( FW105002IN inSvo ) throws EnfraBusinessException
    {
        String sLogBackPath;
        if( "ONLINE".equals(inSvo.getDvcd()) )  {

            String[] envs = env.getActiveProfiles();

            sLogBackPath = globalContextProp.getProperty("LOGBACK_ONLINE_PATH1");
            setLogLevel( sLogBackPath, inSvo.getLogLevel(), getLogAppender(inSvo.getLogLevel()) );

            if( "product".equals(envs[0]) ) {
                sLogBackPath = globalContextProp.getProperty("LOGBACK_ONLINE_PATH2");
                setLogLevel( sLogBackPath, inSvo.getLogLevel(), getLogAppender(inSvo.getLogLevel()) );

            }

        }
        else {
            sLogBackPath = globalContextProp.getProperty("LOGBACK_BATCH_PATH");
            setLogLevel( sLogBackPath, inSvo.getLogLevel(), getLogAppender(inSvo.getLogLevel()) );
        }


        FW105002OUT outSvo = new FW105002OUT();
        return outSvo;
    }


    /**
     * @brief logback.xml pharser
     * @details logback.xml pharser, root node log level return
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param String File path
     * @return String Log Level
     */
    private String getLogLevel(String sFilePath) {
        String sLevel = "";

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = null;

            try {
                doc = docBuilder.parse(sFilePath);

            } catch(FileNotFoundException e) {
                return "DEBUG";
            }

            Node configuration = doc.getFirstChild();

            NodeList configurationList = configuration.getChildNodes();

            for(int i=0; i<configurationList.getLength(); i++) {
                Node childNode = configurationList.item(i);

                // configuration > logger
                if("logger".equals(childNode.getNodeName())) {

                    NamedNodeMap childNodeAttr = childNode.getAttributes();
                    Node attrNameNode = childNodeAttr.getNamedItem("name");

                    // configuration > logger --> name = com.encocns
                    if("com.encocns".equals(attrNameNode.getTextContent())) {
                        NodeList loggerencocnsNodeList = childNode.getChildNodes();

                        for(int j=0; j<loggerencocnsNodeList.getLength(); j++) {
                            Node loggerencocnsNode = loggerencocnsNodeList.item(j);

                            // configuration > logger > level
                            if("level".equals(loggerencocnsNode.getNodeName())) {
                                NamedNodeMap attr = loggerencocnsNode.getAttributes();
                                Node node = attr.getNamedItem("value");

                                sLevel = node.getTextContent();
                                break;
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }

        return sLevel;
    }

    /**
     * @brief setting log level
     * @details setting log level
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param sFilePath - logback.xml Filepath
     * @param sLevel    - log level
     * @param sAppender - log appender name
     */
    private void setLogLevel(String sFilePath, String sLevel, String sAppender) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(sFilePath);

            Node configuration = doc.getFirstChild();

            NodeList configurationList = configuration.getChildNodes();

            for(int i=0; i<configurationList.getLength(); i++) {
                Node childNode = configurationList.item(i);

                // configuration > logger
                if("logger".equals(childNode.getNodeName())) {

                    NamedNodeMap childNodeAttr = childNode.getAttributes();
                    Node attrNameNode = childNodeAttr.getNamedItem("name");

                    // configuration > logger --> name = com.encocns
                    if("com.encocns".equals(attrNameNode.getTextContent())) {
                        NodeList loggerencocnsNodeList = childNode.getChildNodes();

                        boolean isFirst = true;

                        for(int j=0; j<loggerencocnsNodeList.getLength(); j++) {
                            Node loggerencocnsNode = loggerencocnsNodeList.item(j);

                            // configuration > logger > level
                            if("level".equals(loggerencocnsNode.getNodeName())) {
                                NamedNodeMap attr = loggerencocnsNode.getAttributes();
                                Node node = attr.getNamedItem("value");

                                node.setTextContent(sLevel);
                            }

                            // configuration > logger > appender-ref
                            if("appender-ref".equals(loggerencocnsNode.getNodeName()) && isFirst) {
                                NamedNodeMap attr = loggerencocnsNode.getAttributes();
                                Node node = attr.getNamedItem("ref");

                                node.setTextContent(sAppender);

                                isFirst = false;
                            }
                        }
                    }//jdbc.sqltiming
                    if("jdbc.sqltiming".equals(attrNameNode.getTextContent())) {
                        NodeList loggerencocnsNodeList = childNode.getChildNodes();

                        boolean isFirst = true;

                        for(int j=0; j<loggerencocnsNodeList.getLength(); j++) {
                            Node loggerencocnsNode = loggerencocnsNodeList.item(j);

                            // configuration > logger > level
                            if("level".equals(loggerencocnsNode.getNodeName())) {
                                NamedNodeMap attr = loggerencocnsNode.getAttributes();
                                Node node = attr.getNamedItem("value");

                                node.setTextContent(sLevel);
                            }

                            // configuration > logger > appender-ref
                            if("appender-ref".equals(loggerencocnsNode.getNodeName()) && isFirst) {
                                NamedNodeMap attr = loggerencocnsNode.getAttributes();
                                Node node = attr.getNamedItem("ref");

                                node.setTextContent(sAppender);

                                isFirst = false;
                            }
                        }
                    }//jdbc.sqltiming
                }
            }

            // xml file modify
            xmlFileModify(sFilePath, doc);

        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }

    }

    /**
     * @brief XML File Write
     * @details XML File Writer
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param sFilePath File Path
     * @param doc Document(JAVA DOM)
     */
    private void xmlFileModify(String sFilePath, Document doc) {
        try {
            System.setProperty("javax.xml.transform.TransformerFactory", "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(sFilePath));
            transformer.transform(source, result);
        } catch(Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * @brief return log appender
     * @details return log Appender
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param sLevel
     * @return String LogAppender
     */
    private String getLogAppender(String sLevel) {
        return sLevel.toLowerCase() + "RollingFileAppender";
    }

}

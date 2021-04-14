/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file CommonUtil.java
 * @brief
 * \~english Common Utiltiy
 * \~korean 공통 Utiltiy
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 9. 23. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.util
 * @brief Common Utility Pakcage
 */
package com.encocns.ifrs.co.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @brief
 * \~english Common Utility
 * \~korean Common Utility
 * @details
 * <pre>
 * Common Utility
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 9. 23.
 * @version : 1.0.0
 */
@Component
public class CommonUtil {

    @Autowired
    private ApplicationContext applicationContext;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);
    
//	@Autowired
//	@Qualifier("sqlSessionTemplate")
//	private SqlSessionTemplate sqlSessionTemplate;

    /**
     * @brief
     * \~english Look up the Server IP address and return it.
     * \~korean Look up the Server IP address and return it.
     * @details
     * <pre>
     * \~english Look up the Server IP address and return it.
     * \~korean Look up the Server IP address and return it.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 8. 21.
     * @version : 1.0.0
     * @return String Server IP Address
     */
    public String getServerIpAddr() {
        String ip = "";
        
        try {
            Enumeration<NetworkInterface> niEnum = NetworkInterface.getNetworkInterfaces();
            
            while(niEnum.hasMoreElements()) {
                NetworkInterface ni = niEnum.nextElement();
                
                Enumeration<InetAddress> inetEnum = ni.getInetAddresses();
                
                while(inetEnum.hasMoreElements()) {
                    InetAddress inetAddress = inetEnum.nextElement();
                    
                    if(!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        if(inetAddress.isSiteLocalAddress()) {
                            ip = inetAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return ip;
    }
    
    /**
     * @return the fileWriterOutputDir
     */
    public String getFileWriterOutputDir() {
        return ((Properties)applicationContext.getBean("common")).getProperty("FILE_WRITER_OUTPUT_DIR");
    }

    /**
     * @return the interFaceFile ID
     */
    public String getInterFaceTransferInfo(String prefix) {
        return ((Properties)applicationContext.getBean("common")).getProperty(prefix+"_INTERFACE_NAME");
    }

}

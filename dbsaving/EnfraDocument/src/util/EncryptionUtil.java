/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EncryptionUtil.java
 * @brief AES256 암호화/복호화 Utility
 */
/**
 * @namespace tw.linebank.ifrs.common.util
 * @brief Common Utility Package
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aescrypto.AES256Cipher;

/**
 * @brief AES256 암호화/복호화 Utility
 * @details AES256 암호화/복호화 Utility이다.
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 12. 15.
 * @version : 1.0.0
 */
public class EncryptionUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtil.class);
    
    private static final String KEY = "12345678901234567890123456789012";
    private static final String IV = "1234567890123456";

    /**
     * @brief 평문 문자열을 암호화 처리
     * @details AES256 알고리즘으로 평문을 암호화 처리한다.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 12. 15.
     * @param sPlainText 평문 문자열
     * @return String 암호화 결과
     */
    public static String encrypt(String sPlainText) {
        String sEncryptText = "";
        try {
            AES256Cipher aes256Cipher = AES256Cipher.getInstance();
            aes256Cipher.setBlockNPadding("/CBC/PKCS7Padding");
            aes256Cipher.setKey(KEY);
            aes256Cipher.setIv(IV);
            sEncryptText = aes256Cipher.encrypt(sPlainText);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
        return sEncryptText;
    }

    /**
     * @brief 암호화 문자열을 평문으로 복호화 처리
     * @details AES256 알고리즘으로 암호화 문자열을 평문으로 복호화 처리한다.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 12. 15.
     * @param sEncryptedText 암호화 문자열
     * @return String 복호화 결과
     */
    public static String decrypt(String sEncryptedText) {
        String sDecryptText = "";
        try {
            AES256Cipher aes256Cipher = AES256Cipher.getInstance();
            aes256Cipher.setBlockNPadding("/CBC/PKCS7Padding");
            aes256Cipher.setKey(KEY);
            aes256Cipher.setIv(IV);
            sDecryptText = aes256Cipher.decrypt(sEncryptedText);
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
        return sDecryptText;
    }
    
    /**
     * @brief 
     * \~english Create Message Digest
     * \~korean 메시지 다이제스트 생성
     * @details 
     * <pre>
     * \~english Create a message digest to encrypt the password.
     * \~korean 패스워드를 암호화 하기 위하여 메시지 다이제스트를 생성한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 9. 2.
     * @version : 1.0.0
     * @param plainPassword Password
     * @return String messageDigest
     */
    public static String generateDigest(String plainPassword, String algorithm) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
        
//        byte byteData[] = md.digest();
        byte byteData[] = null;

        StringBuffer sb = new StringBuffer();
        
        if( md!=null ) {
            md.update(plainPassword.getBytes());
            
            if(byteData!=null) {
                for(int i=0; i<byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
                }
            }
        }

        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
//		System.out.println(EncryptionUtil.encrypt("toss1"));
		System.out.println(EncryptionUtil.decrypt("znrNR+c0fTa9EsNiwifb6Q="));
	}

}

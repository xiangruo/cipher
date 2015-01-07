/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher;

/**
 * <pre>
 * 密钥对字串，封装了base64转换操作，方便客户端使用
 * </pre>
 *
 * @author tanghuai
 * @version $Id: KeyPairString.java, v 0.1 2010-4-5 上午11:14:23 tanghuai Exp $
 */
public class KeyPairString {
    /** 公钥字串*/
    private String publicKey;
    /** 私钥字串*/
    private String privateKey;

    /**
     * Getter method for property <tt>publicKey</tt>.
     * 
     * @return property value of publicKey
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * Setter method for property <tt>publicKey</tt>.
     * 
     * @param publicKey value to be assigned to property publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * Getter method for property <tt>privateKey</tt>.
     * 
     * @return property value of privateKey
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Setter method for property <tt>privateKey</tt>.
     * 
     * @param privateKey value to be assigned to property privateKey
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}

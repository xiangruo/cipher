/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.key;

import java.security.KeyPair;

import com.alipay.avatar.cipher.AlgorithmEnum;
import com.alipay.avatar.cipher.key.KeyConvertor;
import com.alipay.avatar.cipher.key.KeyGenerator;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import junit.framework.TestCase;

/**
 * <pre>
 * 密钥格式转换器单元测试
 * </pre>
 *
 * @author tanghuai
 * @version $Id: KeyConvertorTest.java, v 0.1 2010-6-18 上午11:26:20 tanghuai Exp $
 */
public class KeyConvertorTest extends TestCase {

    private String privateKeyString;
    private String publicKeyString;

    private byte[] privateKeyBytes;
    private byte[] publicKeyBytes;

    /** 
     * @throws java.lang.Exception
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        //生成密钥字符串
        KeyPair keyPair = KeyGenerator.generateKeyPair(AlgorithmEnum.RSA, 1024, "alipay.com");

        privateKeyBytes = keyPair.getPrivate().getEncoded();
        publicKeyBytes = keyPair.getPublic().getEncoded();

        privateKeyString = Base64.encode(privateKeyBytes);
        publicKeyString = Base64.encode(publicKeyBytes);
    }

    /**
     * <pre>
     * 测试：二进制密钥   --> 字符串密钥 
     * </pre>
     *
     */
    public void testKeyBytes2KeyString() {
        assertEquals(privateKeyString, KeyConvertor.keyBytes2KeyString(privateKeyBytes));
        assertEquals(publicKeyString, KeyConvertor.keyBytes2KeyString(publicKeyBytes));
    }

    /**
     * <pre>
     * 测试：字符串密钥    --> 二进制密钥
     * </pre>
     *
     */
    public void testKeyString2KeyBytes() {
        byte[] reductive = KeyConvertor.keyString2KeyBytes(privateKeyString);
        assertEquals(privateKeyBytes.length, reductive.length);
        int length = privateKeyBytes.length;
        for (int i = 0; i < length; i++) {
            assertEquals(privateKeyBytes[i], reductive[i]);
        }
    }

    /** 
     * @throws java.lang.Exception
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

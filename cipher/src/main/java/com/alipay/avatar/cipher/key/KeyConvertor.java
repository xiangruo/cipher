/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.key;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * 密钥格式转换器
 * </pre>
 *
 * @author tanghuai
 * @version $Id: KeyConvertor.java, v 0.1 2010-6-18 上午11:25:12 tanghuai Exp $
 */
public class KeyConvertor {

    /**
     * <pre>
     * 二进制密钥   --> 字符串密钥 
     * </pre>
     *
     * @return
     */
    public static String keyBytes2KeyString(byte[] keyBytes) {
        return Base64.encode(keyBytes);
    }

    /**
     * <pre>
     * 字符串密钥    --> 二进制密钥
     * </pre>
     *
     * @return
     */
    public static byte[] keyString2KeyBytes(String keyString) {
        return Base64.decode(keyString);
    }
}

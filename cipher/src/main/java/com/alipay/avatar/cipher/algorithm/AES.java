/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.alipay.avatar.cipher.algorithm;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <pre>
 * AES工具类
 * </pre>
 *
 * @author written by zhangzhao, migrated from bcm by tanghuai 
 * @version $Id: AES.java, v 0.1 2010-3-26 下午02:16:06 tanghuai Exp $
 */
public class AES {
    //密钥算法
    public static final String ALGORITHM        = "AES";
    //密钥长度
    public static final int    DEFAULT_KEY_SIZE = 128;

    /**
     * 执行AES加密
     * 
     * @param key 密钥
     * @param plaintext 明文
     * @return 密文字节数组，如果发生异常返回null
     */
    public static byte[] encrypt(byte[] key, byte[] plaintext) {
        return process(key, plaintext, Cipher.ENCRYPT_MODE);
    }

    /**
     * 执行AES解密
     * 
     * @param key 密钥
     * @param ciphertext 密文文
     * @return 明文字节数组，如果发生异常返回null
     */
    public static byte[] decrypt(byte[] key, byte[] ciphertext) {
        return process(key, ciphertext, Cipher.DECRYPT_MODE);
    }

    /**
     * 生成AES密钥
     *  
     * @param keySize 密钥长度，目前只支持128位
     * @return 密钥字节数组，如果发生异常返回null
     */
    public static byte[] generateKey(int keySize) {
        byte[] key = null;
        KeyGenerator kgen = null;

        if (keySize != DEFAULT_KEY_SIZE) {
            keySize = DEFAULT_KEY_SIZE;
        }

        try {
            kgen = KeyGenerator.getInstance(ALGORITHM);
            kgen.init(keySize);
            SecretKey skey = kgen.generateKey();
            key = skey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("执行AES密钥生成时发生异常！", e);
        }

        return key;
    }

    /**
     * AES加解密操作
     * 
     * @param key 密钥
     * @param text 要处理的文本
     * @param charset 编码
     * @param mode Cipher.ENCRYPT_MODE / Cipher.DECRYPT_MODE
     * @return 处理后的字节数组
     */
    private static byte[] process(byte[] key, byte[] text, int mode) {
        byte[] result = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(mode, secretKeySpec);
            result = cipher.doFinal(text);
        } catch (Exception e) {
            throw new RuntimeException("执行AES加解密操作时发生异常！", e);
        }
        return result;
    }
}

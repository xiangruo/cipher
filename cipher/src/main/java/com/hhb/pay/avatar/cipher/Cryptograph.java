/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher;

/**
 * <pre>
 * 加解密工具
 * </pre>
 *
 * @author 
 * @version $Id: Cryptograph.java, v 0.1 2010-4-1 上午11:04:53  Exp $
 */
public class Cryptograph {

    /**
     * <pre>
     * 解密方法
     * </pre>
     * @param algorithmEnum 解密算法
     * @param key   解密密钥
     * @param ciphertext    密文
     * @return String 解密文本
     */
    public static String decrypt(AlgorithmEnum algorithmEnum, String key, String ciphertext) {
        return Container.getAlgorithm(algorithmEnum).decrypt(key, ciphertext);
    }

    /**
     * <pre>
     * 加密方法
     * </pre>
     *
     * @param algorithmEnum 加密算法
     * @param key 加密密钥
     * @param plaintext 明文
     * @return String 加密文本
     */
    public static String encrypt(AlgorithmEnum algorithmEnum, String key, String plaintext) {
        return Container.getAlgorithm(algorithmEnum).encrypt(key, plaintext);
    }
}

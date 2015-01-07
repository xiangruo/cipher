/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.adapter;

import java.security.KeyPair;

/**
 * <pre>
 * 抽象算法接口
 * </pre>
 *
 * @author tanghuai
 * @version $Id: AlgorithmInterface.java, v 0.1 2010-4-1 下午09:16:20 tanghuai Exp $
 */
public interface AlgorithmInterface {

    /**
     * <pre>
     * 签名接口
     * </pre>
     *
     * @param key 签名密钥
     * @param txt 待签名文本
     * @return String 签名串
     */
    public String sign(String key, String txt);

    /**
     * <pre>
     * 验签接口
     * </pre>
     *
     * @param key 验签密钥
     * @param txt 待验签文本
     * @param signed 签名串
     * @return boolean 签名结果
     */
    public boolean verify(String key, String txt, String signed);

    /**
     * <pre>
     * 加密接口
     * </pre>
     *
     * @param key 加密密钥
     * @param plaintext 明文文本
     * @return String 加密文本
     */
    public String encrypt(String key, String plaintext);

    /**
     * <pre>
     * 解密接口
     * </pre>
     *
     * @param key 解密密钥
     * @param ciphertext 密文文本
     * @return String 解密文本
     */
    public String decrypt(String key, String ciphertext);

    /**
     * <pre>
     * 对称密钥生成接口
     * </pre>
     *
     * @param keySize 密钥长度
     * @return String 密钥
     */
    public String generateKey(int keySize);

    /**
     * <pre>
     * 非对称密钥生成接口
     * </pre>
     *
     * @param keySize 密钥长度
     * @param seed 密钥种子
     * @return KeyPair 密钥对
     */
    public KeyPair generateKeyPair(int keySize, String seed);

}

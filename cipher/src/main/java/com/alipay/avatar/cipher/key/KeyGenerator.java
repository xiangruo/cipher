/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.key;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.alipay.avatar.cipher.AlgorithmEnum;
import com.alipay.avatar.cipher.Container;
import com.alipay.avatar.cipher.KeyPairString;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * 密钥生成工具
 * </pre>
 *
 * @author tanghuai
 * @version $Id: KeyGenerator.java, v 0.1 2010-4-1 上午11:07:05 tanghuai Exp $
 */
public class KeyGenerator {

    /**
     * <pre>
     *生成对称密钥
     * </pre>
     *
     * @param algorithmEnum 对称密钥生成算法
     * @param keySize 密钥长度
     * @return String 密钥
     */
    public static String generateKey(AlgorithmEnum algorithmEnum, int keySize) {
        return Container.getAlgorithm(algorithmEnum).generateKey(keySize);
    }

    /**
     * <pre>
     * 生成非对称密钥
     * </pre>
     *
     * @param algorithmEnum 非对称密钥生成算法
     * @param keySize 密钥长度
     * @param seed 密钥种子
     * @return String 密钥对
     */
    public static KeyPair generateKeyPair(AlgorithmEnum algorithmEnum, int keySize, String seed) {
        return Container.getAlgorithm(algorithmEnum).generateKeyPair(keySize, seed);
    }

    /**
     * <pre>
     * 生成非对称密钥字符串，已做base64处理
     * </pre>
     *
     * @param algorithmEnum 非对称密钥生成算法
     * @param keySize 密钥长度
     * @param seed 密钥种子
     * @return String 密钥对
     */
    public static KeyPairString generateKeyPairString(AlgorithmEnum algorithmEnum, int keySize,
                                                      String seed) {
        KeyPair keyPair = Container.getAlgorithm(algorithmEnum).generateKeyPair(keySize, seed);
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey priKey = keyPair.getPrivate();

        KeyPairString keyPairString = new KeyPairString();
        keyPairString.setPublicKey(Base64.encode(pubKey.getEncoded()));
        keyPairString.setPrivateKey(Base64.encode(priKey.getEncoded()));
        return keyPairString;
    }
}

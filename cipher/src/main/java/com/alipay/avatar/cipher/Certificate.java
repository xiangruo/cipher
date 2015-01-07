/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher;

/**
 * <pre>
 * 签名、验签工具类
 * </pre>
 *
 * @author tanghuai
 * @version $Id: Certificate.java, v 0.1 2010-4-1 上午11:01:37 tanghuai Exp $
 */
public class Certificate {

    /**
     * <pre>
     * 签名方法
     * </pre>
     *
     * @param algorithmEnum 签名算法
     * @param key  签名密钥
     * @param txt  待签名文本
     * @return String 签名字符串
     */
    public static String sign(AlgorithmEnum algorithmEnum, String key, String txt) {
        return Container.getAlgorithm(algorithmEnum).sign(key, txt);
    }

    /**
     * <pre>
     * 验签方法
     * </pre>
     *
     * @param algorithmEnum 验签算法
     * @param key   验签密钥
     * @param txt   待验签文本
     * @param signed 签名字符串
     * @return boolean 验签结果
     */
    public static boolean verify(AlgorithmEnum algorithmEnum, String key, String txt, String signed) {
        return Container.getAlgorithm(algorithmEnum).verify(key, txt, signed);
    }
}

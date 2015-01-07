/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher.algorithm;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author haibo.huang
 * @version $Id: RSA.java, v 0.1 2010-3-28 下午02:16:06 haibo.huang Exp $
 */
public class RSA {
    //密钥长度
    public static final int    DEFAULT_KEY_SIZE    = 1024;
    //签名算法
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    //密钥对算法
    public static final String KEY_GEN_ALGORITHM   = "RSA";

    /**
     * <pre>
     * 根据密钥长度keySize和种子seed生成密钥对
     * </pre>
     *
     * @param keySize 密钥长度
     * @param seed 种子
     * @return KeyPair 密钥对
     */
    public static KeyPair generateKeyPair(int keySize, byte[] seed) {
        if (keySize != DEFAULT_KEY_SIZE) {
            keySize = DEFAULT_KEY_SIZE;
        }

        KeyPair keys = null;

        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance(KEY_GEN_ALGORITHM);
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.setSeed(seed);
            keygen.initialize(keySize, secureRandom);
            keys = keygen.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("生成RSA密钥对失败：找不到RSA算法的密钥生成器！", e);
        }
        return keys;
    }

    /**
     * <pre>
     * 执行RSA签名
     * </pre>
     *
     * @param privateKey    私钥
     * @param source        原始文本
     * @return byte[]       签名
     */
    public static byte[] sign(byte[] privateKey, byte[] source) {
        byte[] signed = null;
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_GEN_ALGORITHM);
            PrivateKey priKey = keyFactory.generatePrivate(priPKCS8);

            // 用私钥对信息生成数字签名
            Signature signer = Signature.getInstance(SIGNATURE_ALGORITHM);
            signer.initSign(priKey);
            signer.update(source);

            // 对信息的数字签名
            signed = signer.sign();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("签名失败：找不到RSA算法的密钥生成器！", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("签名失败：无效的私钥规范！", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("签名失败：私钥无效", e);
        } catch (SignatureException e) {
            throw new RuntimeException("签名失败：signature执行签名失败", e);
        }
        return signed;
    }

    /**
     * <pre>
     * 执行RSA验签
     * </pre>
     *
     * @param publicKey 公钥
     * @param source    原始文本
     * @param signed    签名
     * @return boolean  验签结果
     */
    public static boolean verify(byte[] publicKey, byte[] source, byte[] signed) {
        try {
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_GEN_ALGORITHM);
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

            Signature checker = Signature.getInstance(SIGNATURE_ALGORITHM);
            checker.initVerify(pubKey);
            checker.update(source);

            //验签
            if (checker.verify(signed)) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("验签失败：找不到RSA算法的密钥生成器！", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("验签失败：无效的公钥规范！", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("验签失败：公钥无效", e);
        } catch (SignatureException e) {
            throw new RuntimeException("验签失败：signature执行验签失败", e);
        }
        return false;
    }
}

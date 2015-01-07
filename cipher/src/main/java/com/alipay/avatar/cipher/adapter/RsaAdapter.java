/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.adapter;

import java.security.KeyPair;

import com.alipay.avatar.cipher.algorithm.RSA;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * RSA算法适配器
 * </pre>
 *
 * @author tanghuai
 * @version $Id: RsaAdapter.java, v 0.1 2010-4-1 下午09:18:32 tanghuai Exp $
 */
public class RsaAdapter implements AlgorithmInterface {

    /** 
     * @param key
     * @param txt
     * @return
     * @see com.alipay.avatar.cipher.adapter.AlgorithmInterface#sign(java.lang.String, java.lang.String)
     */
    public String sign(String key, String txt) {
        byte[] signedArray = RSA.sign(Base64.decode(key), txt.getBytes());
        return Base64.encode(signedArray);
    }

    /** 
     * @param key
     * @param txt
     * @param signed
     * @return
     * @see com.alipay.avatar.cipher.adapter.AlgorithmInterface#verify(java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean verify(String key, String txt, String signed) {
        return RSA.verify(Base64.decode(key), txt.getBytes(), Base64.decode(signed));
    }

    /** 
     * @param key
     * @param ciphertext
     * @return
     * @see com.alipay.avatar.cipher.adapter.AlgorithmInterface#decrypt(java.lang.String, java.lang.String)
     */
    public String decrypt(String key, String ciphertext) {
        throw new UnsupportedOperationException();
    }

    /** 
     * @param key
     * @param plaintext
     * @return
     * @see com.alipay.avatar.cipher.adapter.AlgorithmInterface#encrypt(java.lang.String, java.lang.String)
     */
    public String encrypt(String key, String plaintext) {
        throw new UnsupportedOperationException();
    }

    /** 
     * @param keySize
     * @return
     * @see com.alipay.avatar.cipher.adapter.AlgorithmInterface#generateKey(int)
     */
    public String generateKey(int keySize) {
        throw new UnsupportedOperationException();
    }

    /** 
     * @param keySize
     * @param seed
     * @return
     * @see com.alipay.avatar.cipher.adapter.AlgorithmInterface#generateKeyPair(int, java.lang.String)
     */
    public KeyPair generateKeyPair(int keySize, String seed) {
        return RSA.generateKeyPair(keySize, seed.getBytes());
    }
}

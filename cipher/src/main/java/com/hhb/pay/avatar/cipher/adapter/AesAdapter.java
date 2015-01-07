/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher.adapter;

import java.security.KeyPair;

import com.hhb.pay.avatar.cipher.algorithm.AES;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * AES算法适配器
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: AesAdapter.java, v 0.1 2010-4-1 下午09:18:08 haibo.huang Exp $
 */
public class AesAdapter implements AlgorithmInterface {

    /** 
     * @param key
     * @param txt
     * @return
     * @see com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface#sign(java.lang.String, java.lang.String)
     */
    public String sign(String key, String txt) {
        throw new UnsupportedOperationException();
    }

    /** 
     * @param key
     * @param txt
     * @param signed
     * @return
     * @see com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface#verify(java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean verify(String key, String txt, String signed) {
        throw new UnsupportedOperationException();
    }

    /** 
     * @param keySize
     * @return
     * @see com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface#generateKey(int)
     */
    public String generateKey(int keySize) {
        byte[] keyByte = AES.generateKey(keySize);
        return Base64.encode(keyByte);
    }

    /** 
     * @param key
     * @param ciphertext
     * @return
     * @see com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface#decrypt(java.lang.String, java.lang.String)
     */
    public String decrypt(String key, String ciphertext) {
        byte[] keyByte = Base64.decode(key);
        byte[] plaintext = AES.decrypt(keyByte, Base64.decode(ciphertext));
        return new String(plaintext);
    }

    /** 
     * @param key
     * @param plaintext
     * @return
     * @see com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface#encrypt(java.lang.String, java.lang.String)
     */
    public String encrypt(String key, String plaintext) {
        byte[] keyByte = Base64.decode(key);
        byte[] ciphertext = AES.encrypt(keyByte, plaintext.getBytes());
        return Base64.encode(ciphertext);
    }

    /** 
     * @param keySize
     * @param seed
     * @return
     * @see com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface#generateKeyPair(int, java.lang.String)
     */
    public KeyPair generateKeyPair(int keySize, String seed) {
        throw new UnsupportedOperationException();
    }
}

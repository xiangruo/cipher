/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher.adapter;

import com.hhb.pay.avatar.cipher.AlgorithmEnum;
import com.hhb.pay.avatar.cipher.Cryptograph;
import com.hhb.pay.avatar.cipher.key.KeyGenerator;

import junit.framework.TestCase;

/**
 * <pre>
 * AES适配器测试
 * </pre>
 * @author haibo.huang
 * @version $Id: AesAdapterTest.java, v 0.1 2010-4-1 下午09:43:08 haibo.huang Exp $
 */
public class AesAdapterTest extends TestCase {
    
    public void test(){
        AlgorithmEnum algorithm = AlgorithmEnum.AES;        
        String key = KeyGenerator.generateKey(algorithm, 128);
        System.out.println("key : " + key);        
        
        //原始文本
        String sourceMessage = "Testing cipher tool for decrypt & encrypt";
        System.out.println("sourceMessage : " + sourceMessage);
        
        //加密之后的密文
        String cipherMessage = Cryptograph.encrypt(algorithm, key, sourceMessage);
        System.out.println("cipherMessage : " + cipherMessage);
        
        //解密之后的明文
        String plaintMessage = Cryptograph.decrypt(algorithm, key, cipherMessage);
        System.out.println("plaintMessage : " + plaintMessage);
        
        //对比原始文本和解密后的明文
        assertEquals(sourceMessage, plaintMessage);
    }
}

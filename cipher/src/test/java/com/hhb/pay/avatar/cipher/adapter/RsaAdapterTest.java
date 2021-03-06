/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher.adapter;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import junit.framework.TestCase;

import com.hhb.pay.avatar.cipher.AlgorithmEnum;
import com.hhb.pay.avatar.cipher.Certificate;
import com.hhb.pay.avatar.cipher.KeyPairString;
import com.hhb.pay.avatar.cipher.key.KeyGenerator;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * AES适配器测试
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: RsaAdapterTest.java, v 0.1 2010-4-1 下午10:17:41 haibo.huang Exp $
 */
public class RsaAdapterTest extends TestCase {

    public void test() {
        AlgorithmEnum algorithm = AlgorithmEnum.RSA;
        System.out.println(algorithm);
        KeyPair keyPair = KeyGenerator.generateKeyPair(algorithm, 1024, "alipay.com");

        PublicKey pubKey = keyPair.getPublic();
        PrivateKey priKey = keyPair.getPrivate();

        String unsigned = "RSA签名样例演示文本";

        //3.签名
        System.out.println("---------------start test()---------------");
        System.out.println("未签名串内容 ：" + unsigned);
        String signString = Certificate.sign(algorithm, Base64.encode(priKey.getEncoded()),
            unsigned);
        System.out.println("签名并生成文件成功，签名串内容： " + signString);

        //4.验签
        boolean result = Certificate.verify(algorithm, Base64.encode(pubKey.getEncoded()),
            unsigned, signString);
        if (result) {
            System.out.println("签名成功");
        } else {
            System.out.println("验签失败");
            fail();
        }
    }

    public void testWithKeyPairString() {
        AlgorithmEnum algorithm = AlgorithmEnum.RSA;
        KeyPairString keyPairString = KeyGenerator.generateKeyPairString(algorithm, 1024,
            "alipay.com");

        String pubKey = keyPairString.getPublicKey();
        String priKey = keyPairString.getPrivateKey();

        String unsigned = "RSA签名样例演示文本";

        //3.签名
        System.out.println("------start testWithKeyPairString()-------");
        System.out.println("未签名串内容 ：" + unsigned);
        String signString = Certificate.sign(algorithm, priKey, unsigned);
        System.out.println("签名并生成文件成功，签名串内容： " + signString);

        //4.验签
        boolean result = Certificate.verify(algorithm, pubKey, unsigned, signString);
        if (result) {
            System.out.println("签名成功");
        } else {
            System.out.println("验签失败");
            fail();
        }
    }
}

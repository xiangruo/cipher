/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.alipay.avatar.cipher.algorithm;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import junit.framework.TestCase;

import com.hhb.pay.avatar.cipher.algorithm.RSA;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * RSA工具测试
 * </pre>
 *
 * @author 
 * @version $Id: RSATest.java, v 0.1 2010-3-28 下午02:46:57  Exp $
 */
public class RSATest extends TestCase {

    public void test() throws UnsupportedEncodingException {
        //1.生成密钥对
        KeyPair keyPair = RSA.generateKeyPair(1024, "alipay".getBytes());
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey priKey = keyPair.getPrivate();

        //2.设置文本内容&编码格式
        String encode = "ISO-8859-1";
        String unsigned = "RSA签名样例演示文本";

        //3.签名
        System.out.println("未签名串内容 ：" + unsigned);
        byte[] signedArray = RSA.sign(priKey.getEncoded(), unsigned.getBytes(encode));
        String signString = Base64.encode(signedArray);
        System.out.println("签名并生成文件成功，签名串内容： " + signString);

        //4.验签
        if (RSA.verify(pubKey.getEncoded(), unsigned.getBytes(encode), Base64.decode(signString))) {
            System.out.println("签名成功");
        } else {
            System.out.println("验签失败");
            fail();
        }
    }
}

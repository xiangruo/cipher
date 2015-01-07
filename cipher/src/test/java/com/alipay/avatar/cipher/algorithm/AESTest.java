/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.alipay.avatar.cipher.algorithm;

import junit.framework.TestCase;

import com.hhb.pay.avatar.cipher.algorithm.AES;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * AES工具测试
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: RSATest.java, v 0.1 2010-3-28 下午02:46:57 haibo.huang Exp $
 */
public class AESTest extends TestCase {

	public void test() throws Exception {
		byte[] key = AES.generateKey(256);
		String srcString = "使用AES对称加密演示文本";

		System.out.println("明文(加密前) ： " + srcString);
		byte[] ciphertArray = AES.encrypt(key, srcString.getBytes());
		String ciphertTxt = Base64.encode(ciphertArray);
		System.out.println("密文 :" + ciphertTxt);

		byte[] plaintext = AES.decrypt(key, Base64.decode(ciphertTxt));
		String desString = new String(plaintext);
		System.out.println("解密 (解密后):" + desString);
	}
}

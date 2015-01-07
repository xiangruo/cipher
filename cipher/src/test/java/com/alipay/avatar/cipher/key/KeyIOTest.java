/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.key;

import java.io.File;
import java.io.IOException;
import java.security.KeyPair;

import junit.framework.TestCase;

import com.hhb.pay.avatar.cipher.AlgorithmEnum;
import com.hhb.pay.avatar.cipher.Certificate;
import com.hhb.pay.avatar.cipher.key.KeyConvertor;
import com.hhb.pay.avatar.cipher.key.KeyGenerator;
import com.hhb.pay.avatar.cipher.key.KeyIO;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * <pre>
 * 密钥导入导出工具测试
 * </pre>
 * 
 * @author haibo.huang
 * @version $Id: KeyIOTest.java, v 0.1 2010-4-9 下午09:00:03 haibo.huang Exp $
 */
public class KeyIOTest extends TestCase {
	private static final String SEED = "";
	// 字符串密钥文件
	private File privateCer = new File("d:/keyfile/private.cer");
	private File publicCer = new File("d:/keyfile/public.cer");

	// 二进制密钥文件
	private File privateDer = new File("d:/keyfile/private.der");
	private File publicDer = new File("d:/keyfile/public.der");

	/**
	 * @throws java.lang.Exception
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		// 生成密钥字符串
		KeyPair keyPair = KeyGenerator.generateKeyPair(AlgorithmEnum.RSA, 1024,SEED);

		// 写cer文件
		KeyIO.writeKeyString(privateCer,Base64.encode(keyPair.getPrivate().getEncoded()));
		KeyIO.writeKeyString(publicCer,Base64.encode(keyPair.getPublic().getEncoded()));

		// 写der文件
		KeyIO.writeKeyBytes(privateDer, keyPair.getPrivate().getEncoded());
		KeyIO.writeKeyBytes(publicDer, keyPair.getPublic().getEncoded());
	}

	/**
	 * <pre>
	 * 测试字符串密钥文件
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testCerFile() throws IOException {
		String txt = "验签测试样例";

		// 从cer文件读取密钥字符串
		String priKeyString = KeyIO.readKeyString(privateCer);
		String pubKeyString = KeyIO.readKeyString(publicCer);
		// 用字符串密钥做签名&验签
		String signed = Certificate.sign(AlgorithmEnum.RSA, priKeyString, txt);
		System.out.println("字符串密钥加密签名：" + signed);
		assertTrue(Certificate.verify(AlgorithmEnum.RSA, pubKeyString, txt,
				signed));

		// 从der文件读取密钥字符串
		byte[] priKey = KeyIO.readKeyBytes(privateDer);
		byte[] pubKey = KeyIO.readKeyBytes(publicDer);
		// 用二进制密钥做签名&验签
		signed = Certificate.sign(AlgorithmEnum.RSA,
				KeyConvertor.keyBytes2KeyString(priKey), txt);
		System.out.println("二进制密钥加密签名：" + signed);
		assertTrue(Certificate.verify(AlgorithmEnum.RSA,
				KeyConvertor.keyBytes2KeyString(pubKey), txt, signed));
	}

	/**
	 * <pre>
	 * 测试二进制密钥文件
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testDerFile() throws IOException {
		// 从der文件读取密钥字符串
		String txt = "验签测试样例";
		byte[] priKey = KeyIO.readKeyBytes(privateDer);
		byte[] pubKey = KeyIO.readKeyBytes(publicDer);

		// 直接用二进制密钥做签名&验签
		String signed = Certificate.sign(AlgorithmEnum.RSA,
				Base64.encode(priKey), txt);
		assertTrue(Certificate.verify(AlgorithmEnum.RSA, Base64.encode(pubKey),
				txt, signed));

		// 将二进制密钥转换为字符串密钥再验证
		String priKeyString = KeyConvertor.keyBytes2KeyString(priKey);
		String pubKeyString = KeyConvertor.keyBytes2KeyString(pubKey);
		String reductive = Certificate.sign(AlgorithmEnum.RSA, priKeyString,
				txt);
		assertEquals(signed, reductive);// 验证转换的密钥签名保持一致
		assertTrue(Certificate.verify(AlgorithmEnum.RSA, pubKeyString, txt,
				signed));
	}

	/**
	 * <pre>
	 * 测试基金公司提供的二进制文件
	 * </pre>
	 * 
	 * @throws IOException
	 */
	// public void testFundFile() throws IOException {
	// String txt = "";//基金公司提供验证的签名原始串
	// String signed = "";//基金公司提供验证的签名串
	// byte[] keyBytes = KeyIO.readKeyBytes(publicDer);
	// String pubKeyString = KeyConvertor.keyBytes2KeyString(keyBytes);
	// assertTrue(Certificate.verify(AlgorithmEnum.RSA, pubKeyString, txt,
	// signed));
	// }
}

/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher;

import com.hhb.pay.avatar.cipher.AlgorithmEnum;

import junit.framework.TestCase;

/**
 * <pre>
 * 算法枚举测试
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: AlgorithmEnumTest.java, v 0.1 2010-4-2 下午03:52:01 haibo.huang Exp $
 */
public class AlgorithmEnumTest extends TestCase {
    
    public void test(){
        AlgorithmEnum algorithm = AlgorithmEnum.getEnumByCode("RSA");
        assertEquals(algorithm.getCode(), AlgorithmEnum.RSA.getCode());
        assertEquals(algorithm.getMessage(), AlgorithmEnum.RSA.getMessage());
        
        AlgorithmEnum algorithmLower = AlgorithmEnum.getEnumByCode("rsa");
        assertEquals(algorithmLower.getCode(), AlgorithmEnum.RSA.getCode());
        assertEquals(algorithmLower.getMessage(), AlgorithmEnum.RSA.getMessage());
    }
}

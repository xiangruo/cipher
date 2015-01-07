/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher;

import java.util.HashMap;
import java.util.Map;

import com.hhb.pay.avatar.cipher.adapter.AesAdapter;
import com.hhb.pay.avatar.cipher.adapter.AlgorithmInterface;
import com.hhb.pay.avatar.cipher.adapter.RsaAdapter;

/**
 * <pre>
 * 算法容器
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: Container.java, v 0.1 2010-4-1 下午12:16:15 haibo.huang Exp $
 */
public class Container {

    /** 算法容器，放置所有的算法 */
    private static Map<String, AlgorithmInterface> container;

    static {
        container = new HashMap<String, AlgorithmInterface>();
        container.put(AlgorithmEnum.AES.getCode(), new AesAdapter());
        container.put(AlgorithmEnum.RSA.getCode(), new RsaAdapter());
    }

    /**
     * <pre>
     * 获取指定算法
     * </pre>
     *
     * @param algorithmEnum 算法枚举
     * @return AlgorithmInterface 算法统一接口
     */
    public static AlgorithmInterface getAlgorithm(AlgorithmEnum algorithmEnum) {
        return container.get(algorithmEnum.getCode());
    }
}

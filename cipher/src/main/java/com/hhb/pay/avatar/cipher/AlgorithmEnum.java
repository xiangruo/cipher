/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.hhb.pay.avatar.cipher;

/**
 * <pre>
 * 算法枚举
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: AlgorithmEnum.java, v 0.1 2010-4-1 上午11:08:51 haibo.huang Exp $
 */
public enum AlgorithmEnum {
    AES("AES", "aes对称加解密算法"), 
    RSA("RSA", "rsa非对称加解密算法");

    /** 算法代码 */
    private final String code;

    /** 算法描述 */
    private final String message;

    AlgorithmEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * <pre>
     * 根据Code获得enum
     * </pre>
     *
     * @param code 代码值
     * @return 相应的enum，如果为无效的code，返回null
     */
    public static AlgorithmEnum getEnumByCode(String code) {

        if (code == null || code.equals("")) {
            return null;
        }

        for (AlgorithmEnum each : values()) {
            if (code.equalsIgnoreCase(each.code)) {
                return each;
            }
        }
        return null;
    }
}

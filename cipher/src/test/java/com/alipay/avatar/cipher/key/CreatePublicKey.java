/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.key;

import java.io.File;

import com.hhb.pay.avatar.cipher.key.KeyIO;

/**
 *
 * @author haibo.huang
 * @version $Id: CreatePublicKey.java, v 0.1 2010-10-25 下午03:52:30 haibo.huang Exp $
 */
public class CreatePublicKey {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        File publicCer = new File("d:/keyfile/public.cer");
        File privateCer = new File("d:/keyfile/private.cer");
        try {
            KeyIO
                .writeKeyString(
                    publicCer,
                    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/TL9KTlKmWgvkEoD1AvdSKRrJg9k4qD78hrCEGphvvWudAHvnPUCRKVNZABT3lndY2uBjY3Ar+xTW0xemacvQ5J+JeilBrmz90s8UlQb2XHDW5ShZciAdJUmDm++XwBpxPq8PTNwRnY4Hz6uAjxSOz7fMFwX2dxHNmSp1vviCvQIDAQAB");
            KeyIO
                .writeKeyString(
                    privateCer,
                    "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL9Mv0pOUqZaC+QSgPUC91IpGsmD2TioPvyGsIQamG+9a50Ae+c9QJEpU1kAFPeWd1ja4GNjcCv7FNbTF6Zpy9Dkn4l6KUGubP3SzxSVBvZccNblKFlyIB0lSYOb75fAGnE+rw9M3BGdjgfPq4CPFI7Pt8wXBfZ3Ec2ZKnW++IK9AgMBAAECgYBeVnuzKiLKFHfutk1QBnFu3ARwwguaTCYbpFRiITdxS0lJeJaht2wi6e1HY6nzWwlqES489Sm5Fq31Ls5n655tgClmku1gB5+ITR2rnHkgYfA0Uo0Du3H3EBs32YHXogyhKrFXBcqWnQPtEojDyDFWMaj2Y7kNYBL1eT5yT3I9wQJBAONIjrfMNdG113ahLgXcHBiT8OsE4nIhJeV5Z9PB47dorJIu1tPTKYQcZB+KZIz9SCGXNrHcKdaP1WOM+5s+qU0CQQDXeE4wXQHPdYZPdVWurepL+CkWCKRYIr/BALhkFTPPH0ptCJNZjT+E43TCmDUmXksFXESolWnsBCvWT1LiPQcxAkBVmBivXUeTb6DyOyci687k7qoXSCKjippD/mG8nNNOWixLbTpYUbjb2PlX632Mn0JP7Cub9ecHt+lL8Wc8AvAtAkEAz4Dye6z2M16RDDCJZYHjY2oH10pXSvGcDTiuWuP4Uv1lZX+et91JUKbkKQsAFIU2ZmEnVdseeMbDmM4nmez/4QJAeGStmSYHMqxMsipzKHr75CJQnLQ5xTU1m6vRSp2h4nEGzIWQKYcU/Kd2gfwzdK+p6ugmgaBLMuN2vbz9IO7WpQ==");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}

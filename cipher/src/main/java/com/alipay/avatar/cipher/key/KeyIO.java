/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.key;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;

/**
 * <pre>
 * 密钥输入输出工具
 * </pre>
 *
 * @author tanghuai
 * @version $Id: KeyIO.java, v 0.1 2010-4-9 下午05:16:17 tanghuai Exp $
 */
public class KeyIO {

    /**
     * <pre>
     * 从文件中读取密钥字符串
     * </pre>
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String readKeyString(File file) throws IOException {
        InputStream ips = new BufferedInputStream(new FileInputStream(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(ips));
        StringBuffer sb = new StringBuffer("");
        String lineContent = br.readLine();
        while (null != lineContent) {
            sb.append(lineContent);
            sb.append("\r\n");
            lineContent = br.readLine();
        }
        ips.close();
        return new String(sb);
    }

    /**
     * <pre>
     * 将密钥字符串写入文件
     * </pre>
     *
     * @param file
     * @param keyString
     * @throws IOException
     */
    public static void writeKeyString(File file, String keyString) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(file));
        writer.write(keyString);
        writer.flush();
        writer.close();
    }

    /**
     * <pre>
     * 从文件中读取密钥字节数组
     * </pre>
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] readKeyBytes(File file) throws IOException {
        int bufferSize = 1024;
        InputStream input = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        byte[] temp = new byte[bufferSize];
        while (input.read(temp) != -1) {
            output.write(temp);
        }
        byte[] array = output.toByteArray();
        output.close();
        input.close();
        return array;
    }

    /**
     * <pre>
     * 将密钥字节数组写入文件
     * </pre>
     *
     * @param file
     * @param keyBytes
     * @throws IOException
     */
    public static void writeKeyBytes(File file, byte[] keyBytes) throws IOException {
        OutputStream opt = new BufferedOutputStream(new FileOutputStream(file));
        opt.write(keyBytes);
        opt.flush();
        opt.close();
    }
}

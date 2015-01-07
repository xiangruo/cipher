/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.avatar.cipher.util;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

/**
 * <pre>
 * 待签名、待验签字符串构造器
 * </pre>
 *
 * @author tanghuai
 * @version $Id: CipherStringBuilder.java, v 0.1 2010-4-2 下午01:46:25 tanghuai Exp $
 */
public class CipherStringBuilder {

    /**
     * <pre>
     * 对map按指定序列(ASC or DSC)排序并拼接为字符串，例如：key1=value1&key2=value2
     * </pre>
     * 
     * @param map 待签名、验签的键值对
     * @param connector 键值连接符，若传null则使用缺省值“=”
     * @param seperator 键值对分割符，若传null则使用缺省值“&”
     * @param isAscending 是否为升序
     * @return
     */
    public static String sortingMapToStr(Map<String, String> map, String connector,
                                         String seperator, boolean isAscending) {
        if (connector == null) {
            connector = "=";
        }
        if (seperator == null) {
            seperator = "&";
        }

        Map<String, String> sortedMap = sortingMap(map, isAscending);
        Set<Entry<String, String>> orderedEntry = sortedMap.entrySet();
        StringBuffer sbf = new StringBuffer();
        for (Entry<String, String> entry : orderedEntry) {
            sbf.append(entry.getKey());
            sbf.append(connector);
            sbf.append(StringUtils.trimToEmpty(entry.getValue()));
            sbf.append(seperator);
        }
        sbf.deleteCharAt(sbf.length() - 1);
        return sbf.toString();
    }

    /**
     * <pre>
     * 按key值对map进行排序，排序方式由isAscending决定为升序或降序
     * </pre>
     *
     * @param map 待排序map
     * @param isAscending 是否为升序
     * @return 已排序map
     */
    private static Map<String, String> sortingMap(Map<String, String> map, boolean isAscending) {
        TreeMap<String, String> result = null;
        if (isAscending) {
            //升序排列
            result = new TreeMap<String, String>(ASC_ORDER);
        } else {
            //降序排列
            result = new TreeMap<String, String>(DSC_ORDER);
        }
        result.putAll(map);
        return result;
    }

    /** 升序comparator*/
    private static final Comparator<String> ASC_ORDER = new AscendingComparator();
    /** 降序comparator*/
    private static final Comparator<String> DSC_ORDER = new DscendingComparator();

    /**
     * <pre>
     * 升序比较器
     * </pre>
     *
     * @author tanghuai
     * @version $Id: CipherStringBuilder.java, v 0.1 2010-4-7 下午05:41:05 tanghuai Exp $
     */
    private static class AscendingComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
        }
    }

    /**
     * <pre>
     * 降序比较器
     * </pre>
     *
     * @author tanghuai
     * @version $Id: CipherStringBuilder.java, v 0.1 2010-4-7 下午05:41:08 tanghuai Exp $
     */
    private static class DscendingComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            if (String.CASE_INSENSITIVE_ORDER.compare(o1, o2) > 0){
                return -1;
            }
            if (String.CASE_INSENSITIVE_ORDER.compare(o1, o2) < 0){
                return 1;
            }
            return 0;
        }
    }
}
package com.hhb.pay.avatar.cipher.util;

import java.util.HashMap;
import java.util.Map;

import com.hhb.pay.avatar.cipher.util.CipherStringBuilder;

import junit.framework.TestCase;

/**
 * <pre>
 * 签名串构造器单元测试
 * </pre>
 *
 * @author haibo.huang
 * @version $Id: SignStringBuilderTest.java, v 0.1 2010-4-2 下午03:00:35 haibo.huang Exp $
 */
public class CipherStringBuilderTest extends TestCase {

    public void test() {
        Map<String, String> disorderMap = new HashMap<String, String>();
        disorderMap.put("service", "purchase_single");
        disorderMap.put("partner", "2088001159940003");
        disorderMap.put("trade_time", "20100322 17:23:48");
        disorderMap.put("bank_card", null);
        disorderMap.put("_input_charset", "gbk");

        String ascResult = CipherStringBuilder.sortingMapToStr(disorderMap, null, null, true);
        System.out.println(ascResult);
        assertEquals("_input_charset=gbk&bank_card=&partner=2088001159940003&service=purchase_single&trade_time=20100322 17:23:48", ascResult);
        
        String dscResult = CipherStringBuilder.sortingMapToStr(disorderMap, null, null, false);
        System.out.println(dscResult);
        assertEquals("trade_time=20100322 17:23:48&service=purchase_single&partner=2088001159940003&bank_card=&_input_charset=gbk", dscResult);

    }
}

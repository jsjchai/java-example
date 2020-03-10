package com.github.jsjchai.demo.lang;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jsjchai.
 */
public class LangExample {

    /**
     * 校验字符串
     *
     * @param str 字符串
     */
    public void checkString(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        System.out.println(str);
    }

    /**
     * 随机数
     */
    public void random(){

        //随机10位字符串
        String str = RandomStringUtils.random(10);
        System.out.println(str);
    }
}

package com.github.jsjchai.http.jdk;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JdkHttpClientUtilTest {

    @Test
    void get() throws Exception {
        String response = JdkHttpClientUtil.get("https://www.baidu.com/");
        assertNotNull(response);
    }
}
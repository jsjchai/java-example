package com.github.jsjchai.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author jsjchai.
 */
public class FastjsonExample {

    /**
     * java对象转化成json字符串
     * @return json字符串
     */
    public String toJsonString(){
        User user = new User();
        user.setId("10000");
        user.setName("Tom");

        return JSON.toJSONString(user);
    }

    /**
     * JSON字符串转换为Java对象
     * @param jsonString json字符串
     * @return User
     */
    public User getUser(String jsonString){
        return JSON.parseObject(jsonString,User.class);
    }
}

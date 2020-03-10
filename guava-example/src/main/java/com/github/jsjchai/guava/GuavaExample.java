package com.github.jsjchai.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author jsjchai.
 */
public class GuavaExample {

    /**
     * 使用静态方法创建集合对象
     */
    public void newCollections(){
        List<String> list = Lists.newArrayList();
        Map<String,String> map = Maps.newConcurrentMap();
    }

    /**
     * 用逗号拼接集合或数组
     */
    public void joint(){
        Joiner.on(",").skipNulls().join("a","f",null,"b");

        List<Integer> list = Lists.newArrayList(1,100,123);
        Joiner.on(",").join(list);
    }
}

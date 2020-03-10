package com.github.jsjchai.demo.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;

import java.util.List;
import java.util.Map;

/**
 * @author jsjchai.
 */
public class CollectionsExample {

    /**
     * 集合检查
     */
    public void checkCollection(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        list.forEach(System.out::println);
    }

    /**
     * map example
     */
    public void checkMap(Map<String, String> map) {
        if (MapUtils.isEmpty(map)) {
            return;
        }

        //排序
        OrderedMap<String,String> orderMap = new LinkedMap<>();
        map.forEach(orderMap::put);


        orderMap.put("FIVE", "5");
        orderMap.put("SIX", "6");
        orderMap.put("SEVEN", "7");

        orderMap.firstKey();
        orderMap.nextKey("FIVE");
        orderMap.nextKey("SIX");
    }
}

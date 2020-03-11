package com.github.jsjchai;

import java.util.function.Consumer;

/**
 * @author jsjchai.
 */

public class ConsumerExample {


    public static void main(String[] args) {
        // void返回
        Consumer<Integer> consumer = System.out::println;

        consumer.accept(1);
    }
}

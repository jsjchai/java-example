package com.github.jsjchai;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

/**
 * @author jsjchai.
 */
@Getter
@Setter
public class ConsumerExample {

    private String str;


    public static void main( String[] args ) {
        // void返回
        Consumer<Integer> consumer = System.out::println;

        consumer.accept(1);

        Consumer<ConsumerExample> exampleConsumer = System.out::println;
        exampleConsumer.andThen(e -> e.setStr("11111"));

        ConsumerExample example = new ConsumerExample();
        exampleConsumer.accept(example);
    }
}

package com.github.jsjchai;

import java.util.function.Function;

/**
 * @author jsjchai.
 */
public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Double> half = a -> a / 2.0;
        Double result = half.apply(10);
        System.out.println(result);

        half = half.andThen(a -> 3 * a);
        System.out.println(half.apply(10));

        //half = half.andThen(null);

        half = half.compose(a -> 3 * a);
        System.out.println(half.apply(10));

        //half = half.compose(null);

        Function<Integer,Integer> i = Function.identity();
        System.out.println(i);

    }


}

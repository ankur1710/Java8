package com.company.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreams {

    public static void main(String[] args) {

        //sum of n numbers
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        System.out.println(integerList.stream().reduce(0,Math::addExact));
        System.out.println(IntStream.rangeClosed(1,6).reduce(0,Math::addExact));
        System.out.println(IntStream.range(1,6).reduce(0,Math::addExact));
        System.out.println(IntStream.range(1,6).asDoubleStream().sum());
        System.out.println(IntStream.range(1,6).asLongStream().max().getAsLong());
        System.out.println(LongStream.rangeClosed(1,50).average().getAsDouble());

        System.out.println(IntStream.rangeClosed(1,6)
                .boxed() // convert to Integer
                .collect(Collectors.toList()));

        System.out.println(integerList.stream()
                .mapToInt(i -> Integer.valueOf(i)) // unboxing
                .sum());


        System.out.println(IntStream.rangeClosed(1,5)
                .mapToObj(i -> new Integer(i))
                .collect(Collectors.toList())
        );

        System.out.println(IntStream.rangeClosed(1,5)
                .mapToLong(i -> i)
                .max().getAsLong()
        );

        System.out.println(IntStream.rangeClosed(1,5)
                .mapToDouble(i -> i)
                .average().getAsDouble()
        );

    }
}

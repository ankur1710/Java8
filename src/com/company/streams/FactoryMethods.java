package com.company.streams;

import java.util.Random;
import java.util.stream.Stream;

public class FactoryMethods {

    public static void main(String[] args) {
        Stream.of("adam", "dan", "julie").forEach(System.out::println);
        Stream.iterate(1,x -> x*2).limit(10).forEach(System.out::println);
        Stream.generate(() -> new Random().nextInt()).limit(10).forEach(System.out::println);
        Stream.empty().forEach(System.out::println);
    }
}

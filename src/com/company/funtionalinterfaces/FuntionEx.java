package com.company.funtionalinterfaces;

import java.util.function.Function;

public class FuntionEx {

    static Function<String,String> function = (s) -> s.toUpperCase();
    static Function<String,String> function1 = String::toUpperCase;
    static Function<String,String> addString = (s) -> s.concat("default");


    public static void main(String[] args) {
        System.out.println("result of function "+function.apply("java8"));
        System.out.println("result of andThen "+function.andThen(addString).apply("java8"));
        System.out.println("result of Compose "+function.compose(addString).apply("java8"));
    }

}

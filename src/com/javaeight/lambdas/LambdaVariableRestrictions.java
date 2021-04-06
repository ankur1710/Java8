package com.javaeight.lambdas;

import java.util.function.Consumer;

public class LambdaVariableRestrictions {
    static int value = 4;
    public static void main(String[] args) {

        Consumer<Integer> c2 = (i) -> {
            value++;
            System.out.println(value+i);
        };
        c2.accept(4);

        //        int i=0;
//        Consumer<Integer> c1 = (i1) -> {
//            int i=2;
//            System.out.println(i)};

    }
}

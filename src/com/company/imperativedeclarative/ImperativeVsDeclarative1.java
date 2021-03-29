package com.company.imperativedeclarative;

import java.util.stream.IntStream;

/**
 * sum of number from 0 to 100
 */
public class ImperativeVsDeclarative1 {

    //create a sum of 100
    public static void main(String[] args) {
        /**
         * imperative - how style of programming
         */
        int sumI=0;
        for(int i=0;i<=100;i++){
            sumI+=i;
        }
        System.out.println("sum using imperative approach "+sumI);

        /**
         * declarative - what style of prgramming
         */
        int sumD = IntStream.rangeClosed(0,100)
                .parallel() // it splits the values over multiple threads
                .sum();
        System.out.println("sum using Declarative Approach "+sumD);
    }
}

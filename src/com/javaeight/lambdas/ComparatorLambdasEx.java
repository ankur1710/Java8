package com.javaeight.lambdas;

import java.util.Comparator;

public class ComparatorLambdasEx {
    public static void main(String[] args) {

        /**
         * prior Java8
         */
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("compare "+ comparator1.compare(3,2));

        /**
         * Lambda Way
         */
        Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println("compare "+comparator2.compare(2,3));

    }

}

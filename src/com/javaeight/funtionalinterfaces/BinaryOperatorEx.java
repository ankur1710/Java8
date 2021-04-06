package com.javaeight.funtionalinterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorEx {


    static BinaryOperator<Integer> binaryOperator = (i,j) -> j*i;
    static Comparator<Integer> comparator = (i,j) -> i.compareTo(j);
    static BinaryOperator<Integer> binaryOperatorMaxBy = BinaryOperator.maxBy(comparator);
    static BinaryOperator<Integer> binaryOperatorMinBy = BinaryOperator.minBy(comparator);

    public static void main(String[] args) {
        System.out.println(binaryOperator.apply(3,4));
        System.out.println(binaryOperatorMaxBy.apply(13,4));
        System.out.println(binaryOperatorMinBy.apply(13,4));
    }
}

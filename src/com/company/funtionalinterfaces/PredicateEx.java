package com.company.funtionalinterfaces;

import java.util.function.Predicate;

public class PredicateEx {
    static Predicate<Integer> checkEven = (i) -> i%2==0;
    static Predicate<Integer> checkDivBy5 = (i) -> i%5==0;

    static void predicateAndOperation(){
        System.out.println("Predicate and operation : "+ checkEven.and(checkDivBy5).test(10));
        System.out.println("Predicate and operation : "+ checkEven.and(checkDivBy5).test(8));
    }

    static void predicateOrOperation(){
        System.out.println("Predicate Or operation : "+ checkEven.or(checkDivBy5).test(10));
        System.out.println("Predicate Or operation : "+ checkEven.or(checkDivBy5).test(8));
    }

    static void predicateNegateOperation(){
        System.out.println("Predicate Negate operation : "+ checkEven.negate().test(10));
        System.out.println("Predicate Negate operation : "+ checkDivBy5.negate().test(8));
    }

    public static void main(String[] args) {
        System.out.println(checkEven.test(4));
        predicateAndOperation();
        predicateOrOperation();
        predicateNegateOperation();
    }
}

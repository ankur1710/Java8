package com.company.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitSkipEx {

    static Optional<Integer> limit(List<Integer> integerList){
        return integerList.stream()
                .limit(4)
                .reduce(Math::addExact);
    }

    static Optional<Integer> skip(List<Integer> integerList){
        return integerList.stream()
                .skip(4)
                .reduce(Math::addExact);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,100,9,10);
        System.out.println(limit(integerList).get());
        System.out.println(skip(integerList).get());
    }
}

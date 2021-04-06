package com.javaeight.streams;

import java.util.Arrays;
import java.util.List;

public class MinMaxEx {

    static int findMax(List<Integer> integerList){
        return integerList.stream()
                .reduce(Integer::max).get();
    }
    static int findMin(List<Integer> integerList){
        return integerList.stream()
                .reduce(Math::min).get();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,100,9,10);
        System.out.println(findMax(integerList));
        System.out.println(findMin(integerList));
    }
}

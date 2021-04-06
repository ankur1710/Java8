package com.javaeight.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBoxedEx {

    static int sequentialSum(List<Integer> integerList){
        long startTime = System.currentTimeMillis();
        int sum =  integerList.stream().reduce(0,(x,y) -> x+y);
        long endTime = System.currentTimeMillis();
        System.out.println("Duration of sequential  "+(endTime-startTime));
        return sum;
    }

    static int parallelSum(List<Integer> integerList){
        long startTime = System.currentTimeMillis();
        int sum =  integerList.parallelStream().reduce(0,(x,y) -> x+y);
        long endTime = System.currentTimeMillis();
        System.out.println("Duration of Parallel  "+(endTime-startTime));
        return sum;
    }

    public static void main(String[] args) {

        List<Integer> integerList = IntStream.rangeClosed(1,10000)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(sequentialSum(integerList));
        System.out.println(parallelSum(integerList));
    }
}

package com.company.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamEx {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Sequential "+checkPerformance(ParallelStreamEx::getSeqIntStream,50));
        System.out.println("Parallel "+checkPerformance(ParallelStreamEx::getParallelIntStream,50));
    }
    static Integer getSeqIntStream(){
        return IntStream.rangeClosed(1,1000000).sum();
    }
    static Integer getParallelIntStream(){
        return IntStream.rangeClosed(1,1000000).parallel() // this will split the data into multiple parts.
                .sum();
    }

    //this will take the Supplier Function and number of times to execute the function and return the total time taken to execute.
    public static Long checkPerformance(Supplier<Integer> supplier, int numOfTimes){
        Long startTime = System.currentTimeMillis();
        for (int i =0;i<numOfTimes;i++){
            supplier.get();
        }
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}

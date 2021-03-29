package com.company.imperativedeclarative;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * remove the duplicates from the list
 */
public class ImperativeVsDeclarative2 {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,3,4,5,5,6,7,8,8,9,10);
        /**
         * imperative
         */

        List<Integer> uniqueListImperative = new ArrayList<>();
        for(Integer integer : integerList){              // iterate
            if(!uniqueListImperative.contains(integer)){ // check
                uniqueListImperative.add(integer);       // add
            }
        }
        System.out.println(uniqueListImperative);

        /**
         * declarative
         */
        List<Integer> uniqueListDeclarative  = integerList
                .stream()                               // using SQL style
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueListDeclarative);
    }
}

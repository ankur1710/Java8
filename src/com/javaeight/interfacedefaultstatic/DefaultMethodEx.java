package com.javaeight.interfacedefaultstatic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodEx {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Adam","Jenny","Alex","Dan","Mike","Eric");

        //prior java8
        Collections.sort(stringList);
        System.out.println(stringList);

        //Java8
         stringList.sort(Comparator.naturalOrder());
         stringList.sort(Comparator.reverseOrder());
         System.out.println(stringList);
    }
}

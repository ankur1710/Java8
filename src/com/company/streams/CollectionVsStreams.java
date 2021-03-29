package com.company.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionVsStreams {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("ankur");
        names.add("pankaj");
        names.add("ankxy");
        System.out.println(names);
        names.remove(2);
        System.out.println(names);

        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::print);
//        nameStream.forEach(System.out::print);
    }
}

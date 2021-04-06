package com.javaeight.optional;

import java.util.Optional;

public class OptionalOfNullable {

    public static Optional<String> ofNullable1(){
        return Optional.ofNullable("Hello");
    }
    public static Optional<String> ofNullable2(){
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        System.out.println(ofNullable1());
        System.out.println(ofNullable2().isPresent());
    }
}

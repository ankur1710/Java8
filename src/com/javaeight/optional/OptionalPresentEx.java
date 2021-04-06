package com.javaeight.optional;

import java.util.Optional;

public class OptionalPresentEx {

    public static void main(String[] args) {
        //isPresent
        Optional<String> optionalS = Optional.ofNullable("Value");
        System.out.println(optionalS.isPresent());
        Optional<String> optionalSNull = Optional.ofNullable(null);
        System.out.println(optionalSNull.isPresent());

        //ifPreset
        optionalS.ifPresent(s -> System.out.println(s));
        optionalSNull.ifPresent(s -> System.out.println(s));


    }
}

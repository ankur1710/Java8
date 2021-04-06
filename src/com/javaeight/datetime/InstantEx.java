package com.javaeight.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class InstantEx {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("Current Instant "+ instant);
        System.out.println("getNano "+instant.getNano());
        System.out.println("getEpochSecs "+instant.getEpochSecond());

        Instant instant1 = Instant.ofEpochSecond(0);
        System.out.println("Instant.ofEpochSecond(0) "+instant1);
        System.out.println(" " + Instant.ofEpochSecond(999999999));

        Instant instant2 = Instant.now();
        System.out.println(instant.until(instant2 , ChronoUnit.NANOS));
        System.out.println(Duration.between(instant,instant2).getNano());

    }
}

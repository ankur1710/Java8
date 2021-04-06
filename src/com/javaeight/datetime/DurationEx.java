package com.javaeight.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationEx {
    public static void main(String[] args) {
        LocalTime localTime1 = LocalTime.of(7,20,20);
        LocalTime localTime2 = LocalTime.of(7,40,50);
        //Until Method return Long
        System.out.println(localTime1.until(localTime2, ChronoUnit.MINUTES));

        Duration duration1 = Duration.between(localTime1,localTime2);
        System.out.println("toMins "+ duration1.toMinutes());

        Duration duration2 = Duration.ofHours(1);
        System.out.println("toMins from Of "+ duration2.toMinutes());

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.now().plusDays(10);
        Duration diffBetweenDates = Duration.between(localDate1,localDate2); //this will fail in runtime , since it can only work with TIme.

    }
}

package com.javaeight.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeEx {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(LocalTime.now());
        /**Set LocalTime*/
        System.out.println(LocalTime.of(23,23));
        System.out.println(LocalTime.of(23,23,11));
        System.out.println(LocalTime.of(23,23,11,90908));
        /**get value from LocalTIme*/
        System.out.println("getHour " +localTime.getHour());
        System.out.println("getMinute " +localTime.getMinute());
        System.out.println("get CLOCK_HOUR_OF_DAY" +localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println("get Secs " +localTime.toSecondOfDay()); // time in secs
        /**Modify the time*/
        System.out.println("minus Hours "+localTime.minusHours(2));
        System.out.println("minus Hours using temporal "+localTime.minus(2, ChronoUnit.HOURS));
        System.out.println("plus mins "+localTime.plusMinutes(20));
        System.out.println("with Midnight "+localTime.with(LocalTime.MIDNIGHT));
        System.out.println("with Hour "+localTime.withHour(23));
        System.out.println("with Hour of Day "+localTime.with(ChronoField.HOUR_OF_DAY,22));


    }
}

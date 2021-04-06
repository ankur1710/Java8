package com.javaeight.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateEx {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now(); //this is immutable
        System.out.println(localDate);
        /** Set DateTime*/
        System.out.println(LocalDate.of(2018,07,17));
        System.out.println(LocalDate.ofYearDay(2021,365));
        /**get values from LocalDate*/
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getChronology());
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println(localDate.get(ChronoField.ERA));
        /** modify the date*/
        System.out.println(localDate.plusDays(2)); //increment date by 2
        System.out.println(localDate.plusMonths(2)); //increment month by 2
        System.out.println(localDate.minusMonths(2)); //decrease month by 2
        System.out.println(localDate.withYear(2020));
        System.out.println(localDate.with(ChronoField.YEAR,2022));
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth())); //temporal adjusters
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.println(localDate.minus(1, ChronoUnit.DAYS)); //minus using field and Value
        /**Additional Support methods*/
        System.out.println(localDate.isLeapYear());
        System.out.println(LocalDate.ofYearDay(2020,77).isLeapYear());
        ChronoLocalDate localDate1 = LocalDate.of(2021,04,02);
        System.out.println(localDate1.isEqual(localDate));
        ChronoLocalDate localDateBefore = LocalDate.of(2021,04,01);
        System.out.println(localDateBefore.isBefore(localDate));
        ChronoLocalDate localDateAfter = LocalDate.of(2021,06,01);
        System.out.println(localDateAfter.isAfter(localDate));
        /**Unsupported */
//        System.out.println(localDate.minus(1,ChronoUnit.MINUTES)); // we can only change the Date , Month and Year here
        System.out.println("issupported "+localDate.isSupported(ChronoUnit.MINUTES));
        System.out.println("issupported "+localDate.isSupported(ChronoUnit.MONTHS));




        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}

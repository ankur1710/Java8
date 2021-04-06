package com.javaeight.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeEx {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        /**create local date time instance*/
        LocalDateTime localDateTime = LocalDateTime.of(2020,03,11,21,23,22,987);
        System.out.println("LocalDateTime :" +localDateTime);
        System.out.println("Using LocalDate and LocalTime Instance "+LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        /**getting the time and date from the localDate time Instance*/
        System.out.println("Hour "+ localDateTime.getHour());
        System.out.println("Month "+ localDateTime.getDayOfMonth());
        System.out.println("Sec "+ localDateTime.getSecond());
        System.out.println("Date of the Month" + localDateTime.get(ChronoField.DAY_OF_MONTH));
        /**Modifying LocalDateTime*/
        System.out.println("Add 2days "+ localDateTime.plusDays(2));
        System.out.println("Minus 3Hours "+ localDateTime.minusHours(3));
        System.out.println("With Month "+ localDateTime.withMonth(12));
        /**Converting LocalDate to LocalDateTime and Vice Versa*/
        LocalDate localDate = LocalDate.of(2019,01,10);
        System.out.println(localDate.atTime(23,33,11,987));
        LocalTime localTime = LocalTime.of(23,59,59);
        System.out.println(localTime.atDate(localDate));
        /**get LocalDate AndLocalTime from LocalDatetime*/
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());

    }
}

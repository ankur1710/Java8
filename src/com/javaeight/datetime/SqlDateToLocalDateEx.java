package com.javaeight.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class SqlDateToLocalDateEx {
    public static void main(String[] args) {
        /** java.util.date to LocalDate*/
        Date date = new Date();
        System.out.println(date);
        LocalDate localDate= date.toInstant() //this was introduced in java8
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        System.out.println("LocalDate from date "+localDate);

        //reverse
        Date newDate = Date.from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());// introduced in java8
        System.out.println("date from LocalDateTime "+ newDate);

        /**Java.sql.date to localDate*/
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(localDate); // introduced in java8
        System.out.println("SqlDate from LocalDate "+sqlDate1);

        //reverse
        LocalDate localDateSql = sqlDate1.toLocalDate(); // introduced in java8
        System.out.println("LocalDate from SqlDate "+localDateSql);
    }
}

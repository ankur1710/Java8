package com.javaeight.datetime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodEx {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2019,01,01);
        LocalDate date2 = LocalDate.of(2020,12,31);
        Period period = date1.until(date2);
        System.out.println(period.getDays()); //30days it only checks the dates and not the months
        System.out.println(period.getMonths());
        System.out.println(period.getYears());

        System.out.println(Period.ofDays(10).getDays());
        System.out.println(Period.ofYears(1).toTotalMonths());
        System.out.println("Compare two Different Dates "+ Period.between(date1,date2));
        //this only works with LocalDate not with LocalTime and LocalDateTime.


    }

}

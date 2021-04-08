package com.javaeight.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatEx {

    public static void parseLocalDate(){
        String date = "2020-04-22";
        LocalDate localDate = LocalDate.parse(date); // this uses ISO-Local_date by default
        System.out.println("localDate parse default "+localDate);

        LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("LocalDate with DTF "+localDate1);

        String date1 = "20200202"; //yyyymmdd
        System.out.println("Basic DTF "+LocalDate.parse(date1,DateTimeFormatter.BASIC_ISO_DATE));

        //Custom Defined Date Format
        String customDate1 = "2018|04|28"; // there is no Constant so we need to build our
        System.out.println("Custom DTF pipe | "+LocalDate.parse(customDate1,DateTimeFormatter.ofPattern("yyyy|MM|dd")));

        String customDate2 = "2018*04*28"; // there is no Constant so we need to build our
        System.out.println("Custom DTF star * "+LocalDate.parse(customDate2,DateTimeFormatter.ofPattern("yyyy*MM*dd")));

    }


    public static void formatLocalDate(){
        LocalDate localDate = LocalDate.now();
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("yyyy*MM*dd"));
        System.out.println("Formated Date "+formattedDate);

    }

    public static void main(String[] args) {
        parseLocalDate();
        formatLocalDate();
    }
}

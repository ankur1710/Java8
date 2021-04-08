package com.javaeight.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatEx {
    public static void parse(){
        String localDateTimeString = "2021-01-12T12:33:22";
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeString);
        System.out.println("localDateTime "+localDateTime);
        System.out.println("LocalDateTimeDTF "+LocalDateTime.parse(localDateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        //Custom
        String customDateTime1 = "2021-01-12T12|33|22";
        System.out.println("custom pipe "+LocalDateTime.parse(customDateTime1,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss")));
        String customDateTime2 = "2021-04-12abc12|43|22";
        System.out.println("custom pipe "+LocalDateTime.parse(customDateTime2,DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss")));
    }

    public static void format(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedString = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss")) ;
        System.out.println("formatted LocalDateTime "+ formattedString);
    }


    public static void main(String[] args) {
    parse();
    format();
    }
}

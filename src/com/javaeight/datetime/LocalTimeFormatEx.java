package com.javaeight.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeFormatEx {

    public static void parseTime(){
        String time = "09:00";
        LocalTime localTime = LocalTime.parse(time);
        LocalTime localTimeDTF = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("LocalTime parse "+localTime);
        System.out.println("LocalTime parseDTF "+localTimeDTF);
        //custom Format
        String timeStar = "19*00";
        System.out.println("LocalTIme Custom "+LocalTime.parse(timeStar,DateTimeFormatter.ofPattern("HH*mm")));
//        System.out.println("LocalTIme Custom "+LocalTime.parse(timeStar,DateTimeFormatter.ofPattern("hh*mm"))); //this will only take 1-12hrs

        String timePipe = "10|00|22";
        System.out.println("LocalTime Hash "+ LocalTime.parse(timePipe,DateTimeFormatter.ofPattern("HH|mm|ss")));
    }


    public static void formatTime(){
        LocalTime localTime = LocalTime.now();
        System.out.println("formatted time String "+localTime.format(DateTimeFormatter.ofPattern("HH|mm|ss")));
    }


    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}

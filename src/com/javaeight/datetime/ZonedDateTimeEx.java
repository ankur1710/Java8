package com.javaeight.datetime;

import java.time.*;

public class ZonedDateTimeEx {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println("ZonedDate And Time "+ zonedDateTime1);
        System.out.println("Zoned Offset "+zonedDateTime1.getOffset()); //localZone from UTC
        System.out.println("Zoned Id "+zonedDateTime1.getZone());

        //Check the valid ZoneIds
        System.out.println(ZoneId.getAvailableZoneIds().stream()
                .count());
                ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
        //time in different zones
        System.out.println("Chicago  "+ ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("LA PST  "+ ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));

        //using Clock
        System.out.println("Using CLock " +ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Kolkata"))));

        //Create LocalDateTime using zoneId
        System.out.println("LocalDateTime zoneId"+ LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        System.out.println("LocalDateTime Clock"+ LocalDateTime.now(Clock.system(ZoneId.of("America/Toronto"))));

        System.out.println(LocalDateTime.ofInstant(Instant.now(),ZoneId.of("America/Denver")));

        //Convert LocalDateTime to ZonedLocalDateTime.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.atZone(ZoneId.of("Europe/London")));
        System.out.println(localDateTime.atOffset(ZoneOffset.ofHours(+1)));

    }
}

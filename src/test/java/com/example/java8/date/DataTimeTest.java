package com.example.java8.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataTimeTest  {

    @Test
    public void 이전_방식() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
    }

    @Test
    public void 자바8_방식() {
        // for Machine
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC ,GMT

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println("zonedDateTime = " + zonedDateTime);
        // for human
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("now = " + now);

        LocalDate now1 = LocalDate.now();

        LocalDate of = LocalDate.of(2022, Month.JULY, 8);

        Period period = Period.between(now1, of);
        System.out.println("period = " + period.getDays());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(formatter));

    }

}

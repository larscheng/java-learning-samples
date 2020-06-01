package com.larscheng.www.part01LocalDateTime;

import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {

    @Test
    public void LocalDateTimeTest(){
        System.out.println("当前时间："+LocalDateTime.now());
        System.out.println("指定时间："+LocalDateTime.of(2020, 5, 10, 12, 12,12,12));
        //时间加减
        System.out.println("3天后的现在："+LocalDateTime.now().plusDays(3));
        System.out.println("3个月前的现在："+LocalDateTime.now().minusMonths(3));

        //年月日时分秒获取
        System.out.print(LocalDateTime.now().getYear()+"y,");
        //getMonth时英文月份名称
        System.out.print(LocalDateTime.now().getMonthValue()+"M,");
        System.out.print(LocalDateTime.now().getDayOfMonth()+"d,");
        System.out.print(LocalDateTime.now().getHour()+"h,");
        System.out.print(LocalDateTime.now().getMinute()+"m,");
        System.out.println(LocalDateTime.now().getSecond()+"s,");
    }

    @Test
    public void InstantTest(){
        /*
        1970-1-1 00:00:00到某个时间的毫秒值：时间戳
         */


        //获取utc时区时间
        Instant now = Instant.now();
        //utc时区时间
        System.out.println(now);
        //时间戳打印
        System.out.println(now.toEpochMilli());

        //+8小时
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }


    @SneakyThrows
    @Test
    public void  DurationTest(){
        /*
        Duration：计算两个时间之间的间隔
        Period: 计算两个日期之间的间隔  LocalDate
         */
        Instant now = Instant.now();
        Thread.sleep(1000);
        Instant now2 = Instant.now();
        Duration between = Duration.between(now, now2);
        System.out.println(between);
        System.out.println(between.toMillis()+"ms");
        System.out.println(between.getSeconds()+"s");


        LocalDateTime l1 = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime l2 = LocalDateTime.now();
        Duration between1 = Duration.between(l1, l2);
        System.out.println(between1);


        LocalDate ll1 = LocalDate.of(2020, 1, 2);
        LocalDate ll2 = LocalDate.now();
        Period between2 = Period.between(ll1, ll2);
        System.out.println(between2);
        System.out.println(between2.getDays());
    }


    @Test
    public void TemporalAdjuster(){
        /*
        TemporalAdjuster 时间矫正器
         */

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);
        //最后一天
        LocalDateTime with = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with);
    }


    @Test
    public void DateTimeForMatterTest(){
        /*
        格式化时间日期
         */


        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);

        //LocalDateTime--->格式化字符串
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd号 HH:mm:ss");
        String format1 = dateTimeFormatter1.format(localDateTime);
        System.out.println(format1);

        //字符串--->LocalDateTime
        TemporalAccessor parse = dateTimeFormatter1.parse(format1);
        System.out.println(parse);
        LocalDateTime parse1 = LocalDateTime.parse(format1,dateTimeFormatter1);
        System.out.println(parse1);
    }


    @Test
    public void ZoneTest(){
        /*
        ZonedDate
        ZonedTime
        ZonedDateTime
         */
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
//        availableZoneIds.forEach(System.out::println);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Africa/Nairobi"));
        System.out.println(now);
        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("Africa/Nairobi"));
        System.out.println(zonedDateTime);
    }
}

package com.larscheng.www.part08zone;

import org.junit.Test;

import java.time.*;

public class ZoneTest {
    @Test
    public void demo1() {
        int a = 30-40;
        System.out.println(a);
    }

    /**
     * ZoneOffset 与格林威治/ UTC的时区固定偏移量，如+02:00 。偏移范围限制在-18：00至18:00（含）。
     * ZoneId 一个时区ID，如Europe/Paris 。 ZoneId是在Instant和LocalDateTime之间转换的识别规则
     */


    @Test
    public void testZoneOffSet() {
        System.out.println(ZoneOffset.ofHours(3));
        System.out.println(ZoneOffset.ofHoursMinutesSeconds(1, 2, 3));
        System.out.println(ZoneOffset.of("+01:00"));
        System.out.println(ZoneOffset.systemDefault());
    }

    @Test
    public void testZoneId() {
//        System.out.println(ZoneId.getAvailableZoneIds());
        //获取系统默认时区
        System.out.println(ZoneId.systemDefault());
        //4种常用方式创建ZoneId
        System.out.println(ZoneId.of("+01:00"));
        System.out.println(ZoneId.of("UTC+01:00"));
        System.out.println(ZoneId.of("America/Chicago"));
        System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.of("+01:00")));
    }

    @Test
    public void timeTest() {
        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDateTime.now(ZoneId.of("UTC")));
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")));
        System.out.println(ZonedDateTime.now(ZoneId.of("+00:00")));
    }

    @Test
    public void zoneTest() {
        // 指定区域，构造时间: 法国巴黎时间的当前时间，五月有DST，偏移量+2
        LocalDateTime now = LocalDateTime.of(LocalDate.of(2020, 5, 31), LocalTime.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(now, ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime.getOffset().getRules());

        // 手动调整的二月份，此时没有DST，偏移量是+1
        ZonedDateTime thirdMonth = zonedDateTime.minusMonths(3);
        System.out.println(thirdMonth.getOffset().getRules());
    }


    @Test
    public void ZoneDateTimeTest() {
        //默认系统时区
        System.out.println(ZonedDateTime.now());
        //指定一个时区的时间
        System.out.println(ZonedDateTime.now(Clock.system(ZoneId.of("Europe/Paris"))));
        //指定一个偏移量的时间
        System.out.println(ZonedDateTime.now(Clock.system(ZoneOffset.of("+04:00"))));
        //根据本地日期时间和系统时区组合日期时间
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
        //根据年月日时分秒毫秒纳秒时区id构建
        System.out.println(ZonedDateTime.of(2020, 1, 1, 1, 1, 1, 111, ZoneId.of("Europe/Paris")));
        //UTC时间与时区组合的时间
        System.out.println(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris")));
        //本地日期时间与偏移量组合并设置时区，偏移量(+01:00)与实际时区(+02:00)可不一致，首选偏移量
        System.out.println(ZonedDateTime.ofInstant(LocalDateTime.now(), ZoneOffset.of("+01:00"), ZoneId.of("Europe/Paris")));
        //本地日期时间与偏移量组合并设置时区，偏移量与实际时区必须一致，否则抛出异常
        System.out.println(ZonedDateTime.ofStrict(LocalDateTime.now(), ZoneOffset.of("+02:00"), ZoneId.of("Europe/Paris")));
        System.out.println(ZonedDateTime.ofLocal(LocalDateTime.now(), ZoneId.of("Europe/Paris"), null));



    }

    @Test
    public void ZoneDateTimeDemo() {

        ZonedDateTime z = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());

        System.out.println(z.getZone());//获取时区信息
        System.out.println(z.getOffset());//获取时间偏移量
        System.out.println(z.getDayOfMonth());//获取当月第几天
        System.out.println(z.getDayOfWeek());//获取本周第几天
        System.out.println(z.getDayOfYear());//获取本年第几天
        //获取时间信息
        System.out.println(z.getYear()+"/"+z.getMonthValue()+"/"+z.getDayOfMonth()+" "+
                z.getHour()+":"+z.getMinute()+":"+z.getSecond()+"."+z.getNano());
        //加减时间
        System.out.println(z.plusHours(3));
        System.out.println(z.minusHours(3));
        //修改时间
        System.out.println(z.withHour(20));
    }

    @Test
    public void ZoneDateTimeDemo2() {
        //2020-06-01T12:00:00.00Z  UTC时间转换为-巴黎时间
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZoneOffset zoneOffset = ZoneOffset.of("+02:00");
        ZonedDateTime now = ZonedDateTime.now().withMonth(6);
        System.out.println("6月的此时北京时间:"+now);
        System.out.println("6月的此时巴黎时间:"+now.withZoneSameInstant(zoneId));
        ZonedDateTime newTime = now.withMonth(3);
        System.out.println("3月的此时北京时间:"+newTime);
        System.out.println("3月的此时巴黎时间:"+newTime.withZoneSameInstant(zoneId));
//
//        System.out.println(ZonedDateTime.ofInstant(Instant.parse("2020-06-01T12:00:00.00Z"), ZoneId.of("Europe/Paris")));
//        System.out.println(ZonedDateTime.ofInstant(Instant.parse("2020-12-01T12:00:00.00Z"), ZoneId.of("Europe/Paris")));

    }
    @Test
    public void offSetTest() {
        System.out.println(OffsetTime.now());
        System.out.println(OffsetTime.now(Clock.systemUTC()));
        System.out.println(OffsetTime.now(ZoneId.of("+01:00")));
        OffsetDateTime now = OffsetDateTime.now();
    }
}

package com.larscheng.www.part02localdate;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {

    @Test
    public void create(){
        /*now()*/
        System.out.println(LocalDate.now());//获取当前日期
        System.out.println(LocalDate.now(ZoneId.systemDefault()));//获取系统时区当前日期
//        System.out.println(LocalDate.now(ZoneId.of("Pacific/Guadalcanal")));//获取指定时区当前日期
        System.out.println(LocalDate.now(Clock.systemDefaultZone()));//获取系统时钟当前日期
        /*of()*/
        System.out.println(LocalDate.of(2020, 6, 6));//获取指定年月日日期
        System.out.println(LocalDate.of(2020, Month.JUNE, 6));//获取指定年月日日期
        System.out.println(LocalDate.ofEpochDay(10));//获取大于1970-1-1多少天的日期
        System.out.println(LocalDate.ofYearDay(2020, 200));//获取指定年份中的第几天的日期
        /*parse()*/
        System.out.println(LocalDate.parse("2017-05-05"));//DateTimeFormatter.ISO_LOCAL_DATE
        System.out.println(LocalDate.parse("2017-05-05", DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.parse("20170505", DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDate.parse("2017-05-05+01:00", DateTimeFormatter.ISO_OFFSET_DATE));
        /*from()*/
        LocalDate.from(LocalDate.parse("2017-05-05"));//将TemporalAccessor类型对象转换为LcoalDate日期
    }


    @Test
    public void get(){
        System.currentTimeMillis();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());//获取年
        System.out.println(localDate.getMonthValue());//月
        System.out.println(localDate.getDayOfMonth());//日
        System.out.println(localDate.getMonth());//月份
        System.out.println(localDate.getDayOfWeek());//星期
        System.out.println(localDate.getDayOfYear());//本年中的第几天
        System.out.println("是否闰年："+localDate.isLeapYear());
        System.out.println("本月天数："+localDate.lengthOfMonth());
        System.out.println("本年天数："+localDate.lengthOfYear());
    }

    @Test
    public void operate(){
        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期："+localDate);
        System.out.println("3天后："+localDate.plusDays(3));
        System.out.println("1月后："+localDate.plusMonths(1));
        System.out.println("1年后："+localDate.plusYears(1));
        System.out.println("1周后："+localDate.plusWeeks(1));
        System.out.println("3天前："+localDate.minusDays(3));
        System.out.println("1月前："+localDate.minusMonths(1));
        System.out.println("1年前："+localDate.minusYears(1));
        System.out.println("1周前："+localDate.minusWeeks(1));

        System.out.println(localDate.withYear(2012));//指定某一年的今天
        System.out.println(localDate.withMonth(12));//指定某月的今天
        System.out.println(localDate.withDayOfMonth(1));//指定本月的第几天
        System.out.println(localDate.withDayOfYear(1));//指定今年的第几天
    }
}

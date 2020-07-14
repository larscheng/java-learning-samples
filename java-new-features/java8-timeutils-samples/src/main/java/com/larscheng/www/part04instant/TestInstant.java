package com.larscheng.www.part04instant;

import org.junit.Test;

import java.time.*;

public class TestInstant {



    @Test
    public void TestInstant(){


        //UTC
        System.out.println(Instant.now());
        //系统时区
        System.out.println(Instant.now(Clock.systemDefaultZone()));
        //根据时间字符串转换为Instant实例
        System.out.println(Instant.parse("2020-06-06T12:12:12Z"));
        Instant instant =Instant.parse("2020-06-06T12:12:12Z");
        long milli = instant.toEpochMilli();
        long second = instant.getEpochSecond();
        //给定时间戳转换为Instant实例
        System.out.println(Instant.ofEpochMilli(milli));
        //给定时间戳转换为Instant实例
        System.out.println(Instant.ofEpochSecond(second));
        //给定时间戳和纳秒值转换为Instant实例
        System.out.println(Instant.ofEpochSecond(second, 111));

    }

    @Test
    public void Test1(){
        ZoneId of = ZoneId.of("Africa/Tunis");
        System.out.println(Clock.system(of).instant());
        System.out.println(Clock.system(of).getZone());
        System.out.println(Clock.system(of).instant().atZone(of));
        System.out.println(Clock.systemDefaultZone().instant());
        System.out.println(Clock.systemDefaultZone().getZone());
        System.out.println(Clock.systemDefaultZone().instant().atZone(Clock.systemDefaultZone().getZone()));
    }
}

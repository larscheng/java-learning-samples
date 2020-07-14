package com.larscheng.www.part03clock;

import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class TestClock {
    @Test
    public void clock(){
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
        System.out.println(clock.instant().toEpochMilli());
    }


    @Test
    public void tick() throws InterruptedException {
        //系统默认时区时钟
        Clock clock = Clock.systemDefaultZone();
        //滴答时间间隔为3秒的时钟
        //当实际时间数据是 0 或 1、2秒时，从它那里得到的读数都是 0 秒。当实际时间数据是 3或 4、5秒时，从它那里得到的读数都是 3 秒。
        Clock tick = Clock.tick(clock, Duration.ofSeconds(3));

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(clock.instant()+"---> "+tick.instant());
        }
    }

    @Test
    public void tickSecondsAndMinutes() throws InterruptedException {
        //系统默认时区时钟
        Clock clock = Clock.systemDefaultZone();
//        System.out.println(clock.millis());
//        System.out.println(clock.instant());
//        System.out.println(clock.getZone());
        //获取滴答间隔为1秒的钟表
        Clock clock1 = Clock.tickSeconds(ZoneId.systemDefault());
        System.out.println(clock1.millis());
        System.out.println(clock1.instant());
        System.out.println(clock1.getZone());

        //获取滴答间隔为1分钟的钟表
        Clock clock2 = Clock.tickMinutes(ZoneId.systemDefault());
        System.out.println(clock2.millis());
        System.out.println(clock2.instant());
        System.out.println(clock2.getZone());

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(clock.instant()+"---> "+clock1.instant()+"---> "+clock2.instant());
        }
    }

}

package com.larscheng.www.part05duration;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 *
 * Duration用秒或者纳秒相结合来表示一个时间量，最高精度为纳秒
 *  通常用作表示两个时间之间的间隔,也称作持续时间，例如1s持续时间表示为 PT1S
 *
 *
 *
 *
 */
public class TestDuration {

    @Test
    public void DurationTest1(){


        System.out.println(Duration.ofNanos(1000));
        System.out.println(Duration.ofMillis(1000));
        System.out.println(Duration.ofSeconds(30));
        System.out.println(Duration.ofSeconds(30,12345));
        System.out.println(Duration.ofMinutes(1));
        System.out.println(Duration.ofHours(1));
        System.out.println(Duration.ofDays(1));
        System.out.println(Duration.of(1000, ChronoUnit.MILLIS));
        System.out.println(Duration.from(ChronoUnit.MINUTES.getDuration()));
        System.out.println(Duration.parse("PT20.345S"));
        System.out.println(Duration.between(Instant.parse("2020-06-23T10:15:30.00Z"), Instant.now()));
    }


    @Test
    public void DurationTest2(){

        Duration d = Duration.parse("PT20.345S");

        System.out.println(d.getSeconds());
        System.out.println(d.getNano());

        System.out.println(d.withNanos(3456789));//修改纳秒值，返回一个新的Duration
        System.out.println(d.withSeconds(22));//修改秒值，返回一个新的Duration

        System.out.println(d.plusNanos(1));//加1纳秒，返回一个新的Duration
        System.out.println(d.plusMillis(100));//加100毫秒，返回一个新的Duration
        System.out.println(d.plusSeconds(1));
        System.out.println(d.minusNanos(1));//减去1纳秒，返回一个新的Duration
        System.out.println(d.minusMillis(100));//减去10毫秒，返回一个新的Duration
        System.out.println(d.minusSeconds(1));

        System.out.println(d.isZero());//是否为0
        System.out.println(Duration.ZERO.isZero());//是否为0
        System.out.println(d.isNegative());//是否为负
        System.out.println(d.negated());//求负
        System.out.println(d.negated().abs());//求绝对值

    }
    @Test
    public void DurationTest3(){
        Duration d = Duration.parse("PT20.345S");
        System.out.println(d.toNanos());
        System.out.println(d.toMillis());



    }
}

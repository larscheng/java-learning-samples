package com.larscheng.www.part06period;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 与Duration类似都是用来表示持续时间
 * 但是Period是由年月日为单位的时间量，例如1年2个月3天
 */
public class PeriodTest {
    @Test
    public void test1(){
        System.out.println(Period.of(1, 2, 3));//根据年月日构造Period
        System.out.println(Period.ofDays(1));
        System.out.println(Period.ofMonths(2));
        System.out.println(Period.ofWeeks(3));//根据周数构造
        System.out.println(Period.ofYears(1));
        System.out.println(Period.from(Period.ofMonths(1)));
        System.out.println(Period.parse("P20Y10M5D"));//根据ISO-8601时间格式字符串进行构造
        //计算两个日期对象之间的持续时间
        System.out.println(Period.between(LocalDate.now().minusYears(1).minusDays(1),LocalDate.now() ));
    }

    @Test
    public void test2(){
        Period p = Period.of(1, 2, 3);
        //获取年月日
        System.out.println(p.getYears()+"年"+p.getMonths()+"月"+p.getDays()+"日");
        //重设Period的年月日
        System.out.println(p.withYears(3).withMonths(2).withDays(1));
        //加上1天
        System.out.println(p.plusDays(1));
        //减去1天
        System.out.println(p.minusDays(1));
        //判断是否为0
        System.out.println(p.isZero());
        //判断是否为负
        System.out.println(p.isNegative());
        //取负
        System.out.println(p.negated());
    }


    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.forEach(a->{
            if ("2".equals(a)){
                list.remove(a);
            }
        });

        System.out.println(Arrays.toString(list.toArray()));
    }
}

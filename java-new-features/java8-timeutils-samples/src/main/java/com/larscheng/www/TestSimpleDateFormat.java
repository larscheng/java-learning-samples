package com.larscheng.www;


import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * SimpleDateFormat存在线程安全问题
 *
 * 用threadLocal解决
 */
public class TestSimpleDateFormat {

    /**
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue
     */
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(
            10,
            10,
            3,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());


    @Test
    public void sdfError(){
        /*普通SimpleDateFormat转换，存在线程安全问题*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> callable = () -> sdf.parse("20200601");
        demo(callable);

    }

    @Test
    public void threadLocalSdf(){
        /*用threadLocal解决多线程sdf的问题，保证每个线程的转换资源唯一*/
        Callable<Date> callable = () -> ThreadLocalData.parse("20200602");
        demo(callable);
    }


    @Test
    public void java8DateApi(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> callable = ()-> LocalDate.parse("20200530",dateTimeFormatter);
        List<Future<LocalDate>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(pool.submit(callable));
        }
        pool.shutdownNow();
        futures.forEach(a -> {
            try {
                System.out.println(a.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }



    public static void demo(Callable<Date> callable) {
        List<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(callable));
        }
        pool.shutdownNow();
        futures.forEach(a -> {
            try {
                System.out.println(a.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    /***
     * ThreadLocal转换工具
     */
    public static class  ThreadLocalData{
        private static final ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));
        public static Date  parse(String date) throws ParseException {
            Date parse = threadLocal.get().parse(date);
            threadLocal.remove();
            return parse;
        }
    }
}


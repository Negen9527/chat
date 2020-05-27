package com.negen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：Negen
 * @Date ：Created in 14:05 2020/5/22
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class TestAutoBoxing {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        LongSum();
        longSum();
    }
    public static void LongSum() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("cost time:" + cost);
        System.out.println("Long result:" + sum);
    }

    public static void longSum() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("cost time:" + cost);
        System.out.println("long result:" + sum);
    }
}

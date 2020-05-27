package com.negen.test;

/**
 * @author ：Negen
 * @Date ：Created in 10:49 2020/5/22
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class TestAutoBoxing implements ITestAutoBoxing{
    @Override
    public void LongSum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        System.out.println("Long result:" + sum);
    }

    @Override
    public void longSum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        System.out.println("long result:" + sum);
    }

}

package com.negen.singleton;

/**
 * @author ：Negen
 * @Date ：Created in 16:31 2020/5/23
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class TestDoubleCheckLock implements Runnable{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            TestDoubleCheckLock testDoubleCheckLock = new TestDoubleCheckLock();
            new Thread(testDoubleCheckLock).start();

        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "----" + SingletonDoubleCheckLock.getInstance().toString());
    }
}

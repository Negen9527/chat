package com.negen.depositandtake;

/**
 * @author ：Negen
 * @Date ：Created in 15:52 2020/5/25
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class DepositAndTake {
    static int total = 500;
    private volatile static DepositAndTake instance;
    synchronized void desposit(){
        total = total + 1;
        System.out.println(Thread.currentThread().getName());
        System.out.println(String.format("存入%d,剩余%d",1, total));
    }

    synchronized void take(){
        total = total - 1;
        System.err.println(Thread.currentThread().getName());
        System.err.println(String.format("取出%d,剩余%d",1, total));
    }

    public static DepositAndTake getInstance(){
        if (null == instance){
            synchronized (DepositAndTake.class){
                if (null == instance){
                    instance = new DepositAndTake();
                }
            }
        }
        return instance;
    }
}

package com.negen.depositandtake;

/**
 * @author ：Negen
 * @Date ：Created in 17:00 2020/5/25
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class TakeThread implements Runnable {
    @Override
    public void run() {
        DepositAndTake.getInstance().take();
    }
}

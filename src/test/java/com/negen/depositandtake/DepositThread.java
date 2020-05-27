package com.negen.depositandtake;

/**
 * @author ：Negen
 * @Date ：Created in 16:34 2020/5/25
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class DepositThread implements Runnable {
    @Override
    public void run() {
        DepositAndTake.getInstance().desposit();
    }
}

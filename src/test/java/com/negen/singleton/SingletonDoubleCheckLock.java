package com.negen.singleton;

/**
 *  双重检查模式
 *
 *  第一次：避免不必要的上锁
 *  第二次：例行检查
 * @author ：Negen
 * @Date ：Created in 16:28 2020/5/23
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class SingletonDoubleCheckLock {
    private volatile static SingletonDoubleCheckLock instance;
    private SingletonDoubleCheckLock(){};
    public static SingletonDoubleCheckLock getInstance(){
        if (null == instance){
            synchronized (SingletonDoubleCheckLock.class){
                if (null == instance){
                    instance = new SingletonDoubleCheckLock();
                }
            }
        }
        return instance;
    }
}

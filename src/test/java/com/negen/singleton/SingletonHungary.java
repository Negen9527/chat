package com.negen.singleton;

/**
 *  饿汉模式
 *  线程安全，常用
 *  一开始就创建了实例，如果一直没用，就是产生的垃圾
 * @author ：Negen
 * @Date ：Created in 15:30 2020/5/23
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class SingletonHungary {
    private static SingletonHungary instance = new SingletonHungary();
    private SingletonHungary(){};
    public static SingletonHungary getInstance(){
        return instance;
    }
}

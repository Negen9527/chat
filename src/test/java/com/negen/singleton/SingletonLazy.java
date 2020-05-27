package com.negen.singleton;

/**
 *  懒汉式
 *  线程不安全，延迟初始化
 * @author ：Negen
 * @Date ：Created in 15:25 2020/5/23
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class SingletonLazy {
    //私有的静态的全局变量
    private static SingletonLazy instanse;
    //私有化的构造函数
    private SingletonLazy(){};
    //公有的静态的方法
    public static SingletonLazy getInstance(){
        if (null == instanse){ //线程不安全触发点
            instanse = new SingletonLazy();
        }
        return instanse;
    }
}

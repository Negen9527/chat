package com.negen.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：Negen
 * @Date ：Created in 10:54 2020/5/22
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class DynamicProxyTestAutoBoxing implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate){
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
                this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        method.invoke(this.delegate, args);
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("cost time: " + cost);
        return result;
    }
}

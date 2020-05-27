package com.negen;

import java.util.Arrays;

/**
 * @author ：Negen
 * @Date ：Created in 16:17 2020/5/22
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class MyStack<T> {
    private T[] elements;
    private int size = 0;
    private final static int DEFAULT_CAPACITY = 16;

    public MyStack (){
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T e){
        ensureCapacity();
        elements[size++] = e;
    }

    public T pop(){
        return (T)elements[--size];
    }

    private void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("string---1");
        stringMyStack.push("string---2");
        stringMyStack.push("string---3");
        while (!stringMyStack.isEmpty()){
            System.out.println(stringMyStack.pop());
        }
        System.out.println(8<<2);
        System.out.println(8>>2);
    }
}

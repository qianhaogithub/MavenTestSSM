package com.github.testFoundation;

import java.util.LinkedList;

/**
 * @author qianhao
 * @create 2020/4/22-23:09
 */
public class MyStack<T> {
    private LinkedList<T> linkedList;

    public MyStack(){
        linkedList = new LinkedList<T>();
    }

    public void add(T t){
        linkedList.add(t);
    }

    public T get() {
        return linkedList.removeFirst();
    }
}

package com.jaclon.datestructure.queueandstack.base;

/**
 * 数组栈
 * @author jaclon
 * @date 2020/7/30
 */
public class ArrayStack {

    private int n;
    private int count = 0;

    private Object[] stack;

    ArrayStack(int n){
        this.n = n;
        stack = new Object[n];
    }

    public boolean push(Object x){
        if(count == n) return  false;
        stack[count++] = x;
        return true;
    }

    public Object pop(){
        if(count == 0) return null;
        Object obj = stack[count];
        stack[count--] = null;
        return obj;
    }
}

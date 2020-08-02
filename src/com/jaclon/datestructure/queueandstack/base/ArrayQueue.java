package com.jaclon.datestructure.queueandstack.base;

/**
 * 数组-队列
 * @author jaclon
 * @date 2020/7/31
 */
public class ArrayQueue {

    private int count;
    private int n;
    private Object[] obj;

    public ArrayQueue(int n){
        this.n = n;
        count = 0;
        obj = new Object[n];
    }

    public boolean push(Object o){
        if(count == n) return false;
        obj[count++] = o;
        return true;
    }
    // TODO 循环队列
    public Object pop(){
        if(count == 0) return false;
        Object result = obj[0];
        for (int i = 0; i < count - 1; i++) {
            obj[i] = obj[i+1];
        }
        count--;
        return result;
    }

    public void clear(){
        obj = null;
        count = 0;
    }
}

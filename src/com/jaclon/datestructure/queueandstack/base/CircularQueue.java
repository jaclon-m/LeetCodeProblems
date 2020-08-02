/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.queueandstack.base;
/**
 * @Classname CircularQueue
 * @Description 循环队列- tail指向尾部，用size判空
 *
 * @author jaclon
 * @date 2020/4/22
 */
public class CircularQueue {

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;
    //记录当前队列大小
    private int size = 0;

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        if(size == n) return  false;
        /*if(tail + 1 == n){
            tail = 0;
        }else {
            tail++;
        }*/
        tail = (tail + 1) %n;
        items[tail] = item;
        size++;
        return true;
    }

    // 出队
    public String dequeue() {
        if(size == 0) return  null;
        String value = items[head];
        head = (head + 1) %n;
        size++;
        return value;
    }

    public void printAll() {
        if (size == 0) return;
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println(items[tail]);
        System.out.println();
    }
}

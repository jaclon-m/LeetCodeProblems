/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.QueueAndStack;
/**
 * @Classname CircularQueue2
 * @Description 循环队列的实现- tail指向最后一位的下一位
 * 如果直接指向尾部，会导致出队的时候无法判空
 *
 * @author jaclon
 * @date 2020/4/22
 */
public class CircularQueue2 {

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public CircularQueue2(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        if(head == (tail + 1) % n) return false;
        items[tail] = item;
        tail = (tail + 1)%n;
        return true;
    }

    // 出队
    public String dequeue() {
        if(head == tail) return  null;
        String value = items[head];
        head = (head + 1) % n;
        return value;
    }

    public void printAll() {
        if(0 ==n) return;
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

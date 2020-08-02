package com.jaclon.datestructure.queueandstack.base;

import com.jaclon.datestructure.basic.ListNode;

/**
 * 链式队列
 * @author jaclon
 * @date 2020/7/31
 */
public class LinkQueue {
    private int size;
    private int count;
    private ListNode head,tail;

    public LinkQueue(int n){
        count = 0;
        size = n;
    }

    public boolean push(ListNode node){
        if(count == size) return  false;
        if(tail == null){
            head = tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        count++;
        return  true;
    }

    public ListNode pop(){
        if(count == 0) return null;
        if(head == null) return null;
        ListNode node = head;
        head = head.next;
        count --;
        //注意：出队时对所有元素出尽的判断
        if(head == null){
            tail = null;
        }
        return node;
    }

    public void clear(){
        count = 0;
        head = tail = null;
    }
}

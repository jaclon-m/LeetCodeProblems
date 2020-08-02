package com.jaclon.datestructure.queueandstack.base;

import com.jaclon.datestructure.basic.ListNode;

/**
 * 链式栈
 * @author jaclon
 * @date 2020/7/30
 */
public class LinkStack {

    ListNode head;
    int n;
    int count = 0;

    LinkStack(int n){
        this.n = n;
    }

    public boolean push(ListNode node){
        if(count == n) return  false;
        if(head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
        count++;
        return true;
    }

    public ListNode pop(){
        if(count == 0 || head == null) return null;
        ListNode node = head;
        head = head.next;
        count--;
        return node;
    }
}

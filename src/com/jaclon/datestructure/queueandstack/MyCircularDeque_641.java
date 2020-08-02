package com.jaclon.datestructure.queueandstack;

import com.jaclon.datestructure.Solution;

/**
 * TODO 使用数组实现
 * @author jaclon
 * @date 2020/8/2
 */
public class MyCircularDeque_641 {

    private ListNode head,tail;
    private int count = 0;
    private int size = 0;

    public class ListNode {
        public int val;
        ListNode next;
        ListNode pre;

        public ListNode() {
        }

        public ListNode(int x) { val = x; }
    }
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque_641(int k) {
        size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if(count == size) return false;
        ListNode node = new ListNode(value);
        if(head == null){
            head = tail = node;
        }else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if(count == size) return false;
        ListNode node = new ListNode(value);
        if(tail == null){
            head = tail = node;
        }else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if(head == null) return false;
        head = head.next;
        if(head == null){
            tail = null;
        }else {
            head.pre = null;
        }
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if(tail == null) return false;
        tail = tail.pre;
        if(tail == null){
            head = null;
        }else {
            tail.next = null;
        }
        count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if(head == null) return -1;
        return head.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if(tail == null) return -1;
        return tail.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == size;
    }
}

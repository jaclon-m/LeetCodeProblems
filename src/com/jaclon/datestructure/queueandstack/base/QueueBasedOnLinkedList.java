/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.queueandstack.base;
/**
 * @Classname QueueBasedOnLinkedList
 * @Description 队列的链表实现
 *
 * @author jaclon
 * @date 2020/4/22
 */
public class QueueBasedOnLinkedList {

    private Node head = null;
    private Node tail = null;

    public void enqueue(Node node){
        if(tail == null){
            head = node;
            tail = node;
        }
        tail.next = node;
        tail = tail.next;
    }

    public Node dequeue(){
        if(head == null){
            return  null;
        }
        Node node = head;
        head = head.next;
        //注意：出队时对所有元素出尽的判断
        if(head == null){
            tail = null;
        }
        return node;
    }

    public void printAll(){
        Node node = head;
        while (node != null){
            System.out.println(node.getData());
            node = node.next;
        }
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}

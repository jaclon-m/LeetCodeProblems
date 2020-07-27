package com.jaclon.datestructure.arrayandlink;

import javax.print.attribute.standard.NumberUp;

/**
 *  1）单链表的插入、删除、查找操作；
 *  2）链表中存储的是int类型的数据；
 * @author jaclon
 * @date 2020/7/27
 */
public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        if(p == null) return null;
        while (p != null && p.data != value) p = p.next;
        return  p;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node node = new Node(value,null);
        insertToHead(node);
    }

    private void insertToHead(Node node) {
        if(head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }


    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        insertTail(newNode);
    }

    private void insertTail(Node newNode) {
        Node p = head;
        if(p == null){
            p = newNode;
        }else {
            while (p.next != null) p = p.next;
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value,null);
       insertAfter(p,newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if(p == null) return ;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if(p == null ) head = newNode;
        // attention: head == p
        if(head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }
        if( q == null) return;
        newNode.next = q.next;
        //newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if(p == null || head == null)  return;
        // head ==  p
        if(p == head ) {
            head = head.next;
            return ;
        }
        Node q = head;
        while (q != null || q.next != p ) q = q.next;
        if(q == null) return;
        q.next =  q.next.next;
    }

    public void deleteByValue(int value) {
        if(head == null) return;
        if(head.data == value) head = head.next;
        Node p = head;
        Node q = null;
        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }
        if(p == null) return ;
        q.next =p.next;

        /*if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }*/
    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}

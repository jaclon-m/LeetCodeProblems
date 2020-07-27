package com.jaclon.datestructure.arrayandlink;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并 leetcode 21
 * 4) 删除链表倒数第n个结点 leetcode 19
 * 5) 求链表的中间结点 leetcode 876 easy
 * @author jaclon
 * @date 2020/7/27
 */
public class LinkedListAlgo {
    /**
     * 单链表反转
     * @param list
     * @return
     */
    public static Node reverse(Node list){
       //if( list == null ||list.next == null) return list;
        Node pre = null,next = null;
        Node curr = list;
        while (curr != null){
            next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;

    }

    /**
     * 链表中环的检测
     * TODO :待测试
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list){
        Node slow = list,fast = list;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /**
     * 删除链表倒数第n个结点
     * @param list
     * @return
     */
    public static Node removeNthNodeFromEndOfList(Node list,int n){
        Node dummy = new Node(0,null);
        dummy.next = list;
        Node slow = dummy;
        Node fast = list;
        while (n-- > 0 && fast != null){
            fast = fast.next;
        }
        //Given n will always be valid.
       // if(fast == null) return null;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        Node node = slow.next;
        slow.next = slow.next.next;
        return dummy.next;
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

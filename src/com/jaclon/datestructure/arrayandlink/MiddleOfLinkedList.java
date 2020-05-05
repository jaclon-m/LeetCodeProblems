package com.jaclon.datestructure.arrayandlink;

import com.jaclon.datestructure.basic.ListNode;

/**
 * @author jaclon
 * @date 2020/5/5
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

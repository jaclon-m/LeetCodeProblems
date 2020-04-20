package com.jaclon.datestructure.geekbandcard;

import com.jaclon.datestructure.basic.ListNode;

import java.util.List;

/**
 * @author jaclon
 * @date 2020/4/19
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp =head.next;
        ListNode pre = head;
        while (fast.next.next != null){
            fast = fast.next.next;

            pre = slow;
            slow = temp;
            temp = slow.next;
            slow.next = pre;


        }

        while (head.next != null && slow.next != null){
            if(head != slow){
                return false;
            }
            head =head.next;
            slow =slow.next;
        }

        return true;
    }

}

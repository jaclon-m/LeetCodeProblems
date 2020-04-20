package com.jaclon.datestructure.geekbandcard;

import com.jaclon.datestructure.basic.ListNode;


/**
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null){
            return  false;
        }
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return  true;
            }
        }
        return  false;
    }
}

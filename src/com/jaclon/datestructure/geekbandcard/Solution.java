/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.geekbandcard;

import com.jaclon.datestructure.basic.ListNode;

/**
 * @Classname Solution
 * @Description TODO
 *
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {

    public ListNode reverseList(ListNode head){
        /*ListNode pre = null;
        ListNode now = head;
        ListNode pnext = null;
        ListNode tail = null;
        while (now != null){
            pnext = now.next;
            if(pnext == null){
                tail = now;
            }
            now.next = pre;
            pre = now;
            now = pnext;
        }
        return  tail;*/

        if(head == null || head.next == null){
            return head;
        }else {
           ListNode newHead =  reverseList(head.next);
           head.next.next = head;
           head.next = null;
           return  newHead;
        }
    }

}

package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Level;

/**
 * n 皇后问题
 *
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        PriorityQueue <ListNode> queue = new PriorityQueue <>((x,y) -> x.val - y.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            node = node.next;
            if(node != null){
                queue.offer(node);
            }
        }
        return dummy.next;
    }
}

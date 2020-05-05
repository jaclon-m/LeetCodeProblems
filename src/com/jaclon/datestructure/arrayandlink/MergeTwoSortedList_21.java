package com.jaclon.datestructure.arrayandlink;

import com.jaclon.datestructure.basic.ListNode;

/**
 * @author jaclon
 * @date 2019/5/28
 * @time 14:21
 */
public class MergeTwoSortedList_21 {
    /**
     * 使用哨兵简化条件
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = head;
        while (l1 != null && l2 !=null){
            ListNode node = new ListNode();
            if(l1.val <= l2.val){
                node.val = l1.val;
                l1 = l1.next;
            }else {
                node.val = l2.val;
                l2 = l2.next;
            }
            head.next = node;
            head = head.next;
        }
        if(l1 == null){
            head.next = l2;
            return  dummy.next;
        }
        if(l2 == null){
            head.next = l1;

        }
        return dummy.next;

    }

    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode temp;

        if(l1.val<l2.val){
            temp = l1;
            temp.next = mergeTwoLists(l1.next,l2);
        }else {
            temp = l2;
            temp.next = mergeTwoLists(l2.next,l1);
        }
        return temp;
    }

}

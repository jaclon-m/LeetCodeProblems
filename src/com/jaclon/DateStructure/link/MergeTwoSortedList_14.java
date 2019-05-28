package com.jaclon.DateStructure.link;

/**
 * @author jaclon
 * @date 2019/5/28
 * @time 14:21
 */
public class MergeTwoSortedList_14 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /*ListNode listNode = null;
        ListNode head = null;

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        listNode = head;

        while (l1!= null && l2 != null){
            if(l1.val < l2.val){
                listNode.next = l1;
                listNode = listNode.next;
                l1 = l1.next;
            }else {
                listNode.next = l2;
                listNode = listNode.next;
                l2 = l2.next;
            }

        }

        listNode.next = l1 == null ? l2:l1;
        return head;*/

        //递归实现
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

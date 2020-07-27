package com.jaclon.datestructure.arrayandlink;

import com.jaclon.datestructure.basic.ListNode;

/**
 * @author jaclon
 * @date 2019/6/1
 * @time 10:27
 */
public class RemoveNthNodeFromEndOfList_19 {
    /**
     * 这个递归太妙了！
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        recursiveRemoveNthFromEnd(pre,n);

        return pre.next;
    }

    private int recursiveRemoveNthFromEnd(ListNode pre, int n){
        if(pre != null){
            n = recursiveRemoveNthFromEnd(pre.next,n);

        }

        if(n == -1){
            pre.next = pre.next.next;
        }
        return --n;
    }

    /**
     * 官方解法，让第1,2个指针的间距为n
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 对比上面的发现使用哨兵-dummy可以简化代码
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (n-- >0){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode  fast = head;
        while (n-- > 0 && fast != null){
            fast = fast.next;
        }
        if(fast == null) return null;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

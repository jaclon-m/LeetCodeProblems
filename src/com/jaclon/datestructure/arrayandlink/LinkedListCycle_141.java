package com.jaclon.datestructure.arrayandlink;


import com.jaclon.datestructure.basic.ListNode;

/**
 * @author jaclon
 * @date 2019/5/27
 * @time 10:52
 */
public class LinkedListCycle_141 {

    /**
     * 关于快慢指针大小的证明和求环的起始节点的方式https://blog.csdn.net/cfylove/article/details/50857137
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        if(head == null){
            return false;
        }
        //while (slow.next != null || fast.next.next != null)
        //fast.next = null的情况会报空指针异常 ==>fast.next!= null &&fast.next.next!=null
        // 等价于fast != null && fast.next != null
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}

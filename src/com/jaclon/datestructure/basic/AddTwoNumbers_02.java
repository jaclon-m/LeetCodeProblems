package com.jaclon.datestructure.basic;

/**
 * @author jaclon
 * @date 2019/8/20
 * @time 11:06
 */
public class AddTwoNumbers_02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1,q = l2,curr = dummyHead;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null? p.val:0);
            int y = (q != null?q.val:0);
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 调了3-4次
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

        int store = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (true){
            int num1 = l1 == null ? 0:l1.val;
            int num2 = l2 == null? 0:l2.val;

            int num = (num1 + num2 + store)%10;
            store = (num1 + num2 + store)/10;
            ListNode node = new ListNode(num);
            head.next = node;
            head = node;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            if(l1 == null && l2 == null && store == 0){
                break;
            }

        }
        return dummy.next;
    }

    /**
     * 转数据的解法 -- 1 注意0 2 int 越界 3 long也越界了，两数相加不是这个问题的解题思路
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        long num1 = 0,num2 = 0;
        int sqrt = 0;
        while (l1 != null){
            Double pow = Math.pow(10, sqrt++);
            num1 = num1 +l1.val*pow.longValue();
            l1 = l1.next;
        }
        sqrt = 0;
        while (l2 != null){
            Double pow = Math.pow(10, sqrt++);
            num2 = num2 + l2.val*pow.longValue();
            l2 = l2.next;
        }
        long sum = num1 + num2;
        ListNode head = new ListNode(0) ;
        ListNode dummy = head ;
        while (true){
            long val = sum %10;
            ListNode node = new ListNode((int)val);
            head.next = node;
            head = node;
            sum /= 10;
            if(sum == 0){
                break;
            }
        }
        return dummy.next;
    }
}

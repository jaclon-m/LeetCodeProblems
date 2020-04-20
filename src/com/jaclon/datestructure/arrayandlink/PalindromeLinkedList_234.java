package com.jaclon.datestructure.arrayandlink;


import com.jaclon.datestructure.basic.ListNode;

public class PalindromeLinkedList_234 {
    /**
     * 1 快慢指针定位中间节点（这里要区分奇偶情况）
     * 1.1 奇数情况，中点位置不需要矫正
     * 1.2 偶数情况，使用偶数定位中点策略，要确定是返回上中位数或下中位数
     * 1.2.1 如果是返回上中位数，后半部分串头取next
     * 1.2.2 如果是返回下中位数，后半部分串头既是当前节点位置，但前半部分串尾要删除掉当前节点
     * 2 从中间节点对后半部分逆序，或者将前半部分逆序
     * 3 一次循环比较，判断是否为回文
     * 4 恢复现场
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        if(fast != null){
            slow = slow.next;
        }
        while (slow != null){
            if(slow.val != prev.val){
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

}


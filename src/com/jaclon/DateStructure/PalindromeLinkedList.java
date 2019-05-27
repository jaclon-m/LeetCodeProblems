package com.jaclon.DateStructure;

public class PalindromeLinkedList {

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

/*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/

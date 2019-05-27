package com.jaclon.DateStructure;

/**
 * @author jaclon
 * @date 2019/5/24
 * @time 16:00
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ReverseLinkedList_206 {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new ReverseLinkedList_206().reverseList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    /**
     * 小结：分别使用迭代和递归的方式实现链表反转。
     * 一开始自己写的比较模糊，查阅的一个java实现也是，思路不清晰。第二天查阅C的写法后发现思路简单明了。
     * 参考链接：https://www.cnblogs.com/kubixuesheng/p/4394509.html
     * 比较模糊的java方法：https://www.cnblogs.com/byrhuangqiang/p/4311336.html
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        /*if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        ListNode temp;
        head.next = null;

        while (curr !=null){
            pre = head;
            head = curr;
            curr = curr.next;
            temp = head;
            temp.next = pre;
        }*/

        /*ListNode pre = null;
        ListNode pNow = head;
        ListNode pNext = null;
        ListNode tail = null;

        while (null != pNow){
            pNext = pNow.next;
            if(null == pNext){
                tail = pNow;
            }
            pNow.next = pre;
            pre = pNow;
            pNow = pNext;
        }
        return tail;*/

        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
        //return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

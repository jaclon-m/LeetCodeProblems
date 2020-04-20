package com.jaclon.datestructure.geekbandcard;

import com.jaclon.datestructure.basic.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode pPre = head,pCurr = head;
        ListNode pNext = pCurr.next;
        head.next = null;
        while (true){
            pPre = pCurr;
            pCurr = pNext;
            if(pCurr.next != null){
                pNext = pCurr.next;
                pCurr.next = pPre;
            }else {
                pCurr.next = pPre;
                head = pCurr;
                break;
            }
        }
        return head;

    }

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

            ListNode ret = new Solution().reverseList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}

package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;
import sun.security.util.Length;

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
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque <>();
        int left = 0,size = nums.length;

        for (int i = 0; i < size; i++) {
            //维护单调栈
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            //初始化以后都相等
            if(i - left == k - 1){
                ans[left++] = nums[deque.peek()];
                // 指针（left)右移后，判断队列第一个元素的位置和指针的位置关系
                if(left > deque.peek()){
                    deque.poll();
                }
            }
        }

        return ans;
    }

    /**
     * over time limited
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue <>(k,(x,y)->y-x);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        result[0] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i-k]);
            queue.offer(nums[i]);
            result[i-k + 1] = queue.peek();
        }
        return result;
    }
}

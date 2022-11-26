package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;
import com.jaclon.datestructure.thought.LwstCharMatch;
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
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> sum = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(sum.containsKey(nums[i])){
                result[0] = nums[i];
                result[1] = sum.get(nums[i]);
                return result;
            }else {
                sum.put(target - nums[i],nums[i]);
            }
        }
        throw new RuntimeException("error");
    }
}

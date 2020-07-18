package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

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
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i+1;
            int high = nums.length -1;
            while (low<high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    set.add(Arrays.asList(nums[i],nums[low++],nums[high--]));
                }else if(sum < 0 ){
                    low++;
                }else {
                    high --;
                }
            }
        }
        return new ArrayList<>(set);
    }
}

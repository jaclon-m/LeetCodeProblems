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
    public static void main(String[] args) {

    }
    public int firstMissingPositive(int[] nums) {
        // nums == null
        if(nums.length == 0) return 1;
        int n = nums.length;
        for (int  i = 0 ; i < n;){
            if(nums[i] >=1 && nums[i] <= n){
                if(nums[i] != i+1 && nums[i] != nums[nums[i] - 1]){
                    //swap(nums[i],nums[nums[i] - 1]);
                    // pay attention! temp= nums[i] cause ArrayIndexOutOfBoundsException
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                    continue;
                }
            }
            i++;
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }

}

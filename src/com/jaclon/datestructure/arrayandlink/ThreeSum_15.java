/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.arrayandlink;

import java.util.*;

/**
 * @Classname ThreeSum_15
 * @Description 三数求和。
 *  时间复杂度 O(n^2)
 *  使用排序的方式可以去重
 *
 * @author jaclon
 * @date 2020/7/18
 */
public class ThreeSum_15 {
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

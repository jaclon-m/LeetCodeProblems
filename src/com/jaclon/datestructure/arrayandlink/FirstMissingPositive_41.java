package com.jaclon.datestructure.arrayandlink;

/**
 * https://blog.csdn.net/l1606468155/article/details/89164854
 * https://zhuanlan.zhihu.com/p/113458584 -- in-place思想
 * @author jaclon
 * @date 2020/7/29
 */
public class FirstMissingPositive_41 {

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

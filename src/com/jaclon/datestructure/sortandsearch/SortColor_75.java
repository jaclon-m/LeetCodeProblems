package com.jaclon.datestructure.sortandsearch;

/**
 * @author jaclon
 * @date 2019/8/23
 * @time 9:59
 */
public class SortColor_75 {
    /**
     * 三向切分快速排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int lt = 0 ,gt = nums.length - 1;
        int i = 0 ;

        while (i<=gt){
            if(nums[i] == 0){
                swap(nums,i++,lt++);
            }else if(nums[i] == 2){
                swap(nums,i,gt--);
            }else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

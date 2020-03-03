package com.jaclon.datestructure.search;

/**
 * @author jaclon
 * @date 2019/8/31
 */
public class RotedSortArray_33 {


    public int search(int[] nums, int target) {
        int temp = nums[0];
        int flag = 0;
        for(int i = 0 ; i< nums.length; i++){
            if(nums[i] < temp){
                temp = nums[i];
                flag = i;
            }
        }
        return bsearch(nums,target,flag);
    }

    public static int bsearch(int[] array , int des,int offset){
        int low = 0;
        int high = array.length - 1;
        int n = array.length - 1;

        while (low<= high && low <array.length && high < array.length){
            int middle = (low + high)/2;
            if(n != 0){
                middle = (middle + offset)%n;
            }

            if(des == array[middle]){
                return middle;
            }
            if(des < array[middle]){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
}

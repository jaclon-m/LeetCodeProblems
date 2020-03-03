package com.jaclon.datestructure.sort;

/**
 * @author jaclon
 * @date 2019/8/22
 * @time 11:07
 */
public class KthElement_215 {

    public int findKthLargest(int[] nums, int k) {
        int high = nums.length - 1;
        int low = 0 ;
        while (true){
            int p = partition(nums,low,high);
            if(p + 1 == k){
                return nums[p] ;
            }else if( p + 1 > k){
                high = p - 1;
            }else {
                low = p + 1;
            }
        }

    }

    private int partition(int[] nums, int low, int high) {

        int pivot = nums[high];
        int i =  low;
        for(int j = low ; j < high ; j++){
            if(nums[j] > pivot){
                swap(nums,i,j);
                i += 1;
            }
        }
        swap(nums,i,high);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

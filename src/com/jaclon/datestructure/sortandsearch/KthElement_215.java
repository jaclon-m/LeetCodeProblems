package com.jaclon.datestructure.sortandsearch;

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

    // partation2(nums,0,nums.length-1,k);
    private int partation2(int[] nums, int head, int tail,int k) {
        int low = head,high = tail;
        if(low < high){
            int pivot = nums[tail];
            while (low < high){
                //  nums[low] >= pivot 只写> 会死循环
                while (low < high && nums[low] >= pivot) low++;
                nums[high] = nums[low];
                while (low < high && nums[high] <= pivot) high--;
                nums[low] = nums[high];

            }
            nums[low] = pivot;
        }
        if(low+1 == k){
            return nums[low];
        }else if(low+1 < k){
            return partation2(nums,low+1,tail,k);
        }else {
            return partation2(nums,head,low -1,k);
        }
    }
}

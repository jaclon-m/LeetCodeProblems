package com.jaclon.datestructure.search;

/**
 * @author jaclon
 * @date 2019/8/29
 */
public class ExpandBinarySearch {

    //查找第一个值等于给定值的元素
    public static int bsearch01(int[] array , int n , int value){

        int low = 0,high = n-1;

        while (low <= high){
            int mid = low + (high - low)>>1;
            if(array[mid] <value){
                low = mid + 1;
            }else if(array[mid] > value){
                high = mid - 1;
            }else {
                if(mid == 0 || array[mid - 1] < value){
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public static int bsearch02(int[] array , int n , int value){
        int low = 0 ,high = n - 1;
        while (low <= high){
            int mid = low + (high - low)>>1;
            if(array[mid] <value){
                low = mid + 1;
            }else if(array[mid] > value){
                high = mid - 1;
            }else {
                if(mid == n-1 || array[mid + 1] != value){
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    public static int bsearch03(int[] array , int n , int value){
        int low = 0 , high = n - 1;

        while (low <= high){
            int mid = low + (high - low)>>1;
            if(array[mid] < value){
                low = mid + 1;
            }else {
                if(mid == 0 || array[mid-1] != value ){
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public int bsearch04(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

}

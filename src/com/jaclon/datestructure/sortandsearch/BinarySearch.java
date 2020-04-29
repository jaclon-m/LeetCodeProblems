package com.jaclon.datestructure.sortandsearch;

/**
 * @author jaclon
 * @date 2019/7/23
 * @time 11:21
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    /**
     * 非递归实现
     * @param array
     * @param des
     * @return
     */
    public static int search(int[] array , int des){
        int low = 0;
        int high = array.length - 1;

        while (low<= high && low <array.length && high < array.length){
            int middle = (low + high)/2;
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

    /**
     * 递归实现
     * @param array
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] array , int n , int value){
        return bsearchInternally(array,0,n-1,value);
    }

    private static int bsearchInternally(int[] array, int low, int high, int value) {

        if(low > high){
            return -1;
        }

        int mid = low + (high - low)>>1;
        if(array[mid] == value){
            return mid;
        }else if(array[mid] > value){
            return bsearchInternally(array,low,mid - 1 ,value);
        }else {
            return bsearchInternally(array,mid + 1,high,value);
        }
    }

}

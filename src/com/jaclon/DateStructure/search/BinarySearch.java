package com.jaclon.DateStructure.search;

/**
 * @author jaclon
 * @date 2019/7/23
 * @time 11:21
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

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
}

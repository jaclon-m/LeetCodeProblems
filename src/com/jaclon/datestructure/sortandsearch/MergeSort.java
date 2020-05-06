package com.jaclon.datestructure.sortandsearch;

/**
 * 归并排序
 * @author jaclon
 * @date 2020/5/6
 */
public class MergeSort {

    public static void mergeSort(int[] a, int n){
        mergeSortInternally(a,1,n-1);
    }

    public static void mergeSortInternally(int[] a,int p,int r){

        //终止条件
        if(p>= r) return;
        //防止int型数据溢出
        int q = p + (r-p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        merge(a,p,q,r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r-p+1];

        while (i <= q && j <= r){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if(j < r){
            start = j;
            end = r;
        }
        /*for (int l = start; l <= end ; l++) {
            temp[k++] = a[l];
        }*/
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end){
            temp[k++] = a[start++];
        }
        /*for (int l = 0; l < k; l++) {
            a[p + l] = temp[l];
        }*/
        // 将tmp中的数组拷贝回a[p...r]
        for(i = 0;i<r-p;i++){
            a[p+i] = temp[i];
        }
    }

    /**
     * 利用哨兵
     * 通过巧妙的设置最大值的方式避免比较的时候一个数组用完导致的数组下标越界问题
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    public void mergeBySentry(int[] arr,int p,int q,int r){
        int[] leftArr = new int[q-p+2];
        int[] rightArr = new int[r-q+1];

        for (int i = 0; i <= q-p ; i++) {
            leftArr[i] = arr[p+i];
        }
        leftArr[q-p+1] = Integer.MAX_VALUE;
        for (int i = 0; i < r - q; i++) {
            rightArr[i]= arr[q+i+1];
        }
        rightArr[r-q+1] = Integer.MAX_VALUE;

        int k = p;
        int i = 0;
        int j = 0;
        //left+right的数量恰好是k~r的数量，当left和right都达到maxValue的时候，就不满足判断条件了
        while (k<=r){
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }else {
                arr[k++] = rightArr[j++];
            }
        }
    }
}

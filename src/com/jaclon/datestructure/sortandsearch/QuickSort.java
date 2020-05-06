package com.jaclon.datestructure.sortandsearch;

/**
 * 快速排序
 * 难点在于伪代码实现时 i==j i++的理解
 * @author jaclon
 * @date 2020/5/6
 */
public class QuickSort {
    public static void quickSort(int[] a, int n){
        quickSortInternally(a,0,n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        int q = partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(a[j] < pivot){
                if(i == j){
                    i++;
                }
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        System.out.println("i = " + i);
        return i;
    }

}

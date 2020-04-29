package com.jaclon.datestructure.sortandsearch;

import java.util.Arrays;

/**
 * @author jaclon
 * @date 2020/4/23
 * 冒泡排序、插入排序、选择排序
 */
public class sorts {

    /**
     * 冒泡排序，a是数组，n表示数组大小
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        boolean flag = true;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if(n <= 1) return;
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            //将j 移除循环解决在0位置插入的问题
            int j = i - 1;
            for ( ; j >= 0 ; j--) {
                if(a[j] > a[i]){
                    a[j+1] = a[j];
                }else {

                    break;
                }
            }
            a[j+1] = temp;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int k = i ;
            for (int j = i + 1; j < n; j++) {
                if(a[k] > a[j]){
                    k = j;
                }
            }
            if(k != i){
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * ps:大致知道是插入排序在无序情况下的使用，但是没看懂
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return;

        int step = len / 2;
        while (step >= 1) {
            for (int i = step; i < len; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < arr[j]) {
                        arr[j+step] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j+step] = value;
            }

            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort2(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}

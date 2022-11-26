package com.jaclon.datestructure.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Description
 *
 * @author jaclon
 * @since 2021/8/5 11:59
 */
public class SortExercise {

    public static void main(String[] args) {
        System.out.println("==========");
        int[] a = {3,5,9,102,21,13,8};
        bubbleSort(a,7);
    }

    public static  void insertSort(int[]a,int n){
        if(n <= 1)return;
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(flag || a[i]<a[j]){
                    flag = true;
                    swap(a[i],a[j]);
                }
            }
        }
    }
    public static void bubbleSort(int[] a, int n){
        if(n <= 1) return;
        for (int i = n-1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(a[j] > a[j+1]){
                    swap(a[j],a[j+1]);
                    flag = true;
                }
            }
            if(flag) break;
        }
        System.out.println(Arrays.asList(a).toString());
    }

    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }


}

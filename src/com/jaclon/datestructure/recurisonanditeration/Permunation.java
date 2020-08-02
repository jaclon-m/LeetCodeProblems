package com.jaclon.datestructure.recurisonanditeration;

/**
 * 全排列
 * https://blog.csdn.net/LYF980226/article/details/79947753
 * @author jaclon
 * @date 2020/7/31
 */
public class Permunation {

    public static void main(String[] args) {
        int a[] = {};
        permuanation(a,0,a.length-1);
    }

    public static void permuanation(int[] a,int k,int m){
        if(k == m){
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }else {
            for (int i = k; i <= m; i++) {
                swap(a,k,i);
                permuanation(a,k+1,m);
                swap(a,i,k);
            }
        }
    }

    public static void swap(int[] a, int k ,int j){
        int temp = a[k];
        a[k] = a[j];
        a[j] = temp;
    }
}

package com.jaclon.datestructure.binarytree.heap;

public class Heap {

    private int[] a; // 数组，从下标1开始存储数据
    private int n; // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public static void main(String[] args) {

    }

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 大顶堆，从下往上堆化
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }

        count++;
        a[count] = data;
        int i = count;
        while (i > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }
    
    // n表示数据的个数，数组a中的数据从下标1到n的位置。
    public void sort(int a[], int n){
        buildHeap(a,n);
        int k = n;
        while (k>1){
            swap(a,1,k);
            k--;
            heapify(a,k,1);
        }

    }

    /**
     * 从后往前构造堆
     * @param a
     * @param n
     */
    public void buildHeap(int a[],int n){
        for (int i = n/2;i>0;i--){
            heapify(a,n,i);
        }
    }

    /**
     * 堆化--从上往下
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        int maxPos = i;

        while (true) {

            if (2 * i <= n && a[i] < a[2 * i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= n && a[maxPos] < a[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (i == maxPos) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

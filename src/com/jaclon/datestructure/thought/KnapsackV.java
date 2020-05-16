/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.thought;
/**
 * @Classname knapsack2
 * @Description 背包问题升级版
 *
 * @author jaclon
 * @date 2020/5/16
 */
public class KnapsackV {

    //回溯法
    private int maxV = Integer.MIN_VALUE; // 结果放到maxV中
    private int[] items = {2,2,4,6,3};  // 物品的重量
    private int[] value = {3,4,8,9,6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    public void f(int i,int cw,int cv){
        if(cw == w ||i == n){
            if(cv > maxV) maxV = cv;
            return;
        }
        f(i+1,cw,cv);
        if(cw+items[i] <= w){
            f(i+1,cw+items[i],cv+value[i]);
        }
    }

    int[][] mem = new int[n][w+1];
    void init(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                mem[i][j] = -1;
            }
        }
    }

    public void f2(int i,int cw,int cv){
        if(cw == w || i == n){
            maxV = cv>maxV?cv:maxV;
            return;
        }
       if(mem[i][cw] >cv) return;
       mem[i][cw] = cv;
       f2(i+1,cw,cv);
       if(items[i] + cw <= w){
           f2(i+1,cw+items[i],cv+value[i]);
       }
    }

    /**
     * 回溯法无法使用“备忘录”
     * 使用动态规划
     * ps 我觉得可以使用-上面的f2已验证
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        //init
        int[][] status = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                status[i][j] = -1;
            }
        }
        status[0][0] = 0;
        if(weight[0]<=w){
            status[0][weight[0]] = value[0];
        }
        //dp status change
        for (int i = 1; i < n; i++) {
            // i no in knapsack
            for (int j = 0; j <= w; j++) {
                if(status[i-1][j] > 0) status[i][j] = status[i-1][j];
            }
            for (int j = 0; j <= w-weight[i] ; j++) {
                if(status[i-1][j]>0) status[i][j+weight[i]] = status[i-1][j] + value[i];
            }

        }
        int maxV = -1;
        for (int i = 0; i <= w; i++) {
            if(status[n-1][i] > maxV) maxV = status[n-1][i];
        }
        return maxV;
    }

    public static void main(String[] args) {
        KnapsackV knapsackV = new KnapsackV();
       // knapsack3(knapsackV.items,knapsackV.value,5,9);
        knapsackV.init();
        knapsackV.f2(0,0,0);
        System.out.println(knapsackV.maxV);
    }
}

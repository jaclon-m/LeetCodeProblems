package com.jaclon.datestructure.thought;

import java.util.LinkedList;
import java.util.List;

/**
 * 0_1背包问题
 * @author jaclon
 * @date 2020/5/15
 */
public class Knapsack {
    //回溯算法
    private int maxW = Integer.MIN_VALUE;
    List <Integer> list = new LinkedList <>();
    private void f(int i ,int cw,int[] items,int n,int w){
        if(i == n || cw == w){
            if(cw > maxW) maxW = cw;
            return;
        }
        //当前物品不装入背包的情况
        f(i+1,cw,items,n,w);
        //当前物品装入背包的情况
        if(cw+items[i] <=cw){
            list.add(i);
            f(i+1,cw+items[i],items,n,w);
        }
    }

    /**
     * 基础版
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int knapsack1(int[] weight,int n,int w){
        boolean[][] states = new boolean[n][w+1];
        //初始化
        states[0][0] = true;
        if(weight[0] <= w){
            states[0][weight[0]] = true;
        }
        //从下标为1的数据到下标为n-1的数据
        for (int i = 1; i < n; i++) {
            //下标为i的物品不装入背包的情况
            for (int j = 0; j <= w; j++) {
                if(states[i-1][j]) states[i][j] = true;
            }
            //下标为i的物品装入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if(states[i-1][j]) states[i][j+weight[i]] = true;
            }
        }
        //倒序求最大重量
        for (int i = w; i >=0 ; i--) {
            if(states[n-1][i]) return i;
        }
        return 0;
    }

    /**
     * 空间优化
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int knapsack2(int[] weight,int n, int w){
        boolean[] states = new boolean[w+1];
        states[0] = true;
        if(weight[0] <= w){
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            //不装入的情况可以省略
            for (int j = w-weight[i]; j >= 0; j--) {
                if(states[j]) states[j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0 ; i--) {
            if(states[i]) return i;
        }
        return 0;
    }

}

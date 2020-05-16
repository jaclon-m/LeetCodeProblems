package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * n 皇后问题
 *
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {

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
}

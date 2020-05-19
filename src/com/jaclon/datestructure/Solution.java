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

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    int maxV = -1;
    public void lcs(int i,int j,int maxl){
        if(i == n || j == m){
            if(maxl > maxV) maxV = maxl;
            return;
        }
        if(a[i] ==b[j]) lcs(i+1,j+1,maxl+1);
        else {
            lcs(i+1,j,maxl);
            lcs(i,j+1,maxl);
        }
    }

    public int lcsDP(char[] a,int n,char[] b,int m){
        int[][] maxDist =new int[n][m];
        for (int j = 0; j < m; j++) {
            if(a[0] == b[j]) maxDist[0][j] = 1;
            else maxDist[0][j] = 0;
        }
        for (int i = 0; i < n; i++) {
            if(a[i] == b[0]) maxDist[i][0] = 1;
            else maxDist[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a[i] == b[j]) maxDist[i][j] = maxValue(maxDist[i-1][j-1] +1,maxDist[i-1][j]+1,maxDist[i][j-1]+1);
                else maxDist[i][j] = maxValue(maxDist[i-1][j-1],maxDist[i-1][j],maxDist[i][j-1]);
            }
        }
        return maxDist[n-1][m-1];
    }

    private int maxValue(int a, int b, int c) {
        int maxV = a;
        if(maxV<b) maxV = b;
        if(maxV<c) maxV = c;
        return maxV;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lcsDP(s.a,6,s.b,6));
    }
}

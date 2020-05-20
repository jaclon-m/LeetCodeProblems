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

    public int longestCommonSubsequence(String text1, String text2) {
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        return lcsDP(a,a.length,b,b.length);
    }

    private int lcsDP(char[] a, int n,char [] b,int m){
        int[][] maxC = new int[n+1][m+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(a[i-1] == b[j-1]){
                    maxC[i][j] = maxC[i-1][j-1]+1;
                }else {
                    maxC[i][j] = maxC[i-1][j]>maxC[i][j-1]?maxC[i-1][j]:maxC[i][j-1];
                }
            }
        }
        return maxC[n][m];
    }
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    int[][] maxLcs = new int[n+1][m+1];
    int[][] dist = new int[n+1][m+1];
    private void lscDPWithDist(){
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(a[i-1] == b[j-1]){
                    maxLcs[i][j] = maxLcs[i-1][j-1]+1;
                    dist[i][j] = 1;
                }else {
                    if(maxLcs[i][j-1]>maxLcs[i-1][j]){
                        maxLcs[i][j] = maxLcs[i][j-1];
                        dist[i][j] = 2;
                    }else {
                        maxLcs[i][j] = maxLcs[i-1][j];
                        dist[i][j] = 3;
                    }
                }
            }
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

    private void print(int i,int j){
        if(i == 0|| j == 0) return;
        if(dist[i][j] ==1){
            print(i-1,j-1);
            System.out.print(a[i-1]+ "\t");
        }else if(dist[i][j] == 2){
            print(i,j-1);
        }else {
            print(i-1,j);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lscDPWithDist();
        s.print(s.n,s.m);
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

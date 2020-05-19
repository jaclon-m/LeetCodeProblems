package com.jaclon.datestructure.thought;

/**
 * 最长公共子序列
 * @author jaclon
 * @date 2020/5/19
 */
public class LCS_1143 {

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
}

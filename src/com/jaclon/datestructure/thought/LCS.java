package com.jaclon.datestructure.thought;

/**
 * 最长公共子串
 * @author jaclon
 * @date 2020/5/20
 */
public class LCS {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    int maxV = -1;
    //递归写法
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

    /**
     * 我的写法
     * 思路：
     *  如果：a[i]==b[j]，那么：max_lcs(i, j)就等于：
     *      max(max_lcs(i-1,j-1)+1, max_lcs(i-1, j)+1, max_lcs(i, j-1)+1)；
     *
     *      如果：a[i]!=b[j]，那么：max_lcs(i, j)就等于：
     *      max(max_lcs(i-1,j-1), max_lcs(i-1, j), max_lcs(i, j-1))；
     *
     *      其中max表示求三数中的最大值。
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
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

    /**
     * 老师的写法
     * 思路
     *
     如果：a[i]==b[j]，那么：max_lcs(i, j)就等于：
     max(max_lcs(i-1,j-1)+1, max_lcs(i-1, j), max_lcs(i, j-1))；

     如果：a[i]!=b[j]，那么：max_lcs(i, j)就等于：
     max(max_lcs(i-1,j-1), max_lcs(i-1, j), max_lcs(i, j-1))；

     其中max表示求三数中的最大值。
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int lcsDP2(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];
        for (int j = 0; j < m; ++j) {//初始化第0行：a[0..0]与b[0..j]的maxlcs
            if (a[0] == b[j]) maxlcs[0][j] = 1;
            else if (j != 0) maxlcs[0][j] = maxlcs[0][j-1];
            else maxlcs[0][j] = 0;
        }
        for (int i = 0; i < n; ++i) {//初始化第0列：a[0..i]与b[0..0]的maxlcs
            if (a[i] == b[0]) maxlcs[i][0] = 1;
            else if (i != 0) maxlcs[i][0] = maxlcs[i-1][0];
            else maxlcs[i][0] = 0;
        }
        for (int i = 1; i < n; ++i) { // 填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) maxlcs[i][j] = max(
                        maxlcs[i-1][j], maxlcs[i][j-1], maxlcs[i-1][j-1]+1);
                else maxlcs[i][j] = max(
                        maxlcs[i-1][j], maxlcs[i][j-1], maxlcs[i-1][j-1]);
            }
        }
        return maxlcs[n-1][m-1];
    }

    private int max(int x, int y, int z) {
        int maxv = Integer.MIN_VALUE;
        if (x > maxv) maxv = x;
        if (y > maxv) maxv = y;
        if (z > maxv) maxv = z;
        return maxv;
    }
}

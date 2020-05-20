/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.thought;
/**
 * @Classname CharMatch
 * @Description 字符串匹配
 *
 * @author jaclon
 * @date 2020/5/19
 */
public class LwstCharMatch {
    //莱文斯坦距离
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    private int minDist = Integer.MAX_VALUE; // 存储结果

    public void lwstBT(int i,int j,int minS){
        if(i == n || j == m){
            if(i<n) minS += n-i;
            if(j<m) minS += m-j;
            if(minS < minDist) minDist = minS;
            return;
        }
        if(a[i] == b[j]){
            lwstBT(i+1,j+1,minS);
        }else {
            lwstBT(i+1,j,minS+1);
            lwstBT(i,j+1,minS+1);
            lwstBT(i+1,j+1,minS+1);
        }
    }

    public int lwstDP(char[] a, int n ,char[] b,int m){
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; j++) {
            if(a[0] == b[j]) minDist[0][j] = j;
            else if(j != 0) minDist[0][j] = minDist[0][j-1] + 1;
            else minDist[0][j] = 1;
        }

        for (int i = 0; i < n; i++) {
            if(a[i]  == b[0]) minDist[i][0] = i;
            else if(i != 0) minDist[i][0] = minDist[i-1][0];
            else minDist[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(a[i] ==b[j]) minDist[i][j] = minValue(minDist[i-1][j]+1,minDist[i][j-1] + 1,minDist[i-1][j-1]);
                else minDist[i][j] = minValue(minDist[i-1][j]+1,minDist[i][j-1] + 1,minDist[i-1][j-1]+1);
            }
        }
        return minDist[n-1][m-1];
    }
    private int minValue(int x, int y, int z){
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

}

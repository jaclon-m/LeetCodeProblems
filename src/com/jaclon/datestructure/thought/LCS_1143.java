package com.jaclon.datestructure.thought;

/**
 * 最长公共子序列
 * https://www.cnblogs.com/chenleideblog/p/10455723.html
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
    //扩展 求匹配字符
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    int[][] maxLcs = new int[n+1][m+1];
    int[][] dist = new int[n+1][m+1];
    private void lscDPWithDist() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    maxLcs[i][j] = maxLcs[i - 1][j - 1] + 1;
                    dist[i][j] = 1;
                } else {
                    if (maxLcs[i][j - 1] > maxLcs[i - 1][j]) {
                        maxLcs[i][j] = maxLcs[i][j - 1];
                        dist[i][j] = 2;
                    } else {
                        maxLcs[i][j] = maxLcs[i - 1][j];
                        dist[i][j] = 3;
                    }
                }
            }
        }
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
}

package com.jaclon.datestructure.strmatching;

/**
 * @author jaclon
 * @date 2020/2/22
 */
public class KMPTest {

    public static void main(String[] args) {

    }

    /**
     * @param a 主串
     * @param n
     * @param b 模式串
     * @param m
     * @return
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNext(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(char[] b, int m) {
        int[] next = new int[m];
        int k = -1;
        next[0] = -1;
        for (int i = 1; i < m; i++) {
            while (k > 0 && next[k + 1] != b[i]) {
                //查找b[0,i-1]的次长可匹配后缀子串，转化成查找b[0,y]的最长可匹配后缀子串的问题了。
                k = next[k];
            }
            if (next[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;

        }
        return next;
    }
}

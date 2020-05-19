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

}

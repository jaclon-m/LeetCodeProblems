package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Level;

/**
 * n 皇后问题
 *
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {
    public static  int[] returnAll(int[] array1,int[] array2) {
        if(array1 == null ||array2 == null){
            throw new NullPointerException();
        }
        int n = array1.length;
        int m = array2.length;
        int[] union = new int[n+m];
        int i = 0,j = 0;
        while (i<n && j<m){
            if(array1[i] == array2[j]){
                union[i] = array1[i];
                i++;
                j++;
            }else if(array1[i]<array2[j]){
                i++;
            }else {
                j++;
            }
        }
        if(i == n){
            for (int k = j; k < m; k++) {
                union[i+k] = array2[k];
            }
        }else if(j == m){
            for (int k = 0; k < n; k++) {
                union[j+k] = array1[k];
            }
        }
        return union;
    }
}

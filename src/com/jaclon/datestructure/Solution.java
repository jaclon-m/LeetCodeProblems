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

    /*char[] a = new char[];
    char[] b = new char[];
    int n = 0;
    int m = 0;
    int maxlcs = -1;
    //char match back
    void f(int i,int j,int maxl){
        // end condition
        if(i == n || j == m){
            if(maxl > maxlcs) maxlcs = maxl;
        }
        if(a[i] == b[j]){
            f(i+1,j+1,maxl+1);
        }else {
            f(i+1,j,maxl);
            f(i,j+1,maxl);
        }
    }*/

    // distance

    char[] a = "mitcmu".toCharArray();
    char[] b = "mtacnu".toCharArray();
    int n = 6;
    int m = 6;
    int minDist = Integer.MAX_VALUE;

    public void lwstBT(int i,int j,int edist){
        if(i == n || j == m){
            if(i<n) edist += n-i;
            if(j<m) edist += m-j;
            if(edist > minDist) minDist = edist;
        }
        if(a[i] == b[j]){
            lwstBT(i+1,j+1,edist);
        }else {
            lwstBT(i+1,j,edist+1);
            lwstBT(i,j+1,edist+1);
            lwstBT(i+1,j+1,edist+1);
        }
    }

}

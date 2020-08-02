package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;
import sun.security.util.Length;

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
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int f1 = 1;
        int f2 = 2;
        int f = 0;
        for (int i = 3; i <= n; i++) {
            f = f1 +f2;
            f1 = f2;
            f2 = f;
        }
       return f;
    }

    public int climbStairs2(int n) {
        if(n == 1 )return  1;
        if(n == 2) return  2;
        return climbStairs(n-1) +climbStairs( n-2);
    }
}

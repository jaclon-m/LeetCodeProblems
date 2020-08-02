package com.jaclon.datestructure.recurisonanditeration;

/**
 * 递归超时的典型例子：本例中递归会导致重复计算
 *  详情可以参考 回溯、动态规划相关课程
 * @author jaclon
 * @date 2020/8/2
 */
public class ClimbStairs_70 {

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

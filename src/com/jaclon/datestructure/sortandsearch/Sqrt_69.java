package com.jaclon.datestructure.sortandsearch;

/**
 * https://www.cnblogs.com/carlosouyang/p/10821793.html 或者参考官网
 * @author jaclon
 * @date 2019/8/29
 */
public class Sqrt_69 {

    public int mySqrt(int x) {
        int low = 0, high = x, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if ((long)mid * mid <= x) {
                ans = mid;
                //防止死循环
                low = mid + 1;
            } else {
                //防止死循环
                high = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x){
        if( x == 0 || x == 1){
            return x;
        }
        int a = x >> 1;
        while (a> x/a){
            a = (a + x/a)/2;
        }
        return a;
    }
}

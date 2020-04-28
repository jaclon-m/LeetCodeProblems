package com.jaclon.datestructure.sortandsearch;

/**
 * @author jaclon
 * @date 2019/8/29
 */
public class Sqrt_69 {

    public int mySqrt(int x) {
        //还有bug,暂时未完成
        int low = 1 ,high = x;
        //防止溢出
        while (low <= high){
            if(high - low == 1){
                return low;
            }
            int mid = low + ((high - low)>>1);
            if(x/mid > mid){

                low = mid + 1;
            }else if(x / mid < mid){

                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
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

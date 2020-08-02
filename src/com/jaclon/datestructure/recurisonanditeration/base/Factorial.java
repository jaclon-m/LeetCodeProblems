package com.jaclon.datestructure.recurisonanditeration.base;

/**
 * 阶乘
 * @author jaclon
 * @date 2020/7/31
 */
public class Factorial {

    public int getFactorial(int n){
        if(n == 1)return 1;
        return n*getFactorial(n-1);
    }
}

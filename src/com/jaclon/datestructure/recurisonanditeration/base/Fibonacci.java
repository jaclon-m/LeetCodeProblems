package com.jaclon.datestructure.recurisonanditeration.base;

/**
 * @author jaclon
 * @date 2020/7/31
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(  getFibonacci(12));
    }

    public static int getFibonacci(int n){
        if(n == 0 ||n == 1) return 1;
        return getFibonacci(n-1) + getFibonacci(n-2);
    }
}

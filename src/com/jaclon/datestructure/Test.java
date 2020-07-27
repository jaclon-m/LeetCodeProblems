package com.jaclon.datestructure;

/**
 * @author jaclon
 * @date 2020/7/21
 */


import sun.misc.Unsafe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jaclon
 * @date 2019/9/12
 */
public class Test {

    public static void main(String[] args){

    }

    public static char find(char[] chars1,char[]chars2){
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i]){
                return chars1[i];
            }else {
                i++;
            }
        }
        return '-';
    }
}

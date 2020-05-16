package com.jaclon.datestructure.thought;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法-0_1背包问题
 * @author jaclon
 * @date 2020/5/15
 */
public class Backpack {
    //0-1背包

    private int maxW = Integer.MIN_VALUE;
    List <Integer> list = new LinkedList <>();
    private void f(int i ,int cw,int[] items,int n,int w){
        if(i == n || cw == w){
            if(cw > maxW) maxW = cw;
            return;
        }
        //当前物品不装入背包的情况
        f(i+1,cw,items,n,w);
        //当前物品装入背包的情况
        if(cw+items[i] <=cw){
            list.add(i);
            f(i+1,cw+items[i],items,n,w);
        }
    }

    //正则表达式


}

package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        char[] array = s.toCharArray();
        int a = 0,b = 0;
        int maxl = 0;
        while (b+1 <array.length){
            if(array[b]!= array[b+1]){
                int value = b-a+2;
                maxl = maxl > value?maxl:value;
            }else {
                a = b+1;
            }
            b = b+1;
        }
        return  maxl;
    }
}

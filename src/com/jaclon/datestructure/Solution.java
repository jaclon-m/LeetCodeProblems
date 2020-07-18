package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

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
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap <>();
        int n = s.length();
        int ans = 0;
        for (int i = 0, j = 0; j < n ; j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(j-i+1,ans);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}

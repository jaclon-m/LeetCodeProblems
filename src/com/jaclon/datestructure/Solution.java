package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;
import com.jaclon.datestructure.thought.LwstCharMatch;
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
    public int mySqrt(int x) {
        int low = 0, high = x, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if ((long)mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

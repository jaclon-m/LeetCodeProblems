package com.jaclon.dateStructure.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jaclon
 * @date 2019/8/22
 * @time 9:25
 */
public class LSubString_03 {
    /**
     * 滑动窗口-HashMap
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s){
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for(int i = 0 ,j = 0 ; j < n ; j++){

            if(map.containsKey(s.charAt(j))){
                // 举例：abba
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        HashSet<Character> set = new HashSet <>();
        int ans = 0 , n = s.length();
        int i = 0 , j = 0 ;
        while ( i < n &&  j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    /**
     * 暴力法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0 ; i<n;i++){
            for(int j = i+1 ; j <= n ; j++){
                if(Unique(s,i,j)){
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }

    private boolean Unique(String s, int start , int end){
        Set<Character> set = new HashSet <>();
        for(int i = start ; i < end ; i++){
            if(set.contains(s.charAt(i))){
                return false;
            }else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }
}

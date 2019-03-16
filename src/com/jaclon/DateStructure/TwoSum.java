package com.jaclon.DateStructure;

import com.sun.deploy.util.StringUtils;
import sun.applet.Main;

import java.util.*;
import java.util.Objects;

//两数加和
public class TwoSum {
    //暴力法O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }
    //哈希表，O(n),空间复杂度O(n)
    public int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap <>();
        for(int i = 0;i<nums.length;i++){
            if(map.get(target-nums[i])!= null){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] arr = str.split(",");
        System.out.println(arr.length);
        StringBuffer sr = new StringBuffer();//线程安全
        StringBuilder sbr = new StringBuilder();//线程不安全

        List<String> list = new ArrayList <>();
        list.add("1");
        list.add("2");
        list.add("23");
        for(String s:list){
            if("1".equals(s)){
                list.remove(s);
            }

        }
        for(String s:list){
            System.out.println(s);
        }
    }
}

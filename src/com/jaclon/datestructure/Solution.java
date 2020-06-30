package com.jaclon.datestructure;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * n 皇后问题
 *
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }
        System.out.println(list.size());
        for(String s: list){
            System.out.println(validate(s));
        }
    }

    private static String validate(String s) {
        int n = s.length();
        for (int i = 0; i < n - 2; i++) {
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)){
                s.replaceFirst(s.charAt(i) + "","");
            }
            if(i < n-3 && s.charAt(i) == s.charAt(i+1) && s.charAt(i+2)==s.charAt(i+3)){
                s.replaceFirst(s.charAt(i+2)+ "","");
            }
        }
        return s;
    }


}

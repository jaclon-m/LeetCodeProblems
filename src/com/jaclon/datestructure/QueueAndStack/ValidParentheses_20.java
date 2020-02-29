package com.jaclon.datestructure.QueueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jaclon
 * @date 2019/7/2
 * @time 10:50
 */
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
//determine if the input string is valid.

public class ValidParentheses_20 {
    
    private Map<Character,Character> map;
    
    public ValidParentheses_20(){
        this.map = new HashMap <>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack <>();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                char flag = stack.isEmpty()?'#':stack.pop();
                if(flag != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

package com.jaclon.datestructure.geekbandcard;

import com.jaclon.datestructure.basic.ListNode;
import com.jaclon.datestructure.basic.TreeNode;

import java.util.*;


/**
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {
    /*public boolean isValidBST(TreeNode root) {
        return valid(root,null,null);
    }

    private boolean valid(TreeNode node,Integer below, Integer above){
        if(node == null) return true;

        if(below != null && node.val <= below) return false;
        if(above != null && node.val >= above) return false;

        boolean result;
        result = valid(node.left, below, node.val);
        if(result == false){
            return false;
        }
        result = valid(node.right,node.val,above);
        return result;
    }*/

}

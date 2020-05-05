package com.jaclon.datestructure.binarytree;

import com.jaclon.datestructure.basic.TreeNode;

/**
 * 1. 乍看起来只要先验证节点满足条件（左孩子小于该节点，右孩子大于该节点），然后递归即可
 * 但是忽略了右子树的左节点也要大于原来的父节点这个条件。因此需要加上上下界条件。
 * 2. 过程中的问题： <= 而不是 <
 * @author jaclon
 * @date 2020/5/4
 */
public class ValidBinarysearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        //return valid(root,null,null);
        return helper(root,null,null);
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
    }

    private boolean helper(TreeNode node, Integer lower,Integer upper){
        //1. terminator
        if(node == null) return true;
        //2. process current logic
        int val = node.val;
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;
        //3 drill down
        //当前值为左子树的最大值
        if(!helper(node.left,lower,val)) return false;
        //当前值为右子树的最小值
        if(!helper(node.right,val,upper)) return false;
        //4. restore current status
        return  true;
    }


}

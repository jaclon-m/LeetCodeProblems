package com.jaclon.datestructure.binarytree;

import com.jaclon.datestructure.basic.TreeNode;

import java.util.LinkedList;

/**
 * 输出二叉树最大深度和所在节点
 * 天坑啊：LinkedList 的 push方法是放在链表的头部的，也就是说它实现的是栈的后进先出功能
 * @author jaclon
 * @date 2019/9/28
 */
public class MaxDepthAndNodeOfTree {

    private  static LinkedList<TreeNode> result = null;
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);
        longPath(treeNode,new LinkedList <TreeNode>() ,0,-1);
    }

    public static void longPath(TreeNode root, LinkedList<TreeNode>list, int sum, int max){
        list.push(root);
        //sum++ 默认每棵树的的值为1
        sum += root.val;

        if (root.left == null && root.right == null){

            if(sum > max){
                max = sum;
                result =  new LinkedList <>(list);
            }
        }
        if(root.left != null){
            longPath(root.left,list,sum,max);
        }
        if(root.right != null){
            longPath(root.right,list,sum,max);
        }
        list.pop();
    }
}

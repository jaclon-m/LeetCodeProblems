package com.jaclon.dateStructure.binarytree;

import com.jaclon.dateStructure.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jaclon
 * @date 2019/9/28
 */
public class LevelOrderTraOfBT_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList <List <Integer>> lists = new LinkedList <>();
        if(root == null){
            return lists;
        }
        LinkedList<TreeNode> listQueue = new LinkedList <>();
        listQueue.add(root);

        while (!listQueue.isEmpty()){
            int size = listQueue.size();
            LinkedList <Integer> linkedList = new LinkedList <>();


            while (size-- > 0){
                TreeNode node = listQueue.peek();
                linkedList.add(node.val);
                listQueue.pop();

                if(node.left != null){
                    listQueue.add(node.left);
                }
                if(node.right != null){
                    listQueue.add(node.right);
                }

            }

            lists.add(linkedList);
        }

        return lists;

    }
}

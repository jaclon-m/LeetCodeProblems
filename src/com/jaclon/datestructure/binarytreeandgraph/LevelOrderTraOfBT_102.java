package com.jaclon.datestructure.binarytreeandgraph;

import com.jaclon.datestructure.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jaclon
 * @date 2019/9/28
 */
public class LevelOrderTraOfBT_102 {
    /**
     * 比较原答案的优势是使用了queue。
     * 注意：while(size -- > 0) 这里的思路是把一层的先遍历完。自己做的时候没加这个条件会导致先遍历左子树的下层。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList <>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList <>();
            while (size -- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

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

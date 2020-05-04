package com.jaclon.datestructure.binarytree;

/**
 * 二叉查找树的基本操作 - 查找、插入、删除
 * @author jaclon
 * @date 2020/5/3
 */
public class BinarySearchTree {

    private Node tree;
    /**
     * 查找
     * @param data
     * @return
     */
    public Node find (int data){
        Node node = tree;
        while (node != null && node.data !=data){
            if(data < node.data){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return node;
    }

    public Node find2(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    /**
     * 插入
     * @param data
     */
    public void insert(int data){
        if(tree== null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null){
            if(p.data > data){
                if(p.left == null){
                    p.left = new Node(data);
                    break;
                }else {
                    p = p.left;
                }
            }else if(p.data <data){
                if(p.right == null){
                    p.right= new Node(data);
                }else {
                    p = p.right;
                }
            }else {
                break;
            }
        }
    }

    public void insert2(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data){
        //找到要删除的节点
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data){
            pp = p;
            if(p.data < data){
                p = p.right;
            }else {
                p = p.left;
            }
        }
        if(p == null) return;

        //要删除的节点有两个子节点
        if (p.left != null && p.right != null){
            //寻找右子树中最小的节点，也可以找左子树中最大的节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }
            //迁移数据
            p.data = minP.data;
            //和后面只有一个子树的情况合起来使用
            pp = minPP;
            p =minP;
        }
        //只有一个子节点或没有子节点
        Node child;
        if(p.left != null){
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }else {
            child = null;
        }
        if (pp == null) {
            tree = child;
        }
        if(pp.right == p){
            pp.right = child;
        }else {
            pp.left = child;
        }
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.binarytreeandgraph;

import com.jaclon.datestructure.basic.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname TopoSort
 * @Description 拓扑排序
 *
 * @author jaclon
 * @date 2020/5/21
 */
public class TopoSort extends Graph {

    public void topoSortByKahn(){
        int[] degree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                degree[adj[i].get(j)]++;
            }
        }
        Queue<Integer> queue =new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int i = queue.poll();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                degree[adj[i].get(j)] --;
                if(degree[adj[i].get(j)] == 0){
                    queue.offer(adj[i].get(j));
                }
            }
        }
    }

    /**
     * TODO
     * 深度优先算法
     */
    public void topoSortByDFS(){

    }
}

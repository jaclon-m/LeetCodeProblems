/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.binarytreeandgraph;

import com.jaclon.datestructure.basic.Graph;

import java.util.LinkedList;
import java.util.List;
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
     * 深度优先算法
     */
    public void topoSortByDFS(){
        List[] reverseAdj = new LinkedList[v];
        for (int i = 0; i < reverseAdj.length; i++) {
            reverseAdj[i] = new LinkedList();
        }
        //构建逆邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer x = adj[i].get(j);
                reverseAdj[x].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        //dfs
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i,reverseAdj,visited);
            }
        }

    }

    private void dfs(int vertex, List<Integer>[] reverseAdj, boolean[] visited) {
        for (int j = 0; j < reverseAdj[vertex].size(); j++) {
            int w = reverseAdj[j].get(j);
            if(!visited[w]){
                visited[w] = true;
                dfs(w,reverseAdj,visited);
            }
        }
        //不满足循环条件的时候表示订单没有依赖了，可以打印
        System.out.print("->" + vertex);
    }
}

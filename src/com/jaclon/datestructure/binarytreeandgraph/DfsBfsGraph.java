/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.binarytreeandgraph;

import com.jaclon.datestructure.basic.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname DfsBfsGraph
 * @Description 图的深度和广度优先遍历
 *
 * @author jaclon
 * @date 2020/5/21
 */
public class DfsBfsGraph extends Graph {

    public void bfs(int s,int t){
        if(s == t) return;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()){
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int d = adj[w].get(i);
                if(!visited[d]){
                    visited[d] = true;
                    pre[w] = d;
                    if(d == v){
                        print(pre,s,d);
                        return ;
                    }
                    queue.offer(d);
                }
            }
        }
    }

    private void print(int[] pre, int s, int t){
        if(pre[t] != -1 && s != t){
            print(pre,s,pre[t]);
        }

        System.out.println(t + "->");
    }
    //TODO
    boolean found = false;
    public void dfs(int s, int t){

        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        recurDfs(s,t,visited,pre);
        print(pre,s,t);

    }

    private void recurDfs(int w, int t,boolean[] visited,int[] prev){
        if(found) return;
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }
}

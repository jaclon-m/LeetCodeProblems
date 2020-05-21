/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Graph
 * @Description 图
 *
 * @author jaclon
 * @date 2020/5/21
 */

public class Graph { // 无向图
    protected int v; // 顶点的个数
    protected LinkedList<Integer> adj[]; // 邻接表

    public Graph() {
    }

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }


}
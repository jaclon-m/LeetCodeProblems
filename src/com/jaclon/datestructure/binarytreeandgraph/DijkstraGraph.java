package com.jaclon.datestructure.binarytreeandgraph;

import java.util.LinkedList;

/**
 * 单源最短路径-dijkstra算法
 * @author jaclon
 * @date 2020/5/24
 */

public class DijkstraGraph { // 有向有权图的邻接表表示
    private LinkedList <Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public DijkstraGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList <>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 下面这个类是为了dijkstra实现用的
    private class Vertex {
        public int id; // 顶点编号ID
        public int dist; // 从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    // 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    private class PriorityQueue { // 根据vertex.dist构建小顶堆
        private Vertex[] nodes;
        private int count;
        public PriorityQueue(int v) {
            this.nodes = new Vertex[v+1];
            this.count = v;
        }
        public Vertex poll() {
            return null;
        }
        public void add(Vertex vertex) {
            return;
        }
        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
        public void update(Vertex vertex) { return;}
        public boolean isEmpty() { return false;}
    }

    public void dijkstra(int s,int t){// 从顶点s到顶点t的最短路径
        PriorityQueue queue = new PriorityQueue(v);
        boolean[] inqueue = new boolean[v];
        int[] predecessor = new  int[v];
        Vertex[] vertices = new Vertex[v];

        Vertex vertex= vertices[s];
        vertex.dist = 0;
        queue.add(vertex);
        inqueue[s] = true;
        while (!queue.isEmpty()){
            Vertex minVertex = queue.poll();
            if(minVertex.id == t) break;
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge edge = adj[minVertex.id].get(i);
                Vertex nextVertex = vertices[edge.tid];
                if(minVertex.dist+ edge.w < nextVertex.dist){
                    nextVertex.dist = minVertex.dist + edge.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if(inqueue[nextVertex.id]){
                        queue.update(nextVertex);
                    }else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        System.out.print(s);
        print(s ,t, predecessor);
    }

    private void print(int s, int t ,int[] predecessor){
        if(s == t) return;
        print(s,predecessor[t],predecessor);
        System.out.print(" -> " + t);
    }


}

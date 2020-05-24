package com.jaclon.datestructure;

import com.jaclon.datestructure.basic.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;

/**
 * 单源最短路径
 *
 * @author jaclon
 * @date 2020/4/20
 */
public class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        int MaxValue = 6005;
        int[][] graph = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                graph[i][j] = MaxValue;
            }
        }
        int[] distance = new int[N+1];
        for (int i = 1; i < distance.length; i++) {
            distance[i] = MaxValue;
        }
        boolean[] visited = new boolean[N+1];
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int desc = times[i][1];
            int dist = times[i][2];
            graph[src][desc] = dist;
        }
        PriorityQueue <Node> queue = new PriorityQueue <>((a, b) -> a.distance-b.distance);
        distance[K] = 0;
        queue.add(new Node(K,distance[K]));
        while (!queue.isEmpty()){
            Node currNode = queue.poll();
            visited[currNode.node] = true;
            for (int i = 1; i < graph[currNode.node].length; i++) {
                if(visited[i]){
                    continue;
                }else {
                    if(distance[i] > graph[currNode.node][i]+ distance[currNode.node] ){
                        distance[i] = graph[currNode.node][i] + distance[currNode.node];
                        queue.offer(new Node(i,distance[i]));
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i < distance.length ; i++) {
            res = Math.max(res,distance[i]);
        }
        return  res == MaxValue?-1:res;
    }

    class Node{
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}

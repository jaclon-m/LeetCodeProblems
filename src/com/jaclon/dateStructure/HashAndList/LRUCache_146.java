package com.jaclon.dateStructure.HashAndList;

import java.util.HashMap;

/**
 * 1. 添加内部类CacheNode，含有pre,head指针
 * 2. 实现关于CacheNode双向链表的四个方法：addNode，removeNode，moveToHead,popTail
 * 3. LRUCahce类中添加成员变量：size,capacity,head,tail,HashMap,实现其构造方法。
 *  注意，这里加了头尾哨兵指针，减少空值判断情况，可以对比一下没有哨兵时的实现，要简洁很多。
 * 4. 实现LRUCache的get put 方法
 * @author jaclon
 * @date 2019/9/19
 */
public class LRUCache_146 {

    //可以使用map.size()来替代，也可以在put中自己控制
    private int size;
    private int capacity;
    private CacheNode head,tail;
    private HashMap<Integer,CacheNode> cache = new HashMap <>();

    public LRUCache_146(int capcity){
        this.size = 0;
        this.capacity = capcity;
        head = new CacheNode();
        // head.pre = null;
        tail = new CacheNode();
        //tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        CacheNode cacheNode = cache.get(key);
        if(cacheNode == null){
            return -1;
        }

        moveToHead(cacheNode);
        return  cacheNode.value;
    }

    public void put(int key ,int value){
        CacheNode cacheNode = cache.get(key);
        if(cacheNode == null){
            if(cache.size() >= capacity){

                CacheNode res = popTail();
                cache.remove(res.key);
            }

            CacheNode node = new CacheNode();
            node.key = key;
            node.value = value;

            addNode(node);
            cache.put(key,node);
        }else {
            cacheNode.value =value;
            moveToHead(cacheNode);
        }

    }

    class CacheNode {

        private int key;
        private int value;
        private CacheNode pre;
        private CacheNode next;

    }

    private void addNode(CacheNode cacheNode){
        //1.先连接CacheNode，2. 连接head.next 3.连接head
        cacheNode.next = head.next;
        cacheNode.pre = head;
        head.next.pre = cacheNode;
        head.next = cacheNode;
    }

    private void removeNode(CacheNode cacheNode){
        CacheNode pre = cacheNode.pre;
        CacheNode next = cacheNode.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(CacheNode cacheNode){
        removeNode(cacheNode);
        addNode(cacheNode);
    }

    private CacheNode popTail(){
        CacheNode res = tail.pre;
        removeNode(res);
        return res;
    }
}



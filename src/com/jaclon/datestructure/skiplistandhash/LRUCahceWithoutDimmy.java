package com.jaclon.datestructure.skiplistandhash;

import java.util.HashMap;

/**
 * @author jaclon
 * @date 2019/9/19
 */
public class LRUCahceWithoutDimmy<K,V> {

    private int currentCacheSize;
    private int CacheCapcity;
    private HashMap<K, CacheNode> caches;
    private CacheNode first;
    private CacheNode last;

    public LRUCahceWithoutDimmy(int size) {
        currentCacheSize = 0;
        this.CacheCapcity = size;
        caches = new HashMap <K, CacheNode>(size);
    }

    /**
     * 插入元素 （超容量移除队尾元素，新元素插队头）
     * 1.put前先校验缓存size已达最大容量，则remove 队尾的key
     * 2.为超容量，则赋值node，并把node移动到队头
     *
     * @param k
     * @param v
     */
    public void put(K k, V v) {
        CacheNode node = caches.get(k);
        if (node == null) {
            //1.put前先校验缓存size已达最大容量，则remove 队尾的key
            if (caches.size() >= CacheCapcity) {
                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = k;
        }
        node.value = v;
        //2.把node移动到队头
        moveToFirst(node);
        caches.put(k, node);
    }

    /**
     * 获取元素 命中后将该元素移至对头
     *
     * @param k
     */
    public Object get(K k) {
        CacheNode node = caches.get(k);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    /**
     * 获取元素 命中后将该元素移至对头
     *
     * @param k
     */
    public Object remove(K k) {
        CacheNode node = caches.get(k);
        if (node != null) {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node == first) {
                first = node.next;
            }
            if (node == last) {
                last = node.pre;
            }
        }

        return caches.remove(k);
    }

    public void clear() {
        first = null;
        last = null;
        caches.clear();
    }


    private void moveToFirst(CacheNode node) {
        if (first == node) {
            return;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node == last) {
            last = last.pre;
        }
        if (first == null || last == null) {
            first = last = node;
            return;
        }

        node.next = first;
        first.pre = node;
        first = node;
        first.pre = null;

    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CacheNode node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }

        return sb.toString();
    }

    class CacheNode {
        CacheNode pre;
        CacheNode next;
        Object key;
        Object value;

        public CacheNode() {

        }
    }

    public static void main(String[] args) {
        LRUCahceWithoutDimmy <Integer, String> lru = new LRUCahceWithoutDimmy <Integer, String>(3);
        lru.put(1, "a");    // 1:a
        System.out.println(lru.toString());
        lru.put(2, "b");    // 2:b 1:a
        lru.put(3, "c");    // 3:c 2:b 1:a
        lru.put(4, "d");    // 4:d 3:c 2:b
        lru.put(1, "aa");   // 1:aa 4:d 3:c
        lru.get(1);         // 1:aa 5:e 2:bb
        lru.remove(12);     // 1:aa 5:e 2:bb
        lru.remove(1);      //5:e 2:bb
    }
}

//https://blog.csdn.net/Daybreak1209/article/details/82789549

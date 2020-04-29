/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.skiplistandhash;


/**
 * @author jaclon
 * @Classname HashTable
 * @Description 散列表实现-链表法解决冲突
 * @date 2020/4/28
 */
public class HashTable<K, V> {
    /**
     * 默认散列表长度
     */
    private static final int DEFAULT_INITAL_CAPICITY = 1 << 4;
    /**
     * 装载因子
     */
    private static final float LOAD_FACTORY = 0.75f;
    /**
     * 初始化数组
     */
    private Entry<K, V>[] table;
    /**
     * 实际元素数量
     */
    private int size = 0;

    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_INITAL_CAPICITY];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 新增
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {

    }

    /**
     * 散列函数
     *
     * @param key
     * @return
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
    }

    /**
     * 扩容
     */
    private void resize() {
        Entry<K,V>[] oldtable = table;
        table = (Entry<K,V>[])new Entry[table.length*2];
        for (int i = 0; i < oldtable.length; i++) {
            if(oldtable[i] ==null || oldtable[i].next == null){
                continue;
            }
            Entry<K,V> e = oldtable[i];
            while (e.next !=null){
                e = e.next;
                int index = hash(e.key);
                if(table[index] == null){
                    //use++;
                    table[index] = new Entry<>(null,null,null);
                }
                table[index].next = new Entry<>(e.key,e.value,table[index].next);
            }
        }
    }

    /**
     * 删除
     *
     * @param key
     */
    public void remove(K key) {

    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return null;
    }
}

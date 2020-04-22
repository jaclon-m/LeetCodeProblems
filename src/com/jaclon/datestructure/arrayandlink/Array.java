package com.jaclon.datestructure.arrayandlink;

/**
 * @author jaclon
 * @date 2020/4/22
 * 数组实现，支持插入、删除、按照下标随机访问
 */
public class Array {

    //定义整型数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;

    //构造方法，定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count=0;//一开始一个数都没有存所以为0
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index){
        if(index < 0 || index >= count) return -1;
        return data[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value){
        if(count == n){
            System.out.println("数组已满");
            return false;
        }

        if(index < 0 || index > count){
            return false;
        }

        for (int i = count; i >index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }
    //根据索引，删除数组中元素
    //注意边界条件的判断
    public boolean delete(int index){
        if(index < 0 || index >= count) return false;
        for (int i = index; i < count-1; i++) {
            data[i] = data[i+1];
        }
        count--;
        return true;
    }
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

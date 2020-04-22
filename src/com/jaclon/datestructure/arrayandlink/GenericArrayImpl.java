package com.jaclon.datestructure.arrayandlink;

import sun.security.util.Length;

import java.io.DataInput;
import java.util.Arrays;

/**
 * @author jaclon
 * @date 2020/4/22
 */
public class GenericArrayImpl<T> implements GenericArray<T> {
    //数组大小
    private int size;
    //定义一个数组
    private T data[];

    public GenericArrayImpl(int capciaty) {
        data = (T[])new Object[capciaty];
        this.size = 0;
    }

    public GenericArrayImpl() {
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    @Override
    public int getCapciaty() {
        return data.length;
    }

    /**
     * 获取数组的大小
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, T element) {
        if(index < 0 || index >size){
            throw new IllegalArgumentException("index is Illegal");
        }
        if(data.length ==size){
            resize(2*size);
        }
        for (int i = size; i > index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public void addFirst(T element) {
        add(0,element);
    }

    @Override
    public void addLast(T element) {
        add(size,element);
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 修改索引index位置的元素为e
     * @param index
     * @param element
     */
    @Override
    public void set(int index, T element) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = element;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中e所在元素的索引，不存在返回-1
     * @param element
     * @return
     */
    @Override
    public int find(T element) {
        for (int i = 0; i < size; i++) {
            if(element.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组位置为index的元素，返回删除的元素
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index  is  illegal");
        }
        T res = data[index]; // 获取结果
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i]; // data[index]
        }
        size--;  //进行元素个数-1
        if(size == data.length/4 && data.length/2!=0)  resize(data.length/2);  //如果元素的个数小于容量的1/4 ，我们就进行缩容操作 到容量的1/2
        return res;
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public void removeElement(T element) {
        int index = find(element);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * 扩容
     * @param index
     */
    private void resize(int index){
        T[] data2 = (T[]) new Object[index];
        for (int i = 0; i < size; i++) {
            data2[i] =data[i];
        }
        data = data2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size -1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}

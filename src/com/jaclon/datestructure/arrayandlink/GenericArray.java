package com.jaclon.datestructure.arrayandlink;

/**
 * @author jaclon
 * @date 2020/4/22
 * 动态扩容的数组
 */
public interface GenericArray<T> {
    public int getCapciaty();

    public int getSize();

    public boolean isEmpty();

    public void add(int index, T element);

    public  void   addFirst( T element);

    public  void  addLast(T element);

    public T  get(int index);

    public  void  set(int index,T element);

    public  void print();

    public boolean contains(T element);

    public int find(T element);

    public  T  remove(int index);

    public  T  removeFirst();

    public  T  removeLast();

    public  void removeElement(T element);

}

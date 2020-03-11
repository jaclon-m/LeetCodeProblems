package com.jaclon.datestructure.array2link.basic;

import java.util.Vector;

/**
 * @author jaclon
 * @date 2020/3/7
 */
public class ArrayTest {


}

class Array1{
    private int count;
    private int defaultCount=10;
    /**
     * 当前数组下标指针
     */
    private int currentIndex = 0;
    private int[] array;

    public Array1() {
        array = new int[defaultCount];
        this.count = defaultCount;
    }

    public Array1(int count) {
        array = new int[count];
        this.count = count;
    }
    public void add(int n){
        if(currentIndex == count){
            array = resize();
        }
        array[currentIndex++] = n;
    }

    public void add(int n,int index){
        if(currentIndex == count){
            array = resize();
        }
        if(index >=currentIndex || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = currentIndex; i >index ; i--) {
            array[i] = array[i-1];
        }
        array[index] = n;
    }

    private int[] resize() {
        int[] newArray = new int[count*2];
        count = count*2;
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public void remove(){

    }
}

package com.jaclon.dateStructure.QueueAndStack;

import java.util.Stack;

public class MyQueue {

    /**
     * 要注意空值问题，使用in和out的方式巧妙的利用pop函数自身空值判断代替了我们空值判断。
     */

    private Stack<Integer> in = new Stack <>();
    private Stack<Integer> out = new Stack <>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }



    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }

    private void in2out() {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }
}

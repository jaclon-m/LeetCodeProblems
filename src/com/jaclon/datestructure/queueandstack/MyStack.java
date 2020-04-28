package com.jaclon.datestructure.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue = new LinkedList <>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /**
     * 不再像MyQueue一样使用双队列的原因在于
     * 用栈实现队列的时候出MyQueue时需要将底部元素放到顶部但无法直接取底部元素。
     * 用队列实现栈的时候入Mystack需要将新的元素放入队列最前面可以直接取底部元素放到最顶部，使用其自身即可
     */
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count-- > 1){
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

package com.halen.chapter01;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStacksQueue<E> {

    private Stack<E> stackPush;
    private Stack<E> stackPop;

    public TwoStacksQueue() {
        this.stackPop = new Stack<>();
        this.stackPush = new Stack<>();
    }

    public void add(E e) {
        stackPush.push(e);
    }

    public E poll() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public E peek() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public boolean isEmpty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    public static void main(String[] args) {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}

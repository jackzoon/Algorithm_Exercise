package com.halen.chapter01;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer num) {
        stackData.push(num);
        if (stackMin.isEmpty()) {
            stackMin.push(num);
            return;
        }
        int min = stackMin.peek() < num ? stackMin.peek() : num;
        stackMin.push(min);
    }

    public Integer pop() {
        stackMin.pop();
        return stackData.pop();
    }

    public Integer peek() {
        return stackData.peek();
    }

    public Integer getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}

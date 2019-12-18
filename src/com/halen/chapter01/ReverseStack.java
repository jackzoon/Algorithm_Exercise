package com.halen.chapter01;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 */
public class ReverseStack {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement2(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement2(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse2(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement2(stack);
        reverse2(stack);
        stack.push(i);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse2(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}

package com.halen.chapter01;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 生成窗口最大值数组
 */
public class MaxWindow {

    public static int[] getMaxWindow1(int[] arr, int w) {

        int left = 0, right = w - 1;
        int[] res = new int[arr.length - w + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = getMax(arr, left++, right++);
        }
        return res;
    }

    public static int[] getMaxWindow2(int[] arr, int w) {
        
        int[] res = new int[arr.length - w + 1];
        Deque<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static int getMax(int[] arr, int left, int right) {
        int max = arr[left];
        for (int i = left + 1; i <= right; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 4, 3, 3, 6, 7};
        arr = getMaxWindow2(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

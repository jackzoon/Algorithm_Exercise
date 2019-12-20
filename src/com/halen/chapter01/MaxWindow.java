package com.halen.chapter01;

import java.util.Arrays;

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

    public static int getMax(int[] arr, int left, int right) {
        int max = arr[left];
        for (int i = left + 1; i <= right; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 4, 3, 3, 6, 7};
        arr = getMaxWindow1(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

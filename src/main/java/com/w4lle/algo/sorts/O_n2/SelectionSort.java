package com.w4lle.algo.sorts.O_n2;

/**
 * Created by w4lle on 2018/11/29.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 选择排序，类似插入排序，分为未排序区间和已排序区间，从未排序区间中找到最小的数，插入已排序区间最右
 * <p>
 * 最好时间复杂度：O(n^2)
 * <p>
 * 最坏时间复杂度 O(n^2)
 * <p>
 * 平均时间复杂度 O(n^2)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * <img src="https://ws2.sinaimg.cn/large/006tNbRwly1fxp2qjv8bcj31380u0n1r.jpg">
 */
public class SelectionSort {
    public static void selectionSort(int[] arrays) {
        int length;
        if (arrays == null || (length = arrays.length) == 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            int current = arrays[i];
            int min = current;
            int minIndex = i;

            for (int j = i; j < length - 1; j++) {
                if (arrays[j] < min) {
                    min = arrays[j];
                    minIndex = j;
                }
            }
            arrays[minIndex] = current;
            arrays[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8, 1, 9};
        selectionSort(arr);
        for (int v :
                arr) {
            Log.d(v + ", ");
        }
    }
}

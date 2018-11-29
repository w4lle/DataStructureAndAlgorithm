package com.w4lle.algo.sorts.O_n2;

/**
 * Created by w4lle on 2018/11/29.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 插入排序，选取端点一个元素作为有序集起点，依次向有续集中插入数据并保持有序
 * <p>
 * 最好时间复杂度：O(n)
 * <p>
 * 最坏时间复杂度：O(n^2)
 * <p>
 * 平均时间复杂度：O(n^2)
 * <p>
 * 空间复杂度：O(1) 即原地排序
 * <p>
 * 稳定排序算法，相同值的情况下不变换位置
 * <p>
 * <img src="https://ws4.sinaimg.cn/large/006tNbRwly1fxp1aokybdj319n0u0ads.jpg">
 */
public class InsertionSort {
    public static void insertionSort(int[] arrays) {
        int length;
        if (arrays == null || (length = arrays.length) == 0) {
            return;
        }

        for (int i = 1; i < length; i++) {
            int current = arrays[i];
            int j = i - 1;

            //j可以理解为坐半部分已有续集
            for (; j >= 0; j--) {
                if (current < arrays[j]) {
                    //小于有续集左边最大值
                    //依次向右交换位置
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8, 1, 9};
        insertionSort(arr);
        for (int v :
                arr) {
            Log.d(v + ", ");
        }
    }
}

package com.w4lle.algo.sorts.O_n2;

/**
 * Created by w4lle on 2018/11/29.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 冒泡排序
 * <p>
 * 最好时间：O(n)
 * <p>
 * 最坏时间：O(n^2)
 * <p>
 * 平均时间复杂度：取有序度中间值，O(n^2)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定排序算法，相同值的情况下不变换位置
 * <p>
 * <img src="https://ws2.sinaimg.cn/large/006tNbRwly1fxp10flrexj30wo0u0gvl.jpg">
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int length;
        if (array == null || (length = array.length) == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            //提前结束标志
            boolean changeFlag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    changeFlag = true;
                }
            }
            if (!changeFlag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 6, 2, 8, 5, 0, 1};
        bubbleSort(array);
        for (int v :
                array) {
            Log.d(String.valueOf(v) + ", ");
        }
    }
}

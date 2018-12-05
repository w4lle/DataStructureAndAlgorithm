package com.w4lle.algo.sorts.O_nlogn;

import com.w4lle.algo.Log;

/**
 * Created by w4lle on 2018/12/5.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


/**
 * 快速排序，挖坑排序，分治
 * <p>
 * 最好时间复杂度：O(nlogn)
 * <p>
 * 最坏时间复杂度: O(n^2)
 * <p>
 * 平均时间负载度：O(nlogn)
 * <p>
 * 空间复杂度：O(1)，原地排序，所以比归并排序效率高
 * <p>
 * 非稳定排序算法，相同值的位置可能会改变
 *
 * <img src="https://ws1.sinaimg.cn/large/006tNbRwly1fxw08wpwwmj30wk0u0jxj.jpg">
 */
public class QuickSort {
    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

//        int pivotIndex = findPivotIndex(array, start, end);
        int pivotIndex = findWakengPivotIndex(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
    }

    /**
     * 挖坑排序，优化方案，不用每次比较都交换数据
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int findWakengPivotIndex(int[] array, int start, int end) {
        int leftIndex = start;
        int rightIndex = end;
        int pivot = array[rightIndex];//挖第一个坑
        while (leftIndex < rightIndex) {
            //循环直到 leftIndex==rightIndex
            while (leftIndex < rightIndex && array[leftIndex] < pivot) {
                //在左边直到找到一个大于pivot的数
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                //填坑，并且再挖一个坑
                array[rightIndex] = array[leftIndex];
                //右边后退一步
                rightIndex--;
            }

            while (leftIndex < rightIndex && array[rightIndex] > pivot) {
                //在右边直到找到一个小于pivot的数
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                //填坑，并且再挖一个坑
                array[leftIndex] = array[rightIndex];
                //左边前进一步
                leftIndex++;
            }
        }

        //退出时，leftIndex==rightIndex，填最后一个坑
        array[rightIndex] = pivot;
        Log.d("wakeng pivotIndex: " + leftIndex);
        return leftIndex;
    }

    /**
     * 找到中间点的index
     * <p>
     * 此方法交换次数较多，每次比较都要交换，不建议使用
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int findPivotIndex(int[] array, int start, int end) {
        int leftIndex = start;
        //选取最后一个为临界点
        int pivot = array[end];
        for (int rightIndex = start; rightIndex < end; rightIndex++) {
            //如果右边小于临界点，交换处理，并且左边index前进
            //这样做完之后，leftIndex左边的数是全部小于pivot 的
            if (array[rightIndex] < pivot) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
            }
        }
        //交换pivot和leftIndex值，此时的leftIndex左边全是小于pivot的数
        swap(array, end, leftIndex);
        Log.d("pivotIndex: " + leftIndex);
        return leftIndex;
    }

    private static void swap(int[] array, int src, int des) {
        int tmp = array[src];
        array[src] = array[des];
        array[des] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8, 1, 9};
        sort(arr);
        for (int v :
                arr) {
            Log.d(v + ", ");
        }
    }
}

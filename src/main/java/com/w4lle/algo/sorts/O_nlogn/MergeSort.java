package com.w4lle.algo.sorts.O_nlogn;

/**
 * Created by w4lle on 2018/11/29.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;
import com.w4lle.algo.sorts.Sortable;

/**
 * 归并排序，分治
 * <p>
 * 递推公式：merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
 * <p>
 * 终止条件：p >= r 不用再继续分解
 * <p>
 * 最好时间复杂度： O(nlogn)
 * <p>
 * 最坏时间复杂度：O(nlogn)
 * <p>
 * 平均时间负载度：O(nlogn)
 * <p>
 * <img src="https://ws1.sinaimg.cn/large/006tNbRwly1fxusy0mgwbj30u00ukh1a.jpg">
 * <p>
 * 空间复杂度： O(n) 非原地排序算法(O(1))，每次合并后新申请的内存空间都会被释放，所以是O(n)
 * <p>
 * 稳定排序
 * <p>
 * <img src="https://ws4.sinaimg.cn/large/006tNbRwly1fxq3ihz1zaj30x10u0wmk.jpg">
 */
public class MergeSort implements Sortable {
    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
//        Log.d("mergeSort start : " + start + ", middle : " + middle + ", end : " + end);

        //分解为左边排序和右边排序
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        //将左右两个有续集合并
        mergeSortedArray(array, start, middle, end);
    }

    /**
     * 合并两个已排序的数组
     *
     * @param array
     * @param start  左边已排序区间的起点
     * @param middle 中间位置
     * @param end    右边已排序区间结束位置
     */
    private static void mergeSortedArray(int[] array, int start, int middle, int end) {
        int[] sorted = new int[end - start + 1];

        int sortedIndex = 0;
        int leftIndex = start, rightIndex = middle + 1;
        int leftEnd = middle, rightEnd = end;
//        Log.d("mergeSortedArray start : " + start + ", middle : " + middle + ", end : " + end);

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            //依次比较，将左右较小的数放入新数组
            if (array[leftIndex] <= array[rightIndex]) {
                sorted[sortedIndex] = array[leftIndex];
                leftIndex++;
            } else {
                sorted[sortedIndex] = array[rightIndex];
                rightIndex++;
            }
            sortedIndex++;
        }

        //copy剩余区间
        int remainStart = leftIndex, remainEnd = leftEnd;
        if (rightIndex <= rightEnd) {
            remainStart = rightIndex;
            remainEnd = rightEnd;
        }

        //剩余数据
        while (remainStart <= remainEnd) {
            sorted[sortedIndex++] = array[remainStart++];
        }

/*        for (int v :
                sorted) {
            Log.d(v + ", ");
        }*/

        //拷贝回原始数组
        System.arraycopy(sorted, 0, array, start, end - start + 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8, 1, 9};
        mergeSort(arr);
        for (int v :
                arr) {
            Log.d(v + ", ");
        }
    }

    @Override
    public void sort(int[] array) {
        mergeSort(array);
    }
}

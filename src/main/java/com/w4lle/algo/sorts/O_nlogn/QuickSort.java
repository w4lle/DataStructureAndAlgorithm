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
 * <p>
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
        int pivot = array[rightIndex];//挖第一个坑，选取数组最后一个元素
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
//        Log.d("start : " + start + ", end : " + end);
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

    /**
     * 拓展题，在 O(n) 时间内找到第K个小的数，如下数组，找到第三小的数，即3
     * <p>
     * 可以使用快排，按降序排列，A[0..n-1] -> A[0..p-1]、A[p]、A[p+1..n-1]
     * <p>
     * 如果 K=p+1，则A[P]即时第K小的数
     * <p>
     * 如果 K>p+1，则目标数在A[p+1..n-1]区间，再按照上面的思路递归该区间
     * <p>
     * 同理，如果 K<p-1，则目标在A[0..p-1]区间，按照上面的思路递归该区间
     * <p>
     * 时间复杂度：第一次分区查找，我们需要对大小为 n 的数组执行分区操作，需要遍历 n 个元素。
     * <p>
     * 第二次分区查找，我们只需要对大小为 n/2 的数组执行分区操作，需要遍历 n/2 个元素。
     * <p>
     * 依次类推，分区遍历元素的个数分别为、n/2、n/4、n/8、n/16.……直到区间缩小为 1。
     * <p>
     * 如果我们把每次分区遍历的元素个数加起来，就是：n+n/2+n/4+n/8+…+1。这是一个等比数列求和，最后的和等于 2n-1。
     * <p>
     * 所以，上述解决思路的时间复杂度就为 O(n)。
     *
     * @param array
     * @param k     第k小
     * @return 结果，第k小的数
     */
    public static int findKMin(int[] array, int k, int start, int end) {
        if (array == null || array.length == 0) {
            return -9999;
        }
        if (k < 0 || k > end + 1) {
            return -9999;
        }
        int pivotIndex = findWakengPivotIndex(array, start, end);

        if (k == pivotIndex + 1) {
            return array[pivotIndex];
        } else if (k > pivotIndex + 1) {
            return findKMin(array, k, pivotIndex + 1, end);
        } else if (k < pivotIndex + 1) {
            return findKMin(array, k, start, pivotIndex - 1);
        }
        return -999;
    }

    /**
     * 再拓展，现在你有 10 个接口访问日志文件，每个日志文件大小约 300MB，每个文件里的日志都是按照时间戳从小到大排序的。
     * <p>
     * 你希望将这 10 个较小的日志文件，合并为 1 个日志文件，合并之后的日志仍然按照时间戳从小到大排列。
     * <p>
     * 如果处理上述排序任务的机器内存只有 1GB，你有什么好的解决思路，能“快速”地将这 10 个日志文件合并吗？
     *
     */

    public static void mergeLogFiles(int[][] files) {
        int[] array = new int[10];
        array[0] = files[0][0];
        array[1] = files[1][0];
        //...
        //每次找到最小的数
        int min = findKMin(array, 1, 0, array.length - 1);
        //将最小的数存储，并且从该数原始文件中读取下一条数据，继续比较找出最小的数，直到所有文件都空
        //时间复杂度 O(n),空间复杂度 O(1)
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8, 1, 9};
        int k = 2;
//        Log.d("第" + k + "小的数 : " + findKMin(arr, k, 0, arr.length - 1));
        sort(arr);
        for (int v :
                arr) {
            Log.d(v + ", ");
        }
    }
}

package com.w4lle.algo.sorts.O_n;

/**
 * Created by w4lle on 2018/12/6.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;
import com.w4lle.algo.sorts.Sort;
import com.w4lle.algo.sorts.Sortable;

/**
 * 计数排序，可以理解为极端情况下的桶排序，即数据范围不大情况下
 * <p>
 * 有n个数，范围区间m，构建一个大小为m+1的数组，数组存储对应下标值对应数的个数。我们只需要依次扫描每个桶，将桶内的考生依次输出到一个数组中
 * <p>
 * 最好、最坏、平均时间复杂度: O(n)
 * <p>
 * 空间复杂度：O(n)
 * <p>
 * 稳定排序算法
 * <p>
 * 使用条件：
 * <p>
 * 1. 数值范围不大
 * <p>
 * 2. 必须都是正数
 * <p>
 * 适用场景：
 * <p>
 * 1. 100万用户按年龄排序
 * <p>
 * 2. 50万考生按成绩排序
 * <p>
 * <img src="https://ws2.sinaimg.cn/large/006tNbRwly1fxy4xtrasbj30u013z46e.jpg">
 */
public class CountingSort implements Sortable {
    @Override
    public void sort(int[] array) {
        quickSort(array);
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int max = array[0];

        //寻找最大值范围
        for (int v :
                array) {
            if (v > max) {
                max = v;
            }
        }

        //构建一个max+1大的桶
        int[] bucket = new int[max + 1];

        for (int v :
                array) {
            //桶内index对应的数累加
            bucket[v]++;
        }

        //其实到这里，从桶内依次取出数就是有序的了
        //不过为了相同数字的排序稳定性，这里在bucket的数表示小于等于该数的和，并从原始数组从后往前遍历，后面的数就会排在后面

        for (int i = 1; i < bucket.length; i++) {
            //当前位置的数表示小于等于该数的数字个数
            bucket[i] += bucket[i - 1];
        }

        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int current = array[i];
            result[bucket[current] - 1] = current;
            bucket[current]--;
        }

        //拷贝结果
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = Sort.createLargeArray();
        long time = System.currentTimeMillis();
        quickSort(arr);
        Log.d("cost : " + String.valueOf(System.currentTimeMillis() - time));
/*        for (int v :
                arr) {
            Log.d(v + ", ");
        }*/
    }
}

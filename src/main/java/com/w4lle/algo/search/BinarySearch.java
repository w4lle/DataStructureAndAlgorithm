package com.w4lle.algo.search;

/**
 * Created by w4lle on 2018/12/7.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 二分查找，O(logn)
 *
 * 条件：
 *
 * 1. 依赖顺序表结构，如果是链表，时间复杂度退化成 O(n)
 * 2. 有序
 * 3. 太小的数组不适合用二分查找，直接遍历好了
 * 4. 太大的数组也不适合二分查找，需要连续大内存
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int expect) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        return binarySearch(array, 0, array.length - 1, expect);
    }

    public static int binarySearch(int[] array, int low, int high, int expect) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == expect) {
                return mid;
            } else if (array[mid] < expect) {
                low = mid + 1;
            } else if (array[mid] > expect) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Log.d("result " + binarySearch(array, 5));
    }
}

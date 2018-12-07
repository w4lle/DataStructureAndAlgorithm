package com.w4lle.algo.sorts;

import com.w4lle.algo.Log;
import com.w4lle.algo.sorts.O_n.CountingSort;
import com.w4lle.algo.sorts.O_n2.BubbleSort;
import com.w4lle.algo.sorts.O_n2.InsertionSort;
import com.w4lle.algo.sorts.O_n2.SelectionSort;
import com.w4lle.algo.sorts.O_nlogn.MergeSort;
import com.w4lle.algo.sorts.O_nlogn.QuickSort;

import java.util.Random;

/**
 * Created by w4lle on 2018/12/7.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


public class Sort {
    public static int[] createLargeArray() {
        return createLargeArray(0);
    }

    public static int[] createLargeArray(int size) {
        if (size <= 0) {
            size = 100_000;
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = new Random().nextInt(size);
        }
        return result;
    }

    public static void main(String[] args) {
        sort(new BubbleSort());
        sort(new InsertionSort());
        sort(new SelectionSort());
        sort(new MergeSort());
        sort(new QuickSort());
        sort(new CountingSort());
    }

    public static void sort(Sortable sortable) {
        if (sortable == null) {
            return;
        }
        int[] array = createLargeArray();
        Log.d("数组大小 : " + array.length);
        long countSortTime = System.currentTimeMillis();
        sortable.sort(array);
        Log.d(sortable.getClass().getSimpleName() + " end cost : " + String.valueOf(System.currentTimeMillis() - countSortTime));
    }
}

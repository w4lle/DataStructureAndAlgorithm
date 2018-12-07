package com.w4lle.algo.sorts.O_n;

import com.w4lle.algo.sorts.Sortable;

/**
 * Created by w4lle on 2018/12/7.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


/**
 * 基数排序
 * <p>
 * 条件：
 * <p>
 * 1. 可以拆分为独立的位来比较
 * <p>
 * 2. 高位和低位之间存在依赖关系，如果 a 数据的高位比 b 数据高位大，那剩下的低位就不用比较了
 * <p>
 * 从低位开始排序，按计数排序或桶排序
 * <p>
 * 时间复杂度：O(k*n)，k为位数，一般k为常数，所以为 O(n)
 * <p>
 * 稳定排序算法
 * <p>
 * 适用场景：
 * <p>
 * 1. 10万手机号排序
 * <p>
 * 2. 50万英文单词排序，短单词可以补全长度
 * <p>
 * <img src="https://ws1.sinaimg.cn/large/006tNbRwly1fxy7qlrw8kj30u016ddu8.jpg">
 */
public class RadixSort implements Sortable {
    @Override
    public void sort(int[] array) {

    }

    public static void radixSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
    }
}

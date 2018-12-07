package com.w4lle.algo.sorts.O_n;

/**
 * Created by w4lle on 2018/12/6.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


/**
 * 桶排序，划分成m个桶，各个桶内适用快排，最后汇总
 * <p>
 * n个数，m个桶，每个桶内就有 k = n/m 个数，O(m* kO(logk)) = O(n*O(logn/m))，当桶的个数m接近n时，= O(n)
 * <p>
 * <p>
 * 最好时间复杂度: O(n)
 * <p>
 * 最坏时间复杂度：O(nlogn)
 * <p>
 * 是否稳定取决于桶内排序算法，快排-不稳定，归并-稳定
 * <p>
 * 条件：
 * <p>
 * 1. 要排序的数据需要很容易就能划分成 m 个桶，并且，桶与桶之间天然存在顺序关系
 * <p>
 * 2. 数据在各个桶之间的分布是比较均匀的
 * <p>
 * 适用场景：适合适用在外部排序中，即数据存储在外部磁盘中，数据量比较大，内存有限
 * <p>
 * 比如说我们有 10GB 的订单数据，我们希望按订单金额（假设金额都是正整数）进行排序，但是我们的内存有限，只有几百 MB，没办法一次性把 10GB 的数据都加载到内存中。
 * <p>
 * <img src="https://ws3.sinaimg.cn/large/006tNbRwly1fxx59x8io6j30u20u015j.jpg">
 */
public class BucketSort {

}

package com.w4lle.algo.skiplist;

/**
 * Created by w4lle on 2018/12/12.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


/**
 * 跳表，多层索引的链表结构
 *
 * 查找时间复杂度 O(logn),相当于链表实现的二分查找， logn * k k为常数，各级索引之间需要遍历的个数
 * 空间复杂度 O(n) , n/k + n/k^2 +....2 k为各级索引之间间隔节点数 a1(1-q^n)/(1-q)，k为2时 = n/k(1- (1/k)^n)/(1-1/k)
 * @param <T>
 */
public class SkipList<T> {
    class Node {
        /**
         * 下一层索引指针
         */
        private Node down;
        /**
         * 后继指针
         */
        private Node next;
        private T value;
    }

    public int get(T value) {
        return -1;
    }

    public int insert(T value) {
        return -1;
    }

    public int delete(T value) {
        return -1;
    }
}

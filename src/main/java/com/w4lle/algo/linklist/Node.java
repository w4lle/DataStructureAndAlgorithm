package com.w4lle.algo.linklist;

/**
 * Created by w4lle on 2018/11/28.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


public class Node<T> {
    public Node() {
        this(null);
    }

    public Node(T value) {
        this.value = value;
    }

    public Node<T> next;
    public T value;
}

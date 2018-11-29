package com.w4lle.algo.queue;

/**
 * Created by w4lle on 2018/11/29.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 循环队列, 浪费一个空间
 * <img src="https://ws2.sinaimg.cn/large/006tNbRwly1fxowbcwpsej30yu0u00zw.jpg"
 */
public class CircleQueue<T> {
    private int count;
    private int head, tail;
    private T[] arrays;

    public CircleQueue(int size) {
        this.count = size;
        arrays = (T[]) new Object[size];
    }

    public boolean enqueue(T item) {
        if ((tail + 1) % count == head) {
            //满
            return false;
        }
        int current = tail;
        arrays[current] = item;
        tail = (tail + 1) % count;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            //空
            return null;
        }
        int current = head;
        head = (head + 1) % count;
        return arrays[current];
    }

    public static void main(String[] args) {
        CircleQueue<String> queue = new CircleQueue<>(5);
        testEnqueue(queue, "1");
        testEnqueue(queue, "2");
        testEnqueue(queue, "3");
        testEnqueue(queue, "4");
        testEnqueue(queue, "5");
        testEnqueue(queue, "6");

        testDequeue(queue);
        testDequeue(queue);
        testDequeue(queue);
        testDequeue(queue);
    }

    private static void testEnqueue(CircleQueue queue, String string) {
        Log.d("enqueue : " + string + queue.enqueue(string) + "\n");
    }

    private static void testDequeue(CircleQueue queue) {
        Log.d("dequeue: " + queue.dequeue() + "\n");
    }
}

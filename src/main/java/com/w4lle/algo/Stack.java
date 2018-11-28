package com.w4lle.algo;

import com.w4lle.algo.linklist.SinglyLinkedList;

/**
 * Created by w4lle on 2018/11/28.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


public class Stack<T> {
    private SinglyLinkedList<T> list = new SinglyLinkedList<>();

    public void push(T item) {
        if (item != null) {
            list.addHead(item);
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return list.delete(list.index(0)).value;
        }
        return null;
    }

    public void clear() {
        list.clear();
    }

    public int getLength() {
        return list.getLength();
    }

    public boolean isEmpty() {
        return list.getLength() <= 0;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");

        Log.d("length : " + stack.getLength() + "\n");
        Log.d("isEmpty: " + stack.isEmpty() + "\n");
        Log.d("pop1 : " + stack.pop() + "\n");
        Log.d("pop2 : " + stack.pop() + "\n");
        Log.d("pop3 : " + stack.pop() + "\n");

        stack.clear();
        Log.d("clear : " + stack.getLength() + "\n");
    }
}

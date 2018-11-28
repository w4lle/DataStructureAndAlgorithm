package com.w4lle.algo.linklist;

/**
 * Created by w4lle on 2018/11/27.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 带头单链表
 *
 * @param <T>
 */
public class SinglyLinkedList<T> {
    class Node<T> {
        public Node() {
            this(null);
        }

        public Node(T value) {
            this.value = value;
        }

        public Node<T> next;
        public T value;
    }

    public Node<T> head;
    public Node<T> current;

    public SinglyLinkedList() {
        head = new Node<>();
        current = head;
    }

    /**
     * 插入头结点
     *
     * @param value
     */
    public void addHead(T value) {
        Node<T> node = new Node<>(value);
        node.next = head.next;
        head.next = node;
    }

    /**
     * 插入结点
     *
     * @param value
     */
    public void add(T value) {
        Node<T> node = new Node<>(value);
        node.next = current.next;
        current.next = node;
        current = node;
    }

    public void addArray(T[] array) {
        for (T value :
                array) {
            add(value);
        }
    }

    public void printAll() {
        current = head.next;
        printAllNode(current);
    }

    public void printAllNode(Node<T> node) {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
    }

    public T getCurrent() {
        return current.value;
    }

    public Node<T> index(int index) {
        current = head.next;
        int i = 0;
        while (current != null) {
            if (i == index) {
                break;
            }
            current = current.next;
            i++;
        }
        Log.d("\nindex : " + current.value + "\n");
        return current;
    }

    /**
     * 单链表反转，时间 O(n) 空间 O(n)
     */
    public SinglyLinkedList<T> revertList() {
        current = head;
        SinglyLinkedList<T> list = new SinglyLinkedList<>();
        while (current.next != null) {
            list.addHead(current.next.value);
            current = current.next;
        }
        System.out.print("\n反转: ");
        list.printAll();
        return list;
    }

    /**
     * 不申请其余空间情况下单链表翻转，时间 (n) 空间 (1)
     *
     * @return
     */
    public SinglyLinkedList<T> revertListWithoutSpace() {
        current = head.next;
        Node<T> next = null;

        next = current.next;
        current.next = null;//尾节点 next 置空
        current = next;

        while (current != null) {
            next = current.next;
            current.next = head.next;
            head.next = current;
            current = next;
        }
        System.out.print("\nrevertListWithoutSpace 反转: ");
        printAll();
        return this;
    }

    /**
     * 翻转链表，直到 node
     *
     * @param node
     * @return
     */
    public Node<T> revertUntilNode(Node<T> node) {
        current = head.next;
        if (current.next == null || current == node) {
            return current;
        }
        Node<T> next = current.next;
        current.next = null;//尾节点 next 置空
        current = next;

        while (current != node) {
            next = current.next;
            current.next = head.next;
            head.next = current;
            current = next;
        }

        node.next = head.next;
        head.next = node;
        return node;
    }

    public static void main(String[] args) {
        Integer[] array = {2, 4, 6, 8, 10};
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addArray(array);
        linkedList.printAll();

        linkedList.revertList();
        linkedList.revertListWithoutSpace();

        Log.d("\n节点反转");
        linkedList.printAllNode(linkedList.revertUntilNode(linkedList.index(1)));
    }
}

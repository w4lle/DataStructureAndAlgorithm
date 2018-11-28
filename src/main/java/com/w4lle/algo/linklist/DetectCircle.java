package com.w4lle.algo.linklist;

/**
 * Created by w4lle on 2018/11/28.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 检测链表是否有还
 */
public class DetectCircle {
    public static boolean hasCircle(Node head) {
        Node slow, quick;
        slow = quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    private static Node tail;

    static Node createList(int nodeNum) {
        if (nodeNum <= 0) {
            return null;
        }

        Node head = null;
        int val = 0;
        Node node = null;

        while (nodeNum > 0) {
            if (head == null) {
                head = new Node();
                head.value = val;
                node = head;
                tail = head;
            } else {
                node.next = new Node();
                node = node.next;
                node.value = val;
                node.next = null;
                tail = node;
            }
            val++;
            nodeNum--;
        }

        return head;
    }

    public static Node createCircleList(int totalCount, int circleCount) {
        Node head = createList(totalCount);
        Node tmp = head;
        int step = totalCount - circleCount;
        while (step > 0) {
            tmp = tmp.next;
            step--;
        }
        tail.next = tmp;
        return head;
    }

    public static void main(String[] args) {
        Node head = createCircleList(10, 6);
        Log.d("hasCircle : " + hasCircle(head));
    }
}

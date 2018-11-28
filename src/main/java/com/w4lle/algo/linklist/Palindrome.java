package com.w4lle.algo.linklist;

/**
 * Created by w4lle on 2018/11/28.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


import com.w4lle.algo.Log;

/**
 * 回文字串
 */
public class Palindrome {
    /**
     * 是否是回文字串
     *
     * @return
     */
    public static boolean palindrome(SinglyLinkedList list) {
        if (list.head == null || list.head.next == null) {
            return false;//没有元素
        }
        if (list.head.next.next == null) {
            return true;//只有一个元素
        }

        //快慢指针
        Node slow, quick, middle;
        slow = quick = list.head;

        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        Node left, right;
        if (quick.next != null) {
            //奇数
            middle = slow.next;
            Log.d("中间节点 : " + String.valueOf(middle.value));

            right = middle.next;
            left = list.revertUntilNode(middle).next;
        } else {
            //偶数 有两个中间节点
            middle = slow;
            Log.d("中间节点 : " + String.valueOf(middle.value + ", " + middle.next.value));

            right = middle.next;
            left = list.revertUntilNode(middle);
        }

        while (left != null && right != null) {
            if (!left.value.equals(right.value)) {
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s1 = {"a", "b", "c", "d", "c", "b", "a"};
        String[] s2 = {"a", "b", "c", "d", "d", "c", "b", "a"};
        String[] s3 = {"a", "b"};
        String[] s4 = {"a"};
        String[] s5 = {"a", "b", "b", "c"};

        isPalindrome(s1);
        isPalindrome(s2);
        isPalindrome(s3);
        isPalindrome(s4);
        isPalindrome(s5);
    }

    private static void isPalindrome(String[] strings) {
        SinglyLinkedList<String> singlyLinkedList1 = new SinglyLinkedList<>();
        singlyLinkedList1.addArray(strings);
        Log.d("\n");
        singlyLinkedList1.printAll();
        Log.d("是否回文 : " + palindrome(singlyLinkedList1));
    }
}

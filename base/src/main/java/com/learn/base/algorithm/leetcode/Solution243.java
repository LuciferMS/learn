package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode243 回文链表
 * @author: Elliot
 * @create: 2019-06-12 14:15
 * 思路：快慢指针，快指针速度是慢指针的2倍，快指针走完，慢指针在中间，
 * 反转后半部分链表
 * 遍历后半部分与前半部分，对比。
 **/
public class Solution243 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null) {
            fast = fast.next.next == null ? fast.next : fast.next.next;
            low = low.next;
        }
        ListNode temp1 = low, temp2 = low.next, temp = low;
        while (temp2.next != null) {
            temp = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp;
        }
        temp2.next = temp1;
        temp1 = head;
        while (temp1 != low) {
            if (temp1.val != fast.val) {
                return false;
            }
            temp1 = temp1.next;
            fast = fast.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


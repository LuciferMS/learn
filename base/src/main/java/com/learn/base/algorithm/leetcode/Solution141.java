package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode141 环形链表1
 * @author: Elliot
 * @create: 2019-06-12 16:53
 **/
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != low) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            low = low.next;
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

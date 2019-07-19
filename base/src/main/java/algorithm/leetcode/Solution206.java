package algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode206 反转链表
 * @author: Elliot
 * @create: 2019-06-12 14:55
 **/
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        head.next = null;
        /**
         * 这个过程要好好推导一下
         */
        while (temp2.next != null) {
            temp = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp;
        }
        temp2.next = temp1;
        return temp2;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

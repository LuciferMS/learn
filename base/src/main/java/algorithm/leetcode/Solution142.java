package algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode142 环形链表2
 * @author: Elliot
 * @create: 2019-06-12 16:52
 * 快慢指针相遇，快指针指向头节点，然后快指针与慢指针每次走一步，
 * 必相遇
 * 别问,问就是玄学
 **/
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode low = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            low = low.next;
        } while (fast != low);
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package algorithm.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        for(; temp1.next != null;){
            sb1.append(temp1.val);
            temp1 = temp1.next;
        }
        for(; temp2.next != null;){
            sb1.append(temp2.val);
            temp2 = temp2.next;
        }
        int val1 = Integer.valueOf(sb1.toString());
        int val2 = Integer.valueOf(sb2.toString());
        int result = val1 + val2;
        ListNode res = null;
        while(result != 0){
            ListNode temp = new ListNode(result % 10);
            temp.next = res;
            res = temp;
            result /= 10;
        }
        return res;
    }
}

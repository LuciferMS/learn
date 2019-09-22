package com.learn.base.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: learn
 * @description: leetcode496 单调栈
 * @author: Elliot
 * @create: 2019-06-19 16:27
 **/
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }
        int len = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.empty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int len1 = nums1.length;
        int[] result = new int[len];
        for (int i = 0; i < len1; i++) {
            result[i] = map.get(nums2[i]);
        }
        return result;
    }
}

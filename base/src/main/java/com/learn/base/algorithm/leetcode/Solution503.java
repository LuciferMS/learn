package com.learn.base.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: learn
 * @description: leetcode503 单调栈
 * @author: Elliot
 * @create: 2019-06-20 21:41
 **/
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len * 2 - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            result[i % len] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return result;
    }
}

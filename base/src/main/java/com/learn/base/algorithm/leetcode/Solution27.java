package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode27 删除元素 双指针
 * @author: Elliot
 * @create: 2019-06-22 12:28
 **/
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        /**
         * 这里要写等于，如果数组只有一个元素。end就是-1，然后加回来
         */
        while (start <= end) {
            if (nums[start] == val) {
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start] ^= nums[end];
                end--;
            } else {
                start++;
            }
        }
        return end + 1;
    }
}

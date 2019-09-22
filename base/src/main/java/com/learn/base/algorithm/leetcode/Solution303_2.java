package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution303 动态规划1
 * @author: Elliot
 * @create: 2019-07-16 14:29
 **/
public class Solution303_2 {
    private int[] dp;
    private int[] nums;

    private Solution303_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            this.dp = null;
            this.nums = null;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
        this.dp = dp;
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (dp == null) {
            return 0;
        }
        return dp[j + 1] - dp[i];
    }
}

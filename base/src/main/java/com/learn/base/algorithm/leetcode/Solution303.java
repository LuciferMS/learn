package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution303 动态规划1
 * @author: Elliot
 * @create: 2019-07-16 14:14
 **/
public class Solution303 {
    private int[] nums;
    private int[][] dp;

    public Solution303(int[] nums) {
        if (nums == null || nums.length == 0) {
            this.nums = null;
            this.dp = null;
        }
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i + 1][j + 1] = nums[i];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j] + nums[j];
                }
            }
        }
        this.dp = dp;
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (dp == null) {
            return 0;
        }
        return dp[i + 1][j + 1];
    }

    /**
     * [[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution303 solution303 = new Solution303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(solution303.sumRange(0, 2));
//        for (int[] data : dp){
//            for (int num : data){
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
    }
}

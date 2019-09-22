package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode 566
 * @author: Elliot
 * @create: 2019-06-21 13:31
 **/
public class Solution566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int row = nums.length;
        int cow = nums[0].length;
        if (cow * row != c * r) {
            return nums;
        }
        int tempc = 0;
        int tempr = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cow; j++) {
                result[tempr][tempc] = nums[i][j];
                tempc++;
                if (tempc == c) {
                    tempc = 0;
                    tempr++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        matrixReshape(nums, 1, 4);
    }
}

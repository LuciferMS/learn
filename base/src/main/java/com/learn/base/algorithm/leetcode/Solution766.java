package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode766
 * @author: Elliot
 * @create: 2019-06-21 14:47
 **/
public class Solution766 {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        int c1 = 0;
        int r1 = r;
        int c2 = 0;
        int r2 = r;
        while (c1 <= c && r1 >= 0) {
            if (matrix[r1][c1] != matrix[r2][c2]) {
                return false;
            }
            int r2_temp = r2;
            int c2_temp = c2;
            do {
                if (matrix[r2_temp][c2_temp] != matrix[r1][c1]) {
                    return false;
                }
                r2_temp--;
                c2_temp--;
            } while (c2_temp >= 0);
            if (r1 == 0) {
                r1 = 0;
                c1++;
            } else {
                r1--;
            }
            if (c2 == c) {
                c2 = c;
                r2--;
            } else {
                c2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        isToeplitzMatrix(nums);
    }
}

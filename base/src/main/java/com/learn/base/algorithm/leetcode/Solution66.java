package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode66 加一
 * @author: Elliot
 * @create: 2019-06-22 13:19
 * <p>
 * 充分分析问题
 **/
public class Solution66 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int mark = 1;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }

    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        int mark = 1;
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] + mark == 10) {
                result[i] = 0;
                mark = 1;
            } else {
                result[i] = digits[i] + mark;
                mark = 0;
            }
        }
        if (digits[0] == 9 && result[0] != 9) {
            int[] temp = new int[len + 1];
            temp[0] = 1;
            System.arraycopy(result, 0, temp, 1, result.length);
            return temp;
        }
        return result;
    }
}

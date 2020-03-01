package com.learn.base.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: learn
 * @description: 检查整数及其2倍数的存在
 * @author: Elliot
 * @create: 2020-03-01 20:13
 **/
public class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        Arrays.sort(arr);
        int len = arr.length, pointer = 0, num = 0;
        for (int i = 0; i < len; i++) {
            num = arr[i] * 2;
            while (pointer < len && num > arr[pointer]) pointer++;
            if(pointer < len && pointer != i && num == arr[pointer]) return true;
            else if(pointer == len) break;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1346 solution1346 = new Solution1346();
        System.out.println(solution1346.checkIfExist(new int[]{2, 3, 5, 10}));
        System.out.println(solution1346.checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(solution1346.checkIfExist(new int[]{7, 1, 11, 14}));
        System.out.println(solution1346.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }
}

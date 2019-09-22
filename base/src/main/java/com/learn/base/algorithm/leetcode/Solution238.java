package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution238
 * @author: Elliot
 * @create: 2019-07-20 21:19
 **/
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            result[i] *= k;
            k *= nums[i];
        }
        return result;
    }
}

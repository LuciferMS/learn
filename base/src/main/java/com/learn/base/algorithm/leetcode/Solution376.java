package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode376 贪心算法2摇摆序列
 * @author: Elliot
 * @create: 2019-09-22 00:10
 **/
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null ){
            return 0;
        }
        if (nums.length < 2){
            return nums.length;
        }
        int max_length = 1;
        final int BEGIN = 0, UP = 1, DOWN = 2;
        int STATE = BEGIN;
        for (int i = 1; i < nums.length; i++) {
           switch (STATE){
               case BEGIN :
                   if (nums[i - 1] < nums[i]){
                       STATE = UP;
                       max_length++;
                   }else if(nums[i - 1] > nums[i]){
                       STATE = DOWN;
                       max_length++;
                   }
                   break;
               case UP :
                   if (nums[i] < nums[i - 1]){
                       STATE = DOWN;
                       max_length++;
                   }
                   break;
               case DOWN:
                   if(nums[i] > nums[i -1 ]){
                       STATE = UP;
                       max_length++;
                   }
                   break;
           }
        }
        return max_length;
    }
}

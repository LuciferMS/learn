package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode45跳跃游戏2
 * @author: Elliot
 * @create: 2019-10-02 00:55
 **/
public class Solution45 {
    class Solution {
        public int jump(int[] nums) {
            if(nums == null || nums.length < 2){
                return 0;
            }
            int len = nums.length;
            int current_max_index = nums[0];//当前可达到的最远位置
            int pre_max_max_index = nums[0];//遍历各个位置过程中，可达到的最远位置
            int jump_min = 1;
            for(int i = 1; i < len; i++){
                //如果无法向前移动了，才进行跳跃，即更新当前可达到的最远距离
                if(i > current_max_index){
                    jump_min++;
                    current_max_index = pre_max_max_index;
                }
                if(pre_max_max_index <= nums[i] + i){
                    pre_max_max_index = nums[i] + i;//更新pre_max_max_index
                }
            }
            return jump_min;
        }
    }
}

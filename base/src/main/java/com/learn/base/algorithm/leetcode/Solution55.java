package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode55贪心跳跃游戏
 * @author: Elliot
 * @create: 2019-10-02 00:35
 **/
public class Solution55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int len = nums.length;
        //可以跳到更远的地方
        int[] mark = new int[len];
        for(int i = 0; i < len; i++){
            //计算index数组
            mark[i] = i + nums[i];
        }
        //初始化max_index和jump，直到jump到len或者超过len
        int jump = 0, max_index = mark[0];
        while(jump < len && jump <= max_index){
            if(max_index < mark[jump]){
                //如果可以跳到更远的地方就更新max_index
                max_index = mark[jump];
            }
            jump++;//扫描jump
        }
        //如果jump到达数组尾部，返回真
        if(jump >= len){
            return true;
        }
        return false;
    }
}

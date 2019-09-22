package com.learn.base.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: learn
 * @description: 三数之和
 * @author: Elliot
 * @create: 2019-08-12 22:07
 **/
public class Solution26 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(nums[i] > 0) {
                break;
            }
            // 去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i + 1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    // 去重
                    while (L<R && nums[L] == nums[L+1]) {
                        L++;
                    }
                    // 去重
                    while (L<R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    L++;
                    R--;
                }
                else if (sum < 0) {
                    L++;
                }
                else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }
}

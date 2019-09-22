package com.learn.base.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: leetcode448'
 * @author: Elliot
 * @create: 2019-06-22 14:21
 * 巧妙利用索引与元素的关系
 **/
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null | nums.length == 0) {
            return result;
        }
        int len = nums.length;
        for (int num : nums) {
            nums[Math.abs(num) - 1] = -1 * Math.abs(nums[Math.abs(num) - 1]);
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

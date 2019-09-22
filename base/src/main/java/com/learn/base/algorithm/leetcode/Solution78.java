package com.learn.base.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: Solution78 一个集合的所有子集
 * @author: Elliot
 * @create: 2019-07-15 14:59
 **/
public class Solution78 {

    /**
     * 一个数组的所有集合
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (nums != null && nums.length != 0) {
            for (int num : nums) {
                int len = result.size();
                for (int i = 0; i < len; i++) {
                    List<Integer> list = new ArrayList<Integer>(result.get(i));
                    list.add(num);
                    result.add(list);
                }
            }
        }
        return result;
    }

}

package com.learn.base.algorithm.leetcode.backtracking;

import com.learn.base.java.others.IntegerTest;

import java.util.*;

/**
 * @program: learn
 * @description: 子集2
 * @author: Elliot
 * @create: 2020-02-26 14:47
 **/
public class Solution90 {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        this.nums = nums;
        Arrays.sort(nums);
        helper(0, new ArrayDeque<>());
        return result;
    }

    private void helper(int index, Deque<Integer> deque){
        result.add(new ArrayList<>(deque));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            deque.add(nums[i]);
            helper(i + 1 , deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        List<List<Integer>> result = solution90.subsetsWithDup(new int[]{1, 2, 2});
        for(List<Integer> list : result){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

package com.learn.base.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: learn
 * @description: 全排列2
 * @author: Elliot
 * @create: 2020-02-14 23:08
 **/
public class Solution47 {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    private int[] nums;

    private int len;


    public List<List<Integer>> permuteUnique2(int[] nums){
        if(nums == null || nums.length == 0) return this.result;
        this.nums = nums;
        this.len = nums.length;
        Arrays.sort(this.nums);
        backTracking(0);
        return this.result;
    }

    private void backTracking(int index){
        if(index == len - 1){
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            result.add(list);
        }
        for(int i = index; i < len; i++){
            if(i != index && nums[i] == nums[index]) continue;
            swap(index, i);
            backTracking(index + 1);
        }
    }

    private void swap(int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        List<List<Integer>> result = solution47.permuteUnique2(new int[]{1, 1, 2, 2});
        for(List<Integer> list : result){
            for (int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

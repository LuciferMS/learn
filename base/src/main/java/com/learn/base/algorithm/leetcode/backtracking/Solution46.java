package com.learn.base.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: 全排列1
 * @author: Elliot
 * @create: 2020-02-14 21:43
 **/
public class Solution46 {


    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;

    private int len;


    public List<List<Integer>> permuteUnique(int[] nums){
        if(nums == null || nums.length == 0) return this.result;
        this.nums = nums;
        this.len = nums.length;
        backTracking(0);
        return this.result;
    }

    private void backTracking(int index){
        if(index == len - 1) {
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return ;
        }
        for(int i = index; i < len; i++){
            swap(index, i);
            backTracking(index + 1);
            swap(index, i);
        }
    }

    private void swap(int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        List<List<Integer>> result = solution46.permuteUnique(new int[]{1, 2, 3});
        for(List<Integer> list : result){
            for (int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

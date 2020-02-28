package com.learn.base.algorithm.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: learn
 * @description: 组合总和3
 * @author: Elliot
 * @create: 2020-02-28 18:35
 **/
public class Solution216 {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    private int k;

    private int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n < 1 || n > 45 ||k < 1 ||k > 9) return result;
        this.k = k;
        this.n = n;
        helper(1, n, new ArrayDeque<Integer>());
        return result;
    }

    private void helper(int index, int rest ,Deque<Integer> deque){
        if(rest == 0){
            if(deque.size() == k){
                result.add(new ArrayList<>(deque));
            }
            return;
        }
        if(deque.size() > k) return;
        if (rest < 0) return;
        if (index > rest) return;
        int end = rest > 9 ? 9 :rest;
        for (int i = index; i <= end; i++) {
            deque.add(i);
            helper(i + 1, rest - i, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        List<List<Integer>> result = solution216.combinationSum3(3, 7);
        for (List<Integer> list : result){
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

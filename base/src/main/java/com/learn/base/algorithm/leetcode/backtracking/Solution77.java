package com.learn.base.algorithm.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: learn
 * @description: 组合
 * @author: Elliot
 * @create: 2020-02-25 20:54
 **/
public class Solution77 {


    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    private int n;

    private int k;

    public List<List<Integer>> combine(int n, int k){
        this.n = n;
        this.k = k;
        helper(1, new ArrayDeque<>());
        return result;
    }

    private void helper(int index, Deque<Integer> list){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return ;
        }
        for(int i = index; i <= n - (k - list.size()) + 1; i++){
            list.add(i);
            helper(i + 1,  list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        List<List<Integer>> result = solution77.combine(5, 2);
        for(List<Integer> list : result){
            for(int num : list){
                System.out.print( num + "  " );
            }
            System.out.println();
        }
    }

}

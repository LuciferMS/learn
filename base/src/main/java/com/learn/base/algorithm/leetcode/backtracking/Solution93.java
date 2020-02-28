package com.learn.base.algorithm.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: learn
 * @description: 复原ip地址
 * @author: Elliot
 * @create: 2020-02-26 15:08
 **/
public class Solution93 {

    private String s;

    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s == null) return result;
        this.s = s;
        helper(0, new ArrayDeque<>());
        return result;
    }

    private void helper(int index, Deque<String> deque){
        if((s.length() - 1 - index) > (4 - deque.size()) * 3) return ;
        if(!deque.isEmpty()){
            String last = deque.getLast();
            if(last.length() != 1 && last.startsWith("0")) return ;
            if(Integer.valueOf(last) > 255) return ;
        }
        if (deque.size() == 4 && index == s.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : deque){
                stringBuilder.append(s);
                stringBuilder.append(".");
            }
            result.add(stringBuilder.subSequence(0, stringBuilder.lastIndexOf(".")).toString());
        }
        int end = index + 3 >= s.length() ? s.length() : index + 3;
        for (int i = index + 1; i <= end; i++){
            deque.add(s.substring(index, i));
            helper(i, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> result = solution93.restoreIpAddresses("010010");
        for(String s : result)
            System.out.println(s);
    }
}

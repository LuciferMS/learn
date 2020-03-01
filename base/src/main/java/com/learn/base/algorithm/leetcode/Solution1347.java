package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: 制作字母异位词的最小步骤数
 * @author: Elliot
 * @create: 2020-03-01 19:35
 **/
public class Solution1347 {
    public int minSteps(String s, String t) {
        int[] mark = new int[26];
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            mark[s.charAt(i) - 'a']++;
            mark[t.charAt(i) - 'a']--;
        }
        for(int num : mark){
            if (num > 0) result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1347 solution1347 = new Solution1347();
        String s = "aab";
        String t = "bab";
        System.out.println(solution1347.minSteps(s, t));
    }
}

package com.learn.base.algorithm.leetcode;

import java.util.Arrays;

/**
 * @program: learn
 * @description: leetcode455贪心 分糖果问题
 * @author: Elliot
 * @create: 2019-09-21 23:45
 **/
public class Solution455 {
    /**
     *
     * @param g 小孩
     * @param s 糖果
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if (g[i] <= s[j]){
                i++;
                j++;
                result++;
            }else{
                j++;
            }
        }
        return result;
    }
}

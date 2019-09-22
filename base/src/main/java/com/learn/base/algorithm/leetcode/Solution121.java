package com.learn.base.algorithm.leetcode;


/**
 * @program: learn
 * @description: leetcode121买股票
 * @author: Elliot
 * @create: 2019-06-22 13:34
 * 寻峰
 **/
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int maxPro = 0;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (prices[i] - min > maxPro) {
                    maxPro = prices[i] - min;
                }
            }
        }
        return maxPro;
    }
}

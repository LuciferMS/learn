package com.learn.base.algorithm.leetcode.backtracking;

import com.learn.base.algorithm.leetcode.Solution13;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: 第k个排列
 * @author: Elliot
 * @create: 2020-03-02 22:07
 **/
public class Solution60 {

    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList<Integer>(){{add(1);}};
        factorials[0] = 1;
        for (int i = 1; i < n; i++){
            factorials[i] = factorials[i - 1] * i;
            nums.add(i + 1);
        }
        --k;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i > -1; --i){
            int index = k / factorials[i];
            k -= index * factorials[i];
            stringBuilder.append(nums.get(index));
            nums.remove(index);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        String result = solution60.getPermutation(3, 3);
        System.out.println(result);
    }

}

package com.learn.base.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: learn
 * @description: leetcode452射击气球
 * @author: Elliot
 * @create: 2019-10-02 01:10
 **/
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        int len = points.length;
        Arrays.sort(points, (int[] a1, int[] a2)->a1[0] - a2[0]);
        Stack<int[]> stack = new Stack();
        stack.push(points[0]);
        for (int i = 1; i < len; i++) {
            int[] temp = stack.peek();
            if (points[i][0] < temp[1]){
                stack.pop();
                stack.push(new int[]{temp[1], points[i][0]});
            }else{
                stack.push(points[i]);
            }
        }
        return stack.size();
    }
}

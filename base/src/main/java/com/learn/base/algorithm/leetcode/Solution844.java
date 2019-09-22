package com.learn.base.algorithm.leetcode;

import java.util.Stack;

/**
 * @program: learn
 * @description: leetcode844
 * @author: Elliot
 * @create: 2019-06-20 22:13
 **/
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) {
            return true;
        }
        if (S.equals(T)) {
            return true;
        }
        int len1 = S.length();
        int len2 = T.length();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < len1; i++) {
            if (S.charAt(i) == '#') {
                int temp = stack1.empty() ? 1 : stack1.pop();
            } else {
                stack1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < len2; i++) {
            if (S.charAt(i) == '#') {
                int temp = stack2.empty() ? 1 : stack2.pop();
            }
            stack1.push(T.charAt(i));
        }
        return stack1.toString().equals(stack2.toString());
    }
}

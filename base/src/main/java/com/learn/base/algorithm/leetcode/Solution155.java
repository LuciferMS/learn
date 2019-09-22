package com.learn.base.algorithm.leetcode;

import java.util.Stack;
import java.util.concurrent.Executors;

/**
 * @program: learn
 * @description: leetcode155 最小栈
 * @author: Elliot
 * @create: 2019-06-12 13:07
 **/
public class Solution155 {

    private Stack<Integer> data;

    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public Solution155() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if (min.empty()) {
            min.push(x);
            return;
        }
        int temp = min.peek();
        temp = temp > x ? min.push(x) : min.push(temp);
    }

    public void pop() {
        if (data.empty()) {
            throw new RuntimeException("出错");
        }
        data.pop();
        min.pop();
    }

    public int top() {
        if (data.empty()) {
            throw new RuntimeException("出错");
        }
        return data.peek();
    }

    public int getMin() {
        if (min.empty()) {
            throw new RuntimeException("出错");
        }
        return min.peek();
    }
}

package algorithm.leetcode;

import java.util.Stack;

/**
 * @program: learn
 * @description: leetcode 232栈实现队列
 * @author: Elliot
 * @create: 2019-06-19 14:39
 **/
public class Solution232 {

}


class MyQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                throw new RuntimeException();
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                throw new RuntimeException();
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}
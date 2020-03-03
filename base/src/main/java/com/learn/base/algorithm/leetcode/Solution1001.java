package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: 一日一题2
 * @author: Elliot
 * @create: 2020-03-03 18:10
 **/
public class Solution1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        if(n == A.length) {
            System.arraycopy(B, 0, A, 0, n);
            return;
        }
        int end = A.length - 1;
        n--;
        m--;
        while(end > m){
            if(B[n] > A[m]) A[end--] = B[n--];
            else A[end--] = A[m--];
        }
    }
}
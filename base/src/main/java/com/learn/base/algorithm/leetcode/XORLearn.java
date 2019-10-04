package com.learn.base.algorithm.leetcode;

import java.util.Scanner;

/**
 * @program: learn
 * @description: 抑或与加法
 * @author: Elliot
 * @create: 2019-10-04 14:03
 **/
public class XORLearn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(xor(a, b));
    }

    public static int xor(int a, int b){
        return a ^ b + ((a & b) << 1);
    }
}

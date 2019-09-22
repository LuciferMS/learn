package com.learn.base.algorithm.offer;

import java.util.Scanner;

/**
 * @program: learn
 * @description: tx5
 * @author: Elliot
 * @create: 2019-09-20 21:36
 **/
public class Tx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int datas[][] = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                datas[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = datas[1][i];
            for (int j = 0; j < n; j++) {
                result += 2 * (temp ^ datas[0][j]);
            }
        }
        System.out.println(result);
    }
}

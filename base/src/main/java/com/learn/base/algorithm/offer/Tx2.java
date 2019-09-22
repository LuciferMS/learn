package com.learn.base.algorithm.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: learn
 * @description: tx2
 * @author: Elliot
 * @create: 2019-09-20 20:39
 **/
public class Tx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] data = new int[num][2];
        int nums = 0;
        for (int i = 0; i < num; i++){
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            nums += data[i][0];
        }
        int[] datas = new int[nums];
        int index = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < data[i][0]; j++) {
                datas[index++] = data[i][1];
            }
        }
        Arrays.sort(datas);
        int i = 0, j = datas.length - 1;
        int[] mark = new int[nums];
        int k = 0;
        while(i < j){
            mark[k++] = datas[i++] + datas[j--];
        }
        int n = 0;
        for(int temp : mark){
            n = temp > n ? temp : n;
        }
        System.out.println(n);
    }
}

package com.learn.base.algorithm.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: learn
 * @description: tx4
 * @author: Elliot
 * @create: 2019-09-20 20:55
 **/
public class Tx4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] datas = new int[n];
        for (int i = 0; i < n; i++) {
            datas[i] = sc.nextInt();
        }
        Arrays.sort(datas);
        LinkedList<Integer> mark = new LinkedList<>();
        int i = 0, j = 1;
        mark.add(datas[0]);
        while(j < datas.length){
            mark.add(datas[j++] - datas[i++]);
        }
        for (int k = 0; k < m; k++) {
           if (!mark.isEmpty()){
               if (mark.getFirst() != 0){
                   System.out.println(mark.pollFirst());
               }else{
                   while(!mark.isEmpty() && mark.getFirst() == 0){
                       mark.pollFirst();
                   }
                   System.out.println(mark.pollFirst());
               }
           }else{
               System.out.println(0);
           }
        }
    }
}

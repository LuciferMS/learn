package com.learn.base.algorithm.offer;

import java.util.Scanner;

/**
 * @description: tx1
 * @author: Elliot
 * @create: 2019-09-20 20:31
 **/
public class Tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String num = sc.nextLine();
            String str = sc.nextLine();
            if (str.contains("8")){
                if (str.length() - str.indexOf('8') >= 11){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                System.out.println("NO");
            }
        }
    }
}

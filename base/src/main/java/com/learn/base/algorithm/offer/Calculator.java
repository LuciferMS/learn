package com.learn.base.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @program: learn
 * @description: 计算器
 * @author: Elliot
 * @create: 2019-08-19 17:02
 **/
public class Calculator {


    private static List<Character> operator = new ArrayList<>();

    static {
        operator.add('+');
        operator.add('*');
        operator.add('-');
        operator.add('/');
    }


    public static int pro(char c){
        switch (c){
            case '-':
            case '+':
                return 1;
            case '*':
            case '/':
                return 2;
                default:
                    return 0;
        }
    }

    public static int calculator(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        Stack<Character> pro = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < len; i++) {
           if (operator.contains(chars[i])){
               int p = pro(chars[i]);
               if(p == 2){
                   int operNum1 = nums.pop();
                   int operNum2 = chars[i + 1] - 48;
                   int result = 0;
                   if(chars[i] == '/'){
                       result = operNum1 / operNum2;
                   }
                   if(chars[i] == '*'){
                       result = operNum1 * operNum2;
                   }
                   nums.push(result);
               }else{
                   pro.push(chars[i]);
               }
           }else{
               nums.push(chars[i] - 48);
           }
        }



        int temp = nums.pop();
        while(!nums.empty()){
            char operator = pro.pop();
            int i = nums.pop();
            if(operator == '+'){
                temp += i;
            }else if (operator == '-'){
                temp -= i;
            }
        }
        return temp;
    }


    // 2 + 3 * 4 + 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calculator(s));
    }
}

package com.learn.base.algorithm.leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Elliot
 * leetcode 13题
 */
public class Solution13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int result = romanToInt(s);
            System.out.println(result);
        }
    }


    public static int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        String[] data = {"IV", "IX", "XL", "XC", "CD", "CM"};
        int[] nums = {4, 9, 40, 90, 400, 900};
        for (int i = 0; i < data.length; i++) {
            if (s.contains(data[i])) {
                result += nums[i];
                s = s.replace(data[i], "");
            }
        }
        char[] chars = s.toCharArray();
        if (chars.length != 0) {
            for (char c : chars) {
                result += map.get(c);
            }
        }
        return result;
    }
}

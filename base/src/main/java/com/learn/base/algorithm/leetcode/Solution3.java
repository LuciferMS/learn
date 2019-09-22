package com.learn.base.algorithm.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Elliot
 * leetCode第三题 最大无重复子串
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println(lengthOfLongestSubstring2(str));
        }
    }

    /**
     * 暴力破解法
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring1(String str) {
        if (str.length() == 0 && str == null) {
            return 0;
        }
        int len = str.length();
        int result = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (uniqueAll(str, i, j)) {
                    if (j - i + 1 > result) {
                        result = j - i + 1;
                    }
                }
            }
        }
        return result;
    }

    private static boolean uniqueAll(String s, int begin, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = begin; i <= end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口法
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring2(String str) {
        Set<Character> set = new HashSet<>();
        int len = str.length();
        int ans = 0, begin = 0, end = 0;
        while (begin < len && end < len) {
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end++));
                ans = Math.max(ans, end - begin);
            } else {
                set.remove(str.charAt(begin++));
            }
        }
        return ans;
    }
}

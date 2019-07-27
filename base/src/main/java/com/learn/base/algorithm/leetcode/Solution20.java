package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: learn
 * @description: Solution20 括号匹配
 * @author: Elliot
 * @create: 2019-07-14 20:30
 **/
public class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                Character c = stack.empty() ? '#' : stack.pop();
                /**
                 * 阿里巴巴规范说，包装类建议用equals，不用==
                 */
                if (!map.get(s.charAt(i)).equals(c)) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}

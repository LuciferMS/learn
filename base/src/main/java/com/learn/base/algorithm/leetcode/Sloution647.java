package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution647回文子串
 * @author: Elliot
 * @create: 2019-07-19 17:40
 **/
public class Sloution647 {
    public int countSubstrings(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    result++;
                }
            }
        }
        return result;
    }
}

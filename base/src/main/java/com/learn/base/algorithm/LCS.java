package algorithm;

/**
 * @program: learn
 * @description: lcs算法
 * @author: Elliot
 * @create: 2019-07-15 11:13
 **/
public class LCS {
    /**
     * 最长公共子序列
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int getNums(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 最长公共子串
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int getNums2(String s1, String s2) {
        int max = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = max > dp[i + 1][j + 1] ? max : dp[i + 1][j + 1];
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";
        int num = getNums2(s1, s2);
        System.out.println(num);
    }
}

package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution640 dp最小路径
 * @author: Elliot
 * @create: 2019-07-19 13:25
 **/
public class Solution64 {
    public static int[][] minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + grid[i][j];
                }
                if (j == 0) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + grid[i][j];
                }
                if (i > 0 && j > 0) {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] datas = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] dp = minPathSum(datas);
        for (int[] nums : dp) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(dp[datas.length][datas[0].length]);
    }

}

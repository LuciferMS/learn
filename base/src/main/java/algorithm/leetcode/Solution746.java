package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution746 最小花费爬楼梯
 * @author: Elliot
 * @create: 2019-07-17 19:13
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/submissions/
 **/
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 1) {
            return 0;
        }
        int len = cost.length;
        int[] dp = new int[len];
        System.arraycopy(cost, 0, dp, 0, 2);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}

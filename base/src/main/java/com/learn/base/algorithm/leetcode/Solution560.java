package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solutionn560
 * @author: Elliot
 * @create: 2019-07-24 14:35
 **/
public class Solution560 {

    public static int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                result += dp[j] - dp[i] == k ? 1 : 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums,2));
    }
}

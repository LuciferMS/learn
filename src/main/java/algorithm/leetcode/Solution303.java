package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution303 动态规划1
 * @author: Elliot
 * @create: 2019-07-16 14:14
 **/
public class Solution303 {
    private int[] nums;
    private int[][] dp;

    public Solution303(int[] nums){
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++){
            for (int j = i; j < len; j++) {
                if (i == j){
                    dp[i + 1][j + 1] = nums[i];
                }else{
                    dp[i + 1][j + 1] = dp[i + 1][j] + nums[j];
                }
            }
        }
        this.dp = dp;
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        return dp[i + 1][j + 1];
    }

    public static void main(String[] args) {
        Solution303 solution303 = new Solution303(new int[]{});

//        for (int[] data : dp){
//            for (int num : data){
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
    }
}

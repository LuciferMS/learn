package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution300 最长上升子序列
 * @author: Elliot
 * @create: 2019-07-25 10:24
 **/
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

            }
        }
        return result;
    }
}

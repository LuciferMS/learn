package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution322
 * @author: Elliot
 * @create: 2019-07-24 15:25
 **/
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        for (int i = coins.length - 1; i >= 0 ; i++) {
            if (amount < coins[i]){
                continue;
            }
            count += amount/coins[i];
            amount = amount%coins[i];
        }
        return count;
    }
}

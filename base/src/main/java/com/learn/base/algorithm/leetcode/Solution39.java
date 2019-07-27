package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: learn
 * @description: Solution39 数组集合
 * @author: Elliot
 * @create: 2019-07-15 15:56
 **/
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, 0, candidates, 0, new ArrayList<Integer>(), target);
        return result;
    }

    public void helper(List<List<Integer>> list, int i, int[] candidates, int sum, List<Integer> temp, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(temp);
            return;
        }
        for (int num = i; i < candidates.length; i++) {
            List<Integer> temp_list = new ArrayList<>(temp);
            temp_list.add(candidates[i]);
            helper(list, i, candidates, sum + candidates[i], temp_list, target);
        }
    }
}

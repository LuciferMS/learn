package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: Solution279完全平方数
 * @author: Elliot
 * @create: 2019-07-24 11:32
 **/
public class Soluition279 {

    public static int numSquares(int n) {
        List<Integer> squares =  generateSquares(n);
        List<List<Integer>> mark = new ArrayList<>();
        helper(mark, squares, 0, new ArrayList<>(), 0, n);
        int size = Integer.MAX_VALUE;
        for (List<Integer> list : mark){
            size = size < list.size() ? size : list.size();
        }
        return size;
    }

    public static void helper(List<List<Integer>> mark, List<Integer> squares, int i, List<Integer> list, int sum, int target){
        if (sum > target){
            return ;
        }
        if (sum == target){
            mark.add(list);
            return;
        }
        for (int j = i; j < squares.size(); j++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(squares.get(j));
            helper(mark, squares, j, temp, sum + squares.get(j), target);
        }
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}

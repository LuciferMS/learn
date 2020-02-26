package com.learn.base.algorithm.leetcode.backtracking;

/**
 * @program: learn
 * @description: 单词搜索
 * @author: Elliot
 * @create: 2020-02-26 10:58
 **/
public class Solution79 {

    private char[][] board;

    private int len;

    private int col;

    private int row;

    private String word;

    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        this.board = board;
        this.word = word;
        this.len = word.length();
        this.row = board.length;
        this.col = board[0].length;
        this.used = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(helper(0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean helper(int current, int col_index, int row_index){
        if(current == len) return true;
        if(col_index >= col || row_index >= row || col_index < 0 || row_index < 0) return false;
        if (used[row_index][col_index]) return false;
        if(board[row_index][col_index] != word.charAt(current)) return false;
        used[row_index][col_index] = true;
        boolean result = helper(current + 1, col_index + 1, row_index) ||
                         helper(current + 1, col_index - 1, row_index) ||
                         helper(current + 1, col_index, row_index - 1) ||
                         helper(current + 1, col_index, row_index + 1);
        used[row_index][col_index] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution79.exist(board, "ABCCED"));
        System.out.println(solution79.exist(board, "SEE"));
        System.out.println(solution79.exist(board, "ABCB"));
    }
}

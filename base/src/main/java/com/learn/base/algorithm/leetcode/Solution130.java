package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution130深度优先遍历
 * @author: Elliot
 * @create: 2019-07-25 18:18
 **/
public class Solution130 {
    public static void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return ;
        }
        for (int i = 0; i < board.length; i++) {
            helper(board, i, 0);
            helper(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            helper(board, 0, i);
            helper(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void helper(char[][] board, int i, int j){
        if(i < 0 || i >= board[0].length || j < 0 || j >= board.length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '#';
        helper(board,i + 1, j);
        helper(board,i - 1, j);
        helper(board,  i, j + 1);
        helper(board,  i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };
        solve(board);
        for(char[] chars : board){
            for (char c : chars){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

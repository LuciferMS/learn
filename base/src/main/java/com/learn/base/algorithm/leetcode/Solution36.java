package com.learn.base.algorithm.leetcode;

import java.util.HashMap;

public class Solution36 {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] grid = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            cols[i] = new HashMap<>();
            rows[i] = new HashMap<>();
            grid[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int c = (int) board[i][j];

                if (c == '.') continue;

                cols[i].put(c, cols[i].getOrDefault(c, 0) + 1);


                rows[j].put(c, rows[j].getOrDefault(c, 0) + 1);

                int grid_index = i / 3 * 3 + j / 3;
                grid[grid_index].put(c, grid[grid_index].getOrDefault(c, 0) + 1);

                if (cols[i].get(c) > 1 || rows[j].get(c) > 1 || grid[grid_index].get(c) > 1) return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int[] cols = new int[9];
        int[] rows = new int[9];
        int[] grid = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int n =  board[i][j] - '0';
                if ((cols[i] & 1 << n) != 0) return false;
                cols[i] ^= 1 << n;
                if ((rows[i] & 1 << n) != 0) return false;
                rows[i] ^= 1 << n;

                int grid_index = i / 3 * 3 + j / 3;
                if((grid[grid_index] & 1 << n) != 0) return false;
                grid[grid_index] ^= 1 << n;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'1' == 1);
    }
}

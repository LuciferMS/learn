package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution200 岛屿数量
 * @author: Elliot
 * @create: 2019-07-24 13:37
 **/
public class Solution200 {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int result = 0;
        boolean flag = true;
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        while(flag){
            flag = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1'){
                        flag = true;
                        mark(i, j, grid, mark);
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void mark(int i, int j, char[][] grid, boolean[][] mark){
        if (!mark[i][j] && grid[i][j] == '1'){
            mark[i][j] = true;
            grid[i][j] = '2';
            if (i > 0 ){
                mark(i - 1, j, grid, mark);
            }
            if (i < grid.length - 1){
                mark(i + 1, j, grid, mark);
            }
            if (j > 0){
                mark(i, j - 1, grid, mark);
            }
            if (j < grid[0].length - 1){
                mark(i, j + 1, grid, mark);
            }
        }
        return ;
    }

    public static void main(String[] args) {
       char[][] datas = {
               {'1', '1', '1', '0'},
               {'1', '1', '0', '0'},
               {'1', '0', '0', '0'},
               {'1', '0', '0', '0'}
       };
        System.out.println(numIslands(datas));
    }
}

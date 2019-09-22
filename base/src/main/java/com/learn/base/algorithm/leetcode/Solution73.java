package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution73
 * @author: Elliot
 * @create: 2019-07-27 22:25
 **/
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ;
        }
        boolean[][] mark = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0 && !mark[i][j]){
                    helper(matrix, mark, i, j);
                }
            }
        }
    }

    public void helper(int[][] matrix, boolean[][] mark, int i, int j){
        for(int k = 0; k < matrix[0].length; k++){
            if(matrix[i][k] != 0 && !mark[i][k]){
                matrix[i][k] = 0;
                mark[i][k] = true;
            }
        }
        for(int k = 0; k < matrix.length; k++){
            if(matrix[k][j] != 0 && !mark[k][j]){
                matrix[k][j] = 0;
                mark[k][j] = true;
            }
        }
    }
}

package algorithm.leetcode;

/**
 * @program: learn
 * @description: leetcode240
 * @author: Elliot
 * @create: 2019-06-13 10:49
 * 搜索二维矩阵
 **/
public class Solution240 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int col_index = 0;
        int row_index = row - 1;
        while (col_index < col && row_index < row && col_index >= 0 && row_index >= 0) {
            if (matrix[col_index][row_index] > target) {
                row_index--;
            } else if (matrix[col_index][row_index] < target) {
                col_index++;
            } else {
                return true;
            }
        }
        return false;
    }
}

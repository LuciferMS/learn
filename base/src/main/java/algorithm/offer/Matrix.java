package algorithm.offer;

//回溯算法
public class Matrix {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] mark = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    mark[i * cols + j] = 1;
                    if (hasPathHelper(matrix, rows, cols, i, j, str, 1, mark)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasPathHelper(char[] matrix, int rows, int cols, int x, int y, char[] str, int index, int[] mark) {
        if (mark[x * rows + y] == 1) {
            return false;
        }
        if (x < 0 || x >= rows) {
            return false;
        }
        if (y < 0 || y >= cols) {
            return false;
        }
        if (index >= str.length) {
            return true;
        }
        if (matrix[x * rows + cols] != str[index]) {
            mark[x * cols + y] = 0;
            return false;
        }
        mark[x * cols + y] = 1;
        return hasPathHelper(matrix, rows, cols, x + 1, y, str, index + 1, mark) ||
                hasPathHelper(matrix, rows, cols, x - 1, y, str, index + 1, mark) ||
                hasPathHelper(matrix, rows, cols, x, y + 1, str, index + 1, mark) ||
                hasPathHelper(matrix, rows, cols, x, y - 1, str, index + 1, mark);
    }
}
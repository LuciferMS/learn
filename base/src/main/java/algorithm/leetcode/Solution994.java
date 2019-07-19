package algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution994 广度优先遍历--腐烂的橘子
 * @author: Elliot
 * @create: 2019-07-18 15:31
 **/
public class Solution994 {
    /**
     * 使用最新感染的橘子去感染其他橘子。因为最近被感染的橘子也是被其他橘子感染的....
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int times = 1;
        boolean flag = true;
        int[][] note = new int[grid.length][grid[0].length];
        /**
         * 初始化标记数组
         */
        for (int i = 0; i < note.length; i++) {
            for (int j = 0; j < note[0].length; j++) {
                if (grid[i][j] == 2) {
                    note[i][j] = times;
                } else {
                    note[i][j] = 0;
                }
            }
        }
        /**
         * 感染过程......
         */
        while (flag) {
            flag = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2 && note[i][j] == times) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            note[i - 1][j] = times + 1;
                            flag = true;
                        }
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 2;
                            note[i + 1][j] = times + 1;
                            flag = true;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            note[i][j - 1] = times + 1;
                            flag = true;
                        }
                        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 2;
                            note[i][j + 1] = times + 1;
                            flag = true;
                        }
                    }
                }
            }
            if (flag) {
                times++;
                ;
            }
        }
        /**
         * 最后检查一遍，如果还有没有被感染的橘子，就返回-1
         */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return times - 1;
    }
}

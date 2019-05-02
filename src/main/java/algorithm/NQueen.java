package algorithm;

import java.util.Date;

public class NQueen {

    private static final short N = 10;

    private static int count = 0;

    public static Integer nQueen(int n){
        return 0;
    }

    public static void main(String[] args) {
        Date begin = new Date();
        short[][] chess = new short[N][N];
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                chess[i][j] = 0;
            }
        }
        putQueueAtRow(chess, 0);
        Date end = new Date();
        System.out.println("解决 " + N + "皇后问题,用时：" + String.valueOf(end.getTime() - begin.getTime())
                    + "毫秒，计算结果: " + count);
    }

    private static void putQueueAtRow(short[][] chess, int row) {
        /**
         * 递归终止判断：如果row = N，则说明已经成功摆了N个皇后
         * 输出结果终止递归
         */
        if (row == N){
            count++;
//            System.out.println("第" + count + "种解;");
//            for (int i = 0; i < N; i++){
//                for (int j = 0; j < N; j++){
//                    System.out.print(chess[i][j] + " ");
//                }
//                System.out.println();
//            }
            return ;
        }
        short[][] chessTemp = chess.clone();
        /**
         * 向每一行的每一个位置尝试放置皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放记录
         */
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                chessTemp[row][j] = 0;
            }
            chessTemp[row][i] = 1;
            if (isSafety(chessTemp, row, i)){
                putQueueAtRow(chessTemp, row + 1);
            }
        }
    }

    private static boolean isSafety(short[][] chessTemp, int row, int col) {
        /**
         * 判断中上，左上，右上是否安全
         */
        int sept = 1;
        while(row - sept >= 0){
            /**
             * 中上
             */
            if (chessTemp[row - sept][col] == 1){
                return false;
            }
            /**
             * 左上
             */
            if (col - sept >= 0 && chessTemp[row - sept][col - sept] == 1){
                return false;
            }
            /**
             * 右上
             */
            if (col + sept < N && chessTemp[row - sept][col + sept] == 1){
                return false;
            }
            sept++;
        }
        return true;
    }
}

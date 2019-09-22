package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Solution371 位运算两数相加
 * @author: Elliot
 * @create: 2019-07-27 23:18
 **/
public class Solution371 {
    public int getSum(int a, int b) {
        int and = a & b; //与运算结果，1的位代表两个数值都为1，存在进位
        int eor = a ^ b; //异或运算结果，1的位代表两个数值对应位有一个为1

        //若and不为0，意味着存在进位情况，将进位左移
        if(and != 0) {
            and = and << 1;
        }

        //当进位为1的位数和有一位为1的位数相遇，与运算为1，证明再次存在进位运算
        while((and & eor) != 0){
            //计算新的进位
            int newAnd = and & eor;
            //再次比较出有一位为1的位数
            eor = and ^ eor;
            //把进位左移
            and = newAnd <<1;
        }
        //进位和有一位为1的位已经没有重叠，通过异或运算得出最终位数状态
        //为什么用抑或而不是或运算，因为之前应该进位的位没有改为0，
        //而该进的位已经写到最终的位置，因此原有两位都是1的值要通过抑或变为0
        return and ^ eor;
    }
}

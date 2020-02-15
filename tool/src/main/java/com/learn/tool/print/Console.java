package com.learn.tool.print;

import java.io.PrintStream;
import java.util.List;

/**
 * @program: learn
 * @description: 控制台输出
 * @author: Elliot
 * @create: 2020-02-15 01:48
 **/
public class Console {

    private static PrintStream out = System.out;

    public void printArray(int[] nums){
         for(int num : nums){
             out.print(num);
         }
         out.println();
    }


    public void printDoubleArray(int[][] matrix){
        for (int[] nums : matrix) {
            printArray(nums);
        }
    }

    public void printList(List<Integer> list){
        for(int num : list){
            out.print(num);
        }
        out.println();
    }

    public void printDoubleList(List<List<Integer>> matrix){
        for (List<Integer> list : matrix) {
            printList(list);
        }
    }

}

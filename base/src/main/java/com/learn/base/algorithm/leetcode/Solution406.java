package com.learn.base.algorithm.leetcode;

import java.util.Arrays;

/**
 * @program: learn
 * @description: Solution406
 * @author: Elliot
 * @create: 2019-07-20 22:25
 **/
public class Solution406 {
    public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return new int[][]{};
        }
        Arrays.sort(people,  (int[] nums1, int[] nums2)->{
            if(nums1[0] == nums2[0]){
                return nums1[1] - nums2[1];
            }
            return nums2[0] - nums1[0];
        });
        for (int i = 0; i < people.length; i++) {
            int k = i;
            int j = people[i][1];
            int[] temp = new int[]{people[i][0], people[i][1]};
            while(k > 0 && k > j){
                people[k] = people[k - 1];
                k--;
            }
            people[k] = temp;
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        people = reconstructQueue(people);
        for (int[] person : people){
            System.out.println("{" + person[0] + "," + person[1] +"}");
        }
    }
}

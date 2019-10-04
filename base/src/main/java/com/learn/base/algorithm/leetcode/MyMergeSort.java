package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: 自己实现的归并排序
 * @author: Elliot
 * @create: 2019-10-04 19:52
 **/
public class MyMergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{1,5,4,9,7,6,4,3,2};
        mergeSort(data);
        for (int i : data){
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int L, int R) {
        if(L == R){
            return ;
        }
        int mid = L + ((R - L) >> 1);
        sort(nums, L, mid);
        sort(nums, mid + 1, R);
        merge(nums, L, mid, R);
    }

    public static void merge(int[] nums, int L, int mid, int R){
        int[] temp = new int[R - L + 1];
        int p1 = L, p2 = mid + 1, i = 0;
        while(p1 <= mid && p2 <= R){
            temp[i++] = nums[p1] > nums[p2] ? nums[p2++] : nums[p1++];
        }
        while(p1 <= mid){
            temp[i++] = nums[p1++];
        }
        while(p2 <= R){
            temp[i++] = nums[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[L + j] = temp[j];
        }
    }
}

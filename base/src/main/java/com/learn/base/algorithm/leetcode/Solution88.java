package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: Sloution88 合并两个有序数组
 * @author: Elliot
 * @create: 2019-07-17 18:50
 * https://leetcode-cn.com/problems/merge-sorted-array/
 **/
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int curr = nums1.length - 1;
        while (nIndex >= 0 && mIndex >= 0) {
            nums1[curr--] = nums1[mIndex] > nums2[nIndex] ?
                    nums1[mIndex--] : nums2[nIndex--];
        }
        /**
         * 这里主要是怕nums2的长度是1
         */
        System.arraycopy(nums2, 0, nums1, 0, nIndex + 1);
    }
}

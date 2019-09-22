package com.learn.base.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {

    @Test
    public void yihuoTest() {
        int i = 4;
        Assert.assertEquals(0, i ^ i);
        Assert.assertEquals(4, i ^ 0);
    }

    @Test
    public void array1Test() {
        int i = Array.singleNumber(new int[]{1, 1, 2, 2, 3});
        int i2 = Array.singleNums(new int[]{1, 1, 2, 2, 3});
        System.out.println(i);
        System.out.println(i2);
    }

}

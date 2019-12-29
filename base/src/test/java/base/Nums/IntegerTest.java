package base.Nums;

import org.junit.Test;

/**
 * @program: learn
 * @description: IntegerTest
 * @author: Elliot
 * @create: 2019-07-27 01:15
 **/
public class IntegerTest {
    @Test
    public void valueOfTest(){
        Integer i = Integer.valueOf('1');
        System.out.println(i);
    }

    /**
     * getChars不是一个公开的方法，仅供内部使用
     * 作用是获取这个数字的字符串表示
     * 这个demo中获取的是{4, 0}这个buf
     */
    @Test
    public void testGetChars(){
        Integer i = Integer.valueOf(40);
        System.out.println(i.toString());
    }

    @Test
    public void printMaxValue(){
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void roxTest(){
        int q = 1;
        System.out.println((q << 6) + (q << 5) + (q << 2));
    }

    @Test
    public void hexTest(){
        System.out.println(0x64);
    }

    @Test
    public void mutiTest(){
        int q = 6;
        System.out.println((q << 2) + (q << 0));
    }

    @Test
    public void bitCountTest(){
        Integer.bitCount(100);
    }

    @Test
    public void unsignedTest(){
        System.out.println(10 >>> 1);
        System.out.println(10 >> 1);
        System.out.println(-10 >>> 1);
        System.out.println(-10 >> 1);
    }

}

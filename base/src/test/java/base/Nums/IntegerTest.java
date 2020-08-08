package base.Nums;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Properties;

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

    @Test
    public void parseInt(){
        System.out.println(Integer.parseInt("0", 10));
        System.out.println(Integer.parseInt("473", 10));
        System.out.println(Integer.parseInt("+42", 10));
        System.out.println(Integer.parseInt("-30", 10));
        System.out.println(Integer.parseInt("-FF", 16));
        System.out.println(Integer.parseInt("1100110", 2));
        System.out.println(Integer.parseInt("Kona", 27));
    }

    @Test
    public void lessThanTest(){
        char c = 'a';
        if(c >>> 8 == 0){
            System.out.println("是个字符...");
        }else{
            System.out.println("不会走到这里的。。");
        }
    }

    @Test
    public void objTest(){
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        Integer i3 = Integer.valueOf(1);
        Integer i4 = Integer.valueOf(1);
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

    @Test
    public void integerCacheTest(){
        Properties properties = new Properties();
        Integer i1 = Integer.valueOf(300);
        Integer i2 = Integer.valueOf(300);
        System.out.println(i1 == i2);
    }

    @Test
    public void cacheTest() throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = Integer.class.getDeclaredClasses()[0];
        Field field = clazz.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] cache = (Integer[])field.get(clazz);
        cache[132] = cache[133];
        int a = 2;
        int b = a + a;
        System.out.printf("%d+%d=%d", a, a, b);
        System.out.println();
        System.out.println(a + "+" + a + "=" + b);
    }

}

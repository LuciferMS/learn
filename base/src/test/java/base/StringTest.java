package base;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {

    @Test
    public void replaceTest() {
        String s = "IV";
        System.out.println(s.replace("IV", ""));
    }

    @Test
    public void splitTest(){
        String s = "AAaaaa";
        String[] ss = s.split("");
        for (String s1 : ss){
            System.out.println(s1);
        }
    }


    @Test
    public void stringHashTest() {
        String s1 = "Aa";
        String s2 = "BB";
        Assert.assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void internTest(){
        String s = new String("1");
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    @Test
    public void internTest2(){
        String s = new String("1");
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }

    @Test
    public void subCharArrayTest(){
        char[] chars = {'a', 'b', 'c', 'd'};
        String s = new String(chars, 1, 2);
        System.out.println(s);
    }

    @Test
    public void indexTest(){
        String s = "1288888";
        System.out.println(s.indexOf('8'));
    }

    @Test
    public void subStringTest(){
        String s = "25525511125";
        System.out.println(s.substring(0, 1));
    }
}

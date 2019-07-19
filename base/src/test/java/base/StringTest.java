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
    public void stringHashTest() {
        String s1 = "Aa";
        String s2 = "BB";
        Assert.assertEquals(s1.hashCode(), s2.hashCode());
    }
}

package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Elliot
 * 关于数组的学习
 */
public class ArrayTest {

    @Test
    public void intTest() throws ClassNotFoundException {
        /**
         * [I 表示int[]的class I表示int，但是却不可以用Class.forName("I")获取int的class，会抛出ClassNotFoundException
         */
        Class intArray = Class.forName("[I");
        Assert.assertNotNull(intArray);
    }
}

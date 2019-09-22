package base.Nums;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @program: learn
 * @description: 浮点数注意点
 * @author: Elliot
 * @create: 2019-07-21 16:54
 **/
public class FloatTest {

    /**
     * Java 对于任意一个浮点字面量，最终都舍入到所能表示的最靠近的那个浮点值，
     * 遇到该值离左右两个能表示的浮点值距离相等时，默认采用偶数优先的原则——这
     * 就是为什么我们会看到两个都以 4 结尾的浮点值的原因。
     */
    @Test
    public void floatTest(){
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        if (a == b){
            System.out.println("==");
        }else {
            System.out.println("!=");
        }
    }

    /**
     * 从源码可以看得出来，包装器 Float 的确没有对精度做任何处理，
     * 况且 equals 方法的内部仍然使用了 == 进行判断。
     */
    @Test
    public void floatReferenceTest(){
        Float a = 1.0f - 0.9f;
        Float b = 0.9f - 0.8f;
        Assert.assertEquals(a, b);
    }

    /**
     * 使用 double 传参的时候会产生不可预期的结果，比如说 0.1
     * 实际的值是 0.1000000000000000055511151231257827021181583404541015625，
     * 说白了，这还是精度的问题。所以使用BigDecimal构建double实例的时候建议用与之匹配的String来构建
     */
    @Test
    public void BigDecimalTest(){
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }

}

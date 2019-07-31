package base;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: 泛型编译测试
 * @author: Elliot
 * @create: 2019-07-11 13:16
 **/
public class FanXingTest {
    /**
     * 这里是说明java泛型是擦除法不是增类法
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(stringList.getClass() == integers.getClass());
    }

    /**
     * LocalVariableTypeTable 和 Signature 是针对泛型引入的新的属性，用来解决泛型的参数类型识别问题，
     * Signature 最为重要，它的作用是存储一个方法在字节码层面的特征签名，这个属性保存的不是原生类型，
     * 而是包括了参数化类型的信息。我们依然可以通过反射的方式拿到参数的类型。所谓的擦除，只是把方法
     * code 属性的字节码进行擦除。
     * 就像下面这样的一段代码，如果在使用反射的时候不获取泛型信息，就没办法正常运行了
     *
     * @param strings
     */
    public static char[] testMethod(List<String> strings) {
        String s = strings.get(0);
        return s.toCharArray();
    }
}

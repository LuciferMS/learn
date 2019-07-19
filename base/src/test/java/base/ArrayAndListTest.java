package base;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Elliot
 * List和Array相互转化的测试
 */
public class ArrayAndListTest {


    /**
     * 这里声明两个数组,是为了分开测试基本数据类型和引用类型的相互转化。
     * 这两者是不一样的
     * 详情看下面的测试用例
     */
    private int[] intArray = {1, 3, 4, 5};

    private Integer[] integerArray = {1, 2, 3, 4};

    private String[] strings = {"Elliot", "party"};

    /**
     * 数组转List的测试，这里测试的是引用类型和基本数据类型
     * 因为List<E>元素只能是引用类型，就算是我们经常用的list.add(1)这样子加入一个int其实内部应该是进行了装箱操作
     * 那么基本数据类型的数组怎么转化成List呢。。。
     */
    @Test
    public void arrayToListTest() {
        /**
         * 这里将引用类型的数组转化为List，问题不是很大，直接调用API就好
         * 这里有一个值得注意的地方就是，asList方法其实返回的是一个数组的视图，(返回的是Arrays的私有静态内部类java.util.Arrays.ArrayList)
         * 仅供读取和修改操作,如果要对数组进行add操作和remove操作，会抛出UnsupportedOperationException异常,为什么会这样？？
         * 翻看java.util.Arrays.ArrayList的源码，add和remove这样能修改数组的方法，都是直接抛出异常，数组是使用final修饰的
         * 而且他也没有提供像java.util.ArrayList这样对数组的动态扩容的操作
         */
        List<String> stringList = Arrays.asList(strings);
        //stringList.add("love");

        /**
         * 使用这个方法对引用类型数组转化成List是可以进行修改操作的
         * 这里使用的是 java.util.ArrayList的这个ArrayList(Collection<? extends E> c) 构造方法
         * 看了下源码,这个构造方法是将c中的元素转化成数组，然后复制进ArrayList的elementData
         */
        List<String> stringList1 = new ArrayList<String>(Arrays.asList(strings));
        //stringList1.add("love");

        /**
         * 话说这个是最快的方式,采用的按位或运算进行复制
         */
        List<String> stringList2 = new ArrayList<String>(strings.length);
        Collections.addAll(stringList2, strings);


        /**
         * 这里是将基本数据类型的数组转化成List
         * 如果还想上面那样直接调用Api,也就是Arrays提供的asList方法(就是写成List<Integer> list = Array.asList(intArray))，编译器就会报错
         * 但是如果是对Integer数组进行List<Integer> integers = Arrays.asList(integerArray);这样的操作是可以的，就是说这个方法只能转化引用类型的数组
         * 所以下面这个转化方法的思路是，int[]这个数组的元素是基本数据类型，但是int[]这个数组是引用类型，所以可以创建一个元素是int[]的list,将int[]对象转化成list
         * 但是这样转完全没有达到我们的目标，转化出来的list是[{1, 2, 3},{1, 3, 4}]这样的
         * 怎么将基本数据类型的数组变成[1, 3, 4]这样子，我还在想...(创建java.util.ArrayList实例然后for循环add？？)
         */
        List<int[]> intList = Arrays.asList(intArray);

        System.out.println(stringList);
        System.out.println(stringList1);
        System.out.println(stringList2);
        System.out.println(intList);
    }

    /**
     * List转Array
     */
    @Test
    public void listToArrayTest() {
        List<String> stringList1 = new ArrayList<String>(Arrays.asList(strings));
        String[] strings = stringList1.toArray(new String[0]);
        System.out.println(strings);
    }

    /**
     * 判断一个对象是不是数组
     */
    @Test
    public void isArrays() {
        /**
         * 我原本以为数组是Arrays的实例，这句话在编译时期就会报错
         * 看来我的设想是错误的
         */
        //Assert.assertEquals(true, strings instanceof Arrays);
        System.out.println(strings.getClass().getName());
        System.out.println(intArray.getClass().getName());
        /**
         * 判断对象是不是数组
         */
        System.out.println(strings.getClass().isArray());
    }


}

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

    /**
     * parent是sub的父类，sub数组是parent数组的实例你敢信
     */
    @Test
    public void arrayClassTest() {
        Parent[] parents = new Parent[2];
        Sub[] subs = new Sub[2];
        System.out.println(subs instanceof Parent[]);
    }

    /**
     * parent是sub的父类
     * 但是parent数组是可以添加sub实例的
     * 这个设计感觉是数组的缺陷
     * 所以effective java上面说优先使用泛型（或者说集合框架的容器）
     * 感觉可以研究一下数组内部结构，数组的实质是对象，但是在jvm中是怎么存储的，要了解一下
     */
    @Test
    public void arrayAddTest() {
        Parent[] parents = new Parent[2];
        Sub sub = new Sub();
        parents[1] = sub;
    }

    /**
     * 二维数组本质已经不再是基本数据类型数组，已经是引用类型数组了
     */
    @Test
    public void doubleArrayTest() {
        int[][] datas = new int[2][];
        datas[0] = new int[]{1, 2, 3, 4};
        datas[1] = new int[]{1, 2, 3, 4, 5};
        for (int[] data : datas) {
            System.out.println(data.length);
        }
    }

    /**
     * 数组的拷贝是浅拷贝，只保证返回不一样的数组对象
     * 不保证元素不一样。。。。
     */
    @Test
    public void arrayCloneTest(){
        Parent[] parents = {new Parent(), new Parent()};
        Parent[] parents1 = parents.clone();
        System.out.println(parents[0] == parents1[0]);
    }
}


class Parent {

}

class Sub extends Parent {

}
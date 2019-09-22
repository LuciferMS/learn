package base;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: 泛型测试
 * @author: Elliot
 * @create: 2019-08-13 12:30
 **/
public class FanXingTest {
    static class A{

    }

    static class B extends A{

    }

    static class C extends A{

    }

    public void baseTest(){
        List<? extends A> list = new ArrayList<B>();
    }
}

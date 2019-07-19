package base.thread;

import org.junit.Assert;
import org.junit.Test;

public class UnsafeTester {

    @Test
    public void getBeanByUnsafeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        UserTestBean userTestBean = (UserTestBean) UnsafeTest.getTestBeanByUnsafe();
        Assert.assertNotNull(userTestBean);
        /**
         * unsafe创建的实例，并没有调用构造器，实例基本属性是基本数据类型的话就是默认值，如果是引用类型就是null
         */
//        Assert.assertEquals("Elliot", userTestBean.getName());
//        Assert.assertEquals(20, userTestBean.getAge());
    }
}

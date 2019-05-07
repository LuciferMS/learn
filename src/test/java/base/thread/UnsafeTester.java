package base.thread;

import org.junit.Assert;
import org.junit.Test;

public class UnsafeTester {

    @Test
    public void getBeanByUnsafeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        UserTestBean userTestBean = (UserTestBean) UnsafeTest.getTestBeanByUnsafe();
        Assert.assertNotNull(userTestBean);
        //
//        Assert.assertEquals("Elliot", userTestBean.getName());
//        Assert.assertEquals(20, userTestBean.getAge());
    }
}

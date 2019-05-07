package base.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Elliot
 * unsafe
 */
public class UnsafeTest {
    public static void main(String[] args) {

    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe)f.get(null);
        return unsafe;
    }

    public static Object getTestBeanByUnsafe() throws InstantiationException, NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafe();
        UserTestBean userTestBean = (UserTestBean) unsafe.allocateInstance(UserTestBean.class);
        return userTestBean;
    }

}

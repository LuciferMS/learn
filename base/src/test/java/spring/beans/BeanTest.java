package spring.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.SimpleBean;

/**
 * @program: learn
 * @description: spring bean测试
 * @author: Elliot
 * @create: 2019-06-30 23:06
 **/
public class BeanTest {

    @Test
    public void getBeanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/test-bean.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);
        System.out.println(bean.getName());
    }
}

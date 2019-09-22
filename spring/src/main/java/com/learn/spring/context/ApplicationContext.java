package com.learn.spring.context;

import com.learn.spring.beans.factory.BeanFactory;

/**
 * 对beanFactory的包装，屏蔽beanFactory实现细节
 * 提供用户的使用的api
 * @author Elliot
 */
public interface ApplicationContext extends BeanFactory {

}

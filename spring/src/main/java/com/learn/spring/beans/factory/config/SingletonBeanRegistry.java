package com.learn.spring.beans.factory.config;

/**
 * @author Elliot
 */
public interface SingletonBeanRegistry {

    /**
     * 注册单例bean
     * @param beanName
     * @param singletonObject
     */
	void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取bean
     * @param beanName
     * @return
     */
	Object getSingleton(String beanName);
}

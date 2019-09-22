package com.learn.spring.beans.factory.config;

import java.util.List;

/**
 * classloader相关
 * @author Elliot
 */
public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory {

    /**
     * 设置classloader
     * @param beanClassLoader
     */
	void setBeanClassLoader(ClassLoader beanClassLoader);

    /**
     * 获取bean的classloader
     * @return
     */
	ClassLoader getBeanClassLoader();

    /**
     *
     * @param postProcessor
     */
	void addBeanPostProcessor(BeanPostProcessor postProcessor);

    /**
     * @return
     */
	List<BeanPostProcessor> getBeanPostProcessors();
}

package com.learn.spring.beans.factory.support;

import com.learn.spring.beans.BeanDefinition;
import com.learn.spring.beans.factory.BeanCreationException;
import com.learn.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * beanFactory抽象类
 * @author Elliot
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory {

    /**
     *  顾名思义
     * @param bd
     * @return
     * @throws BeanCreationException
     */
	protected abstract Object createBean(BeanDefinition bd) throws BeanCreationException;

}

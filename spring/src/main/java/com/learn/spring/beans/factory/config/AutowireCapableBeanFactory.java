package com.learn.spring.beans.factory.config;

import com.learn.spring.beans.factory.BeanFactory;

/**
 * 注解注入
 * @author Elliot
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 注解注入
     * @param descriptor 依赖描述符
     * @return
     */
	public Object resolveDependency(DependencyDescriptor descriptor);

}

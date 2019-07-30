package org.litespring.beans.factory;

import org.litespring.beans.exception.NoSuchBeanDefinitionException;

public interface BeanFactory {

	Object getBean(String beanID);
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;
}

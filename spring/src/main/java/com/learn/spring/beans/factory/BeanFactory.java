package com.learn.spring.beans.factory;

import java.util.List;

/**
 * beanFactory
 * @author Elliot
 */
public interface BeanFactory {

	Object getBean(String beanID);
	
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;

	List<Object> getBeansByType(Class<?> type);


}

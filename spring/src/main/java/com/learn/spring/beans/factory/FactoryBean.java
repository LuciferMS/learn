package com.learn.spring.beans.factory;


/**
 * @author Elliot
 */
public interface FactoryBean<T> {

	
	T getObject() throws Exception;

	Class<?> getObjectType();

}

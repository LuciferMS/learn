package com.learn.spring.beans.factory;

import com.learn.spring.beans.BeansException;

/**
 * bean定义出错
 * @author Elliot
 */
public class BeanDefinitionStoreException extends BeansException {

	public BeanDefinitionStoreException(String msg, Throwable cause) {
		super(msg, cause);
		
	}
	public BeanDefinitionStoreException(String msg) {
		super(msg);
}
	
}

package com.learn.spring.test.v5;

import java.lang.reflect.Method;

import com.learn.spring.aop.config.AspectInstanceFactory;
import com.learn.spring.beans.factory.BeanFactory;
import com.learn.spring.beans.factory.support.DefaultBeanFactory;
import com.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.spring.core.io.ClassPathResource;
import com.learn.spring.core.io.Resource;
import com.learn.spring.tx.TransactionManager;

public class AbstractV5Test {
		
	protected BeanFactory getBeanFactory(String configFile){
		DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
		Resource resource = new ClassPathResource(configFile);
		reader.loadBeanDefinitions(resource);	
		return  defaultBeanFactory;		
	}
	
	protected  Method getAdviceMethod( String methodName) throws Exception{
		return TransactionManager.class.getMethod(methodName);
	}
	
	protected AspectInstanceFactory getAspectInstanceFactory(String targetBeanName){
		AspectInstanceFactory factory = new AspectInstanceFactory();
		factory.setAspectBeanName(targetBeanName);		
		return factory;
	}
	
	
}

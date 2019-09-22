package com.learn.spring.context.support;

import java.util.List;

import com.learn.spring.core.io.Resource;
import com.learn.spring.aop.aspectj.AspectJAutoProxyCreator;
import com.learn.spring.beans.factory.NoSuchBeanDefinitionException;
import com.learn.spring.beans.factory.annotation.AutowiredAnnotationProcessor;
import com.learn.spring.beans.factory.config.ConfigurableBeanFactory;
import com.learn.spring.beans.factory.support.DefaultBeanFactory;
import com.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.spring.context.ApplicationContext;
import com.learn.spring.util.ClassUtils;

/**
 * ApplicationContext的默认实现
 * @author Elliot
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

	private DefaultBeanFactory factory = null;
	private ClassLoader beanClassLoader;
	
	public AbstractApplicationContext(String configFile){
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);	
		Resource resource = this.getResourceByPath(configFile);
		reader.loadBeanDefinitions(resource);
		factory.setBeanClassLoader(this.getBeanClassLoader());
		registerBeanPostProcessors(factory);
	}
	
	@Override
    public Object getBean(String beanID) {
		return factory.getBean(beanID);
	}
	
	protected abstract Resource getResourceByPath(String path);
	
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

    public ClassLoader getBeanClassLoader() {
		return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
	}
    protected void registerBeanPostProcessors(ConfigurableBeanFactory beanFactory) {
    	{
			AutowiredAnnotationProcessor postProcessor = new AutowiredAnnotationProcessor();
			postProcessor.setBeanFactory(beanFactory);
			beanFactory.addBeanPostProcessor(postProcessor);
    	}
    	{
    		AspectJAutoProxyCreator postProcessor = new AspectJAutoProxyCreator();
    		postProcessor.setBeanFactory(beanFactory);
    		beanFactory.addBeanPostProcessor(postProcessor);
    	}
		
	}
    @Override
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException{
    	return this.factory.getType(name);
    }
    @Override
    public List<Object> getBeansByType(Class<?> type){
    	return this.factory.getBeansByType(type);
    }

}

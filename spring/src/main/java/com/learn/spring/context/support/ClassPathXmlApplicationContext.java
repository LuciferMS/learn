package com.learn.spring.context.support;

import com.learn.spring.core.io.ClassPathResource;
import com.learn.spring.core.io.Resource;

/**
 * 从classPath获取bean
 * @author Elliot
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	public ClassPathXmlApplicationContext(String configFile) {
		super(configFile);
		
	}

	@Override
	protected Resource getResourceByPath(String path) {
		
		return new ClassPathResource(path,this.getBeanClassLoader());
	}

}

package com.learn.spring.test.v4;

import java.lang.reflect.Field;

import com.learn.spring.beans.factory.config.DependencyDescriptor;
import com.learn.spring.beans.factory.support.DefaultBeanFactory;
import com.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.spring.core.io.ClassPathResource;
import com.learn.spring.core.io.Resource;
import com.learn.spring.dao.v4.AccountDao;
import com.learn.spring.service.v4.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class DependencyDescriptorTest {

	@Test
	public void testResolveDependency() throws Exception{
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v4.xml");
		reader.loadBeanDefinitions(resource);
		
		Field f = PetStoreService.class.getDeclaredField("accountDao");
		DependencyDescriptor descriptor = new DependencyDescriptor(f,true);
		Object o = factory.resolveDependency(descriptor);
		Assert.assertTrue(o instanceof AccountDao);
	}

}

package com.learn.spring.test.v1;

import static org.junit.Assert.*;


import com.learn.spring.beans.BeanDefinition;
import com.learn.spring.beans.factory.BeanCreationException;
import com.learn.spring.beans.factory.BeanDefinitionStoreException;
import com.learn.spring.beans.factory.support.DefaultBeanFactory;
import com.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.spring.core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.learn.spring.service.v1.PetStoreService;

public class BeanFactoryTest {
	DefaultBeanFactory factory = null;
	XmlBeanDefinitionReader reader = null;
	
	@Before
	public void setUp(){
		factory = new DefaultBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		
	}

    /**
     * 测试获取bean
     * 1.加载xml配置文件，解析成beanDefinition
     * 2.获取bean
     */
	@Test
	public void testGetBean() {
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		BeanDefinition bd = factory.getBeanDefinition("petStore");
		assertTrue(bd.isSingleton());
		assertFalse(bd.isPrototype());
		assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());
		assertEquals("com.learn.spring.service.v1.PetStoreService",bd.getBeanClassName());
		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");
		assertNotNull(petStore);
		PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");
		assertTrue(petStore.equals(petStore1));
	}
	
	@Test
	public void testInvalidBean(){

		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		try{
			factory.getBean("invalidBean");
		}catch(BeanCreationException e){
			return;
		}
		Assert.fail("expect BeanCreationException ");
	}
	@Test
	public void testInvalidXML(){
		
		try{
			reader.loadBeanDefinitions(new ClassPathResource("xxxx.xml"));
		}catch(BeanDefinitionStoreException e){
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException ");
	}

}

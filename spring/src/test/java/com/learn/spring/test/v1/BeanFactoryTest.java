package org.litespring.test.v1;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.exception.BeanCreationException;
import org.litespring.beans.exception.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.service.v1.PetStoreService;

public class BeanFactoryTest {
	DefaultBeanFactory beanFactory=null;
	XmlBeanDefinitionReader reader=null;
	@Before
	public void setUp() {
		beanFactory=new DefaultBeanFactory();
		reader=new XmlBeanDefinitionReader(beanFactory);
	}
	@Test
	public void testGetBean() {
		/* 1.��ȡxml�����ļ���ȡbean���� */
		//BeanFactory beanFactory=new DefaultBeanFactory("petstore-v1.xml");
		
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		/* 2.����bean��id��bean�����л�ȡĳ��bean�Ķ��� */
		BeanDefinition bd=beanFactory.getBeanDefinition("petStore");
		assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
		/* ����bean��id��bean�����л�ȡbean��ʵ�� */
		PetStoreService petStore=(PetStoreService)beanFactory.getBean("petStore");
		assertNotNull(petStore);
	}
	
	@Test
	public void testBeanScope() {
		/* 1.��ȡxml�����ļ���ȡbean���� */
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		/* 2.����bean��id��bean�����л�ȡĳ��bean�Ķ��� */
		BeanDefinition bd=beanFactory.getBeanDefinition("petStore");
		
		assertTrue(bd.isSingleton());
		
		assertFalse(bd.isPrototype());
		
		assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());
		
		assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
		/* 3.����bean��id��bean�����л�ȡbean��ʵ�� */
		PetStoreService petStore1=(PetStoreService)beanFactory.getBean("petStore");
		assertNotNull(petStore1);
		PetStoreService petStore2=(PetStoreService)beanFactory.getBean("petStore");
		assertTrue(petStore1.equals(petStore2));
	}
	
	
	@Test
	public void testInvalidBean() {
		try{
			reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
			beanFactory.getBean("invalidBean");
		}catch(BeanCreationException ex) {
			return;
		}
		//Assert.fail("�����bean");
	}
	
	@Test
	public void testInvalidXML() {
		try{
			reader.loadBeanDefinitions(new ClassPathResource("invalidXml.xml"));
		}catch(BeanDefinitionStoreException ex) {
			return;
		}
		Assert.fail("�����xml");
	}
}

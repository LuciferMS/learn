package com.learn.spring.test.v4;

import java.lang.reflect.Field;
import java.util.LinkedList;

import com.learn.spring.beans.factory.annotation.AutowiredFieldElement;
import com.learn.spring.beans.factory.annotation.InjectionElement;
import com.learn.spring.beans.factory.annotation.InjectionMetadata;
import com.learn.spring.beans.factory.support.DefaultBeanFactory;
import com.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.spring.core.io.ClassPathResource;
import com.learn.spring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;
import com.learn.spring.dao.v4.AccountDao;
import com.learn.spring.dao.v4.ItemDao;
import com.learn.spring.service.v4.PetStoreService;

public class InjectionMetadataTest {

	@Test
	public void testInjection() throws Exception{
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v4.xml");
		reader.loadBeanDefinitions(resource);
		
		Class<?> clz = PetStoreService.class;
		LinkedList<InjectionElement> elements = new LinkedList<InjectionElement>();
		
		{
			Field f = PetStoreService.class.getDeclaredField("accountDao");		
			InjectionElement injectionElem = new AutowiredFieldElement(f,true,factory);
			elements.add(injectionElem);
		}
		{
			Field f = PetStoreService.class.getDeclaredField("itemDao");		
			InjectionElement injectionElem = new AutowiredFieldElement(f,true,factory);
			elements.add(injectionElem);
		}
		
		InjectionMetadata metadata = new InjectionMetadata(clz,elements);
		
		PetStoreService petStore = new PetStoreService();
		
		metadata.inject(petStore);
		
		Assert.assertTrue(petStore.getAccountDao() instanceof AccountDao);
		
		Assert.assertTrue(petStore.getItemDao() instanceof ItemDao);
		
	}
}

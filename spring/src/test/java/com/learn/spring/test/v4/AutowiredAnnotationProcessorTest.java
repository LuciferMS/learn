package com.learn.spring.test.v4;

import java.lang.reflect.Field;
import java.util.List;

import com.learn.spring.beans.factory.annotation.AutowiredAnnotationProcessor;
import com.learn.spring.beans.factory.annotation.AutowiredFieldElement;
import com.learn.spring.beans.factory.annotation.InjectionElement;
import com.learn.spring.beans.factory.annotation.InjectionMetadata;
import com.learn.spring.beans.factory.config.DependencyDescriptor;
import com.learn.spring.beans.factory.support.DefaultBeanFactory;
import com.learn.spring.dao.v4.AccountDao;
import com.learn.spring.dao.v4.ItemDao;
import com.learn.spring.service.v4.PetStoreService;
import org.junit.Assert;
import org.junit.Test;


public class AutowiredAnnotationProcessorTest {
	AccountDao accountDao = new AccountDao();
	ItemDao itemDao = new ItemDao();
	DefaultBeanFactory beanFactory = new DefaultBeanFactory(){
		public Object resolveDependency(DependencyDescriptor descriptor){
			if(descriptor.getDependencyType().equals(AccountDao.class)){
				return accountDao;
			}
			if(descriptor.getDependencyType().equals(ItemDao.class)){
				return itemDao;
			}
			throw new RuntimeException("can't support types except AccountDao and ItemDao");
		}
	};
	
	

	@Test
	public void testGetInjectionMetadata(){
		
		AutowiredAnnotationProcessor processor = new AutowiredAnnotationProcessor();
		processor.setBeanFactory(beanFactory);
		InjectionMetadata injectionMetadata = processor.buildAutowiringMetadata(PetStoreService.class);
		List<InjectionElement> elements = injectionMetadata.getInjectionElements();
		Assert.assertEquals(2, elements.size());
		
		assertFieldExists(elements,"accountDao");
		assertFieldExists(elements,"itemDao");
		
		PetStoreService petStore = new PetStoreService();
		
		injectionMetadata.inject(petStore);
		
		Assert.assertTrue(petStore.getAccountDao() instanceof AccountDao);
		
		Assert.assertTrue(petStore.getItemDao() instanceof ItemDao);
	}
	
	private void assertFieldExists(List<InjectionElement> elements ,String fieldName){
		for(InjectionElement ele : elements){
			AutowiredFieldElement fieldEle = (AutowiredFieldElement)ele;
			Field f = fieldEle.getField();
			if(f.getName().equals(fieldName)){
				return;
			}
		}
		Assert.fail(fieldName + "does not exist!");
	}
	
	

}

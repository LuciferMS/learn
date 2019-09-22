package com.learn.spring.test.v3;

import com.learn.spring.context.ApplicationContext;
import com.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;
import com.learn.spring.service.v3.PetStoreService;

public class ApplicationContextTestV3 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v3.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		
		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());		
		Assert.assertEquals(1, petStore.getVersion());
		
	}

}

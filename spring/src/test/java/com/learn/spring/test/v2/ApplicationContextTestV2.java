package com.learn.spring.test.v2;

import static org.junit.Assert.*;

import com.learn.spring.context.ApplicationContext;
import com.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import com.learn.spring.dao.v2.AccountDao;
import com.learn.spring.dao.v2.ItemDao;
import com.learn.spring.service.v2.PetStoreService;

public class ApplicationContextTestV2 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		
		assertNotNull(petStore.getAccountDao());
		assertNotNull(petStore.getItemDao());
		
		assertTrue(petStore.getAccountDao() instanceof AccountDao);
		assertTrue(petStore.getItemDao() instanceof ItemDao);
		
		assertEquals("liuxin",petStore.getOwner());
		assertEquals(2, petStore.getVersion()); 
		
	}

}

package org.litespring.test.v2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.service.v2.PetStoreService;

public class ApplicationContextTestV2 {
	
	@Test
	public void testGetBeanProperty() {
		ApplicationContext app=new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore=(PetStoreService) app.getBean("petStore");
		
		assertNotNull(petStore.getAccountDao());
		assertNotNull(petStore.getItemDao());
		
		assertEquals("zsw", petStore.getOwner());
		assertEquals(2, petStore.getVersion());
	}

}

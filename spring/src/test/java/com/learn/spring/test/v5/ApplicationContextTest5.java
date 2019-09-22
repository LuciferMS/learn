package com.learn.spring.test.v5;

import java.util.List;

import com.learn.spring.context.ApplicationContext;
import com.learn.spring.context.support.ClassPathXmlApplicationContext;
import com.learn.spring.service.v5.PetStoreService;
import com.learn.spring.util.MessageTracker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationContextTest5 {	
	
	@Before
	public void setUp(){
		MessageTracker.clearMsgs();
	}
	@Test
	public void testPlaceOrder() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v5.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		
		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());
		
		petStore.placeOrder();
		
		List<String> msgs = MessageTracker.getMsgs();
		
		Assert.assertEquals(3, msgs.size());
		Assert.assertEquals("start tx", msgs.get(0));	
		Assert.assertEquals("place order", msgs.get(1));	
		Assert.assertEquals("commit tx", msgs.get(2));	
		
	}	
	
	
}

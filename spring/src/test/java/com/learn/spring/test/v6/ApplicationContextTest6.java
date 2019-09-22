package com.learn.spring.test.v6;

import java.util.List;

import com.learn.spring.context.ApplicationContext;
import com.learn.spring.context.support.ClassPathXmlApplicationContext;
import com.learn.spring.service.v6.IPetStoreService;
import com.learn.spring.util.MessageTracker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationContextTest6 {
	
	
	
	@Test
	public void testGetBeanProperty() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v6.xml");
		IPetStoreService petStore = (IPetStoreService)ctx.getBean("petStore");
	
		petStore.placeOrder();
		
		List<String> msgs = MessageTracker.getMsgs();
		
		Assert.assertEquals(3, msgs.size());
		Assert.assertEquals("start tx", msgs.get(0));	
		Assert.assertEquals("place order", msgs.get(1));	
		Assert.assertEquals("commit tx", msgs.get(2));	
		
	}

	@Before
	public void setUp(){
		MessageTracker.clearMsgs();
	}
	
	
}

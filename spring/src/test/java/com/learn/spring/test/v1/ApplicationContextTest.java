package org.litespring.test.v1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.litespring.service.v1.PetStoreService;

public class ApplicationContextTest {

	@Test
	public void testClassPathXmlApplicationContext() {
		ApplicationContext app=new ClassPathXmlApplicationContext("petstore-v1.xml");
		PetStoreService petStore=(PetStoreService)app.getBean("petStore");
		assertNotNull(petStore);
	}
	
	@Test
	public void testFileSystemApplicationContext() {
		ApplicationContext app=new FileSystemXmlApplicationContext("E:\\eclipse-workspace\\litespring\\src\\test\\resources\\petstore-v1.xml");
		PetStoreService petStore=(PetStoreService)app.getBean("petStore");
		assertNotNull(petStore);
	}
}

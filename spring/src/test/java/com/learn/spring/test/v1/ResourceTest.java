package org.litespring.test.v1;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

public class ResourceTest {

	@Test
	public void testClassPathResource() throws Exception{
		Resource resource=new ClassPathResource("petstore-v1.xml");
		InputStream is=null;
		
		try{
			is=resource.getInputStream();
			Assert.assertNotNull(is);
		}finally {
			if(is!=null) {
				is.close();
			}
		}
	}
	
	@Test
	public void testFileSystemResource() throws Exception{
		Resource resource=new FileSystemResource("E:\\eclipse-workspace\\litespring\\src\\test\\resources\\petstore-v1.xml");
		InputStream is=null;
		
		try{
			is=resource.getInputStream();
			Assert.assertNotNull(is);
		}finally {
			if(is!=null) {
				is.close();
			}
		}
	}
}

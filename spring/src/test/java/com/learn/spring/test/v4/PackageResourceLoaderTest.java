package com.learn.spring.test.v4;

import java.io.IOException;

import com.learn.spring.core.io.Resource;
import com.learn.spring.core.io.support.PackageResourceLoader;
import org.junit.Assert;
import org.junit.Test;

public class PackageResourceLoaderTest {

	@Test
	public void testGetResources() throws IOException{
		PackageResourceLoader loader = new PackageResourceLoader();
		Resource[] resources = loader.getResources("org.litespring.dao.v4");
		Assert.assertEquals(2, resources.length);
		
	}

}

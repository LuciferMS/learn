package com.learn.spring.test.v4;

import java.io.IOException;

import com.learn.spring.core.annotation.AnnotationAttributes;
import com.learn.spring.core.io.ClassPathResource;
import com.learn.spring.core.type.AnnotationMetadata;
import com.learn.spring.core.type.classreading.MetadataReader;
import com.learn.spring.core.type.classreading.SimpleMetadataReader;
import com.learn.spring.stereotype.Component;
import org.junit.Assert;
import org.junit.Test;

public class MetadataReaderTest {
	@Test
	public void testGetMetadata() throws IOException{
		ClassPathResource resource = new ClassPathResource("com/learn/spring/service/v4/PetStoreService.class");
		
		MetadataReader reader = new SimpleMetadataReader(resource);
		//注意：不需要单独使用ClassMetadata
		//ClassMetadata clzMetadata = reader.getClassMetadata();
		AnnotationMetadata amd = reader.getAnnotationMetadata();
		
		String annotation = Component.class.getName();
		
		Assert.assertTrue(amd.hasAnnotation(annotation));		
		AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);
		Assert.assertEquals("petStore", attributes.get("value"));
		
		//注：下面对class metadata的测试并不充分
		Assert.assertFalse(amd.isAbstract());		
		Assert.assertFalse(amd.isFinal());
		Assert.assertEquals("org.litespring.service.v4.PetStoreService", amd.getClassName());
		
	}
}

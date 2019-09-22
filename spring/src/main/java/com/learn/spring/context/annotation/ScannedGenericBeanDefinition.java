package com.learn.spring.context.annotation;

import com.learn.spring.beans.factory.annotation.AnnotatedBeanDefinition;
import com.learn.spring.beans.factory.support.GenericBeanDefinition;
import com.learn.spring.core.type.AnnotationMetadata;

public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

	private final AnnotationMetadata metadata;


	public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
		super();
		
		this.metadata = metadata;
		
		setBeanClassName(this.metadata.getClassName());
	}


	public final AnnotationMetadata getMetadata() {
		return this.metadata;
	}

}
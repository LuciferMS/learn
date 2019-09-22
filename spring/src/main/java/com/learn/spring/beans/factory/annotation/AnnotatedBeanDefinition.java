package com.learn.spring.beans.factory.annotation;

import com.learn.spring.beans.BeanDefinition;
import com.learn.spring.core.type.AnnotationMetadata;

public interface AnnotatedBeanDefinition extends BeanDefinition {
	AnnotationMetadata getMetadata();
}

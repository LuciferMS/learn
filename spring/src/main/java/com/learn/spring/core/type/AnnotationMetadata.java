package com.learn.spring.core.type;

import java.util.Set;

import com.learn.spring.core.annotation.AnnotationAttributes;

public interface AnnotationMetadata extends ClassMetadata{
	
	Set<String> getAnnotationTypes();


	boolean hasAnnotation(String annotationType);
	
	public AnnotationAttributes getAnnotationAttributes(String annotationType);
}

package com.learn.spring.beans.factory.config;

import java.lang.reflect.Field;

import com.learn.spring.util.Assert;

/**
 * 依赖描述符
 * @author Elliot
 */
public class DependencyDescriptor {
	private  Field field;
	private boolean required;
	
	public DependencyDescriptor(Field field, boolean required) {
		Assert.notNull(field, "Field must not be null");
		this.field = field;		
		this.required = required;
		
	}
	public Class<?> getDependencyType(){
		if(this.field != null){
			return field.getType();
		}
		throw new RuntimeException("only support field dependency");
	}
	
	public boolean isRequired() {
		return this.required;
	}
}

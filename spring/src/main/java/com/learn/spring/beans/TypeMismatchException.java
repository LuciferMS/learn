package com.learn.spring.beans;

/**
 * 类型不匹配异常
 * @author Administrator
 */
public class TypeMismatchException extends BeansException{
	private transient Object value;

	private Class<?> requiredType;
	
	public TypeMismatchException( Object value, Class<?> requiredType) {
		super("Failed to convert value :"+value + "to type "+requiredType);
		this.value = value;
		this.requiredType = requiredType;
	}

	public Object getValue() {
		return value;
	}

	public Class<?> getRequiredType() {
		return requiredType;
	}


}

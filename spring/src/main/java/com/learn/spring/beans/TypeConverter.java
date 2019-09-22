package com.learn.spring.beans;

/**
 * 类型转换器
 * @author Elliot
 */
public interface TypeConverter {


	<T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;


}

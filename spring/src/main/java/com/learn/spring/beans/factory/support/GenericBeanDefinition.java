package com.learn.spring.beans.factory.support;

import java.util.ArrayList;
import java.util.List;

import com.learn.spring.beans.BeanDefinition;
import com.learn.spring.beans.ConstructorArgument;
import com.learn.spring.beans.PropertyValue;

/**
 * BeanDefinition默认实现
 * @author Elliot
 */
public class GenericBeanDefinition implements BeanDefinition {

	private String id;

	private String beanClassName;

	private Class<?> beanClass;

	private boolean singleton = true;

	private boolean prototype = false;

	private String scope = SCOPE_DEFAULT;
	
	List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

	private ConstructorArgument constructorArgument = new ConstructorArgument();

    /**
     *  表明这个Bean定义是不是我们自己合成的。
     */
	private boolean isSynthetic = false;
	
	public GenericBeanDefinition(String id, String beanClassName) {
		this.id = id;
		this.beanClassName = beanClassName;
	}

	public GenericBeanDefinition(Class<?> clz) {		
		this.beanClass = clz;
		this.beanClassName = clz.getName();
	}

	public GenericBeanDefinition() {
		
	}

	@Override
    public boolean isSynthetic() {
		return isSynthetic;
	}

	public void setSynthetic(boolean isSynthetic) {
		this.isSynthetic = isSynthetic;
	}

	@Override
    public String getBeanClassName() {
		return this.beanClassName;
	}

	public void setBeanClassName(String className){
		this.beanClassName = className;
	}

	@Override
    public Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException{
		String className = getBeanClassName();
		if (className == null) {
			return null;
		}
		Class<?> resolvedClass = classLoader.loadClass(className);
		this.beanClass = resolvedClass;
		return resolvedClass;
	}

	@Override
    public Class<?> getBeanClass() throws IllegalStateException {
		if(this.beanClass == null){
			throw new IllegalStateException(
					"Bean class name [" + this.getBeanClassName() + "] has not been resolved into an actual Class");
		}		
		return this.beanClass;
	}

	@Override
    public boolean hasBeanClass(){
		return this.beanClass != null;
	}

	@Override
    public boolean isSingleton() {
		return this.singleton;
	}

	@Override
    public boolean isPrototype() {
		return this.prototype;
	}

	@Override
    public String getScope() {
		return this.scope;
	}

	@Override
    public void setScope(String scope) {
		this.scope = scope;
		this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
		this.prototype = SCOPE_PROTOTYPE.equals(scope);
	}

	@Override
    public List<PropertyValue> getPropertyValues(){
		return this.propertyValues;
	}

	@Override
    public ConstructorArgument getConstructorArgument() {
		return this.constructorArgument;
	}

	@Override
    public String getID() {
		return this.id;
	}

	public void setId(String id){
		this.id = id;
	}

	@Override
    public boolean hasConstructorArgumentValues() {
		return !this.constructorArgument.isEmpty();
	}
}

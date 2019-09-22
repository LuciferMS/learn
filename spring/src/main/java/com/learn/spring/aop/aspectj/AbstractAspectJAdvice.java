package com.learn.spring.aop.aspectj;

import java.lang.reflect.Method;

import com.learn.spring.aop.Advice;
import com.learn.spring.aop.Pointcut;
import com.learn.spring.aop.config.AspectInstanceFactory;

public abstract class AbstractAspectJAdvice implements Advice {
	
	
	protected Method adviceMethod;	
	protected AspectJExpressionPointcut pointcut;
	protected AspectInstanceFactory adviceObjectFactory;
	
	
	
	public AbstractAspectJAdvice(Method adviceMethod,
			AspectJExpressionPointcut pointcut,
			AspectInstanceFactory adviceObjectFactory){
		
		this.adviceMethod = adviceMethod;
		this.pointcut = pointcut;
		this.adviceObjectFactory = adviceObjectFactory;
	}
	
	
	public void invokeAdviceMethod() throws  Throwable{
	
		adviceMethod.invoke(adviceObjectFactory.getAspectInstance());
	}
	public Pointcut getPointcut(){
		return this.pointcut;
	}
	public Method getAdviceMethod() {
		return adviceMethod;
	}
	public Object getAdviceInstance() throws Exception {
		return adviceObjectFactory.getAspectInstance();
	}
}
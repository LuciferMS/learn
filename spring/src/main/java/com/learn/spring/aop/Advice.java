package com.learn.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

public interface Advice extends MethodInterceptor{
	public Pointcut getPointcut();
}


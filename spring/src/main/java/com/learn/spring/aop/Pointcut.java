package com.learn.spring.aop;



public interface Pointcut {
	MethodMatcher getMethodMatcher();
	String getExpression();
}

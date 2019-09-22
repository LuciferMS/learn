package com.learn.spring.test.v5;

import java.lang.reflect.Method;

import com.learn.spring.aop.MethodMatcher;
import com.learn.spring.aop.aspectj.AspectJExpressionPointcut;
import com.learn.spring.service.v5.PetStoreService;
import org.junit.Assert;
import org.junit.Test;


public class PointcutTest {
	@Test
	public void testPointcut() throws Exception{
		
		String expression = "execution(* org.litespring.service.v5.*.placeOrder(..))";
		
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		pc.setExpression(expression);
		
		MethodMatcher mm = pc.getMethodMatcher();
		
		{
			Class<?> targetClass = PetStoreService.class;
			
			Method method1 = targetClass.getMethod("placeOrder");		
			Assert.assertTrue(mm.matches(method1));
			
			Method method2 = targetClass.getMethod("getAccountDao");		
			Assert.assertFalse(mm.matches(method2));
		}
		
		{
			Class<?> targetClass = com.learn.spring.service.v4.PetStoreService.class;
		
			Method method = targetClass.getMethod("getAccountDao");		
			Assert.assertFalse(mm.matches(method));
		}
		
	}
}

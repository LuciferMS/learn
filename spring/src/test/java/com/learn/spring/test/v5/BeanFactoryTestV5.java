package com.learn.spring.test.v5;

import java.util.List;

import com.learn.spring.aop.Advice;
import com.learn.spring.aop.aspectj.AspectJAfterReturningAdvice;
import com.learn.spring.aop.aspectj.AspectJAfterThrowingAdvice;
import com.learn.spring.aop.aspectj.AspectJBeforeAdvice;
import com.learn.spring.beans.factory.BeanFactory;
import com.learn.spring.tx.TransactionManager;
import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTestV5  extends AbstractV5Test{
	
	static String expectedExpression = "execution(* org.litespring.service.v5.*.placeOrder(..))";
	@Test
	public void testGetBeanByType() throws Exception{
		
		BeanFactory factory = super.getBeanFactory("petstore-v5.xml");
		
		List<Object> advices = factory.getBeansByType(Advice.class);
		
		Assert.assertEquals(3, advices.size());
		
		{
			AspectJBeforeAdvice advice = (AspectJBeforeAdvice)this.getAdvice(AspectJBeforeAdvice.class, advices);
					
			Assert.assertEquals(TransactionManager.class.getMethod("start"), advice.getAdviceMethod());
		
			Assert.assertEquals(expectedExpression,advice.getPointcut().getExpression());
			
			Assert.assertEquals(TransactionManager.class,advice.getAdviceInstance().getClass());
			
		}
		
		
		{
			AspectJAfterReturningAdvice advice = (AspectJAfterReturningAdvice)this.getAdvice(AspectJAfterReturningAdvice.class, advices);
					
			Assert.assertEquals(TransactionManager.class.getMethod("commit"), advice.getAdviceMethod());
		
			Assert.assertEquals(expectedExpression,advice.getPointcut().getExpression());
			
			Assert.assertEquals(TransactionManager.class,advice.getAdviceInstance().getClass());
			
		}
		
		{
			AspectJAfterThrowingAdvice advice = (AspectJAfterThrowingAdvice)this.getAdvice(AspectJAfterThrowingAdvice.class, advices);
					
			Assert.assertEquals(TransactionManager.class.getMethod("rollback"), advice.getAdviceMethod());
		
			Assert.assertEquals(expectedExpression,advice.getPointcut().getExpression());
			
			Assert.assertEquals(TransactionManager.class,advice.getAdviceInstance().getClass());
			
		}
		
		
	}
	
	public Object getAdvice(Class<?> type,List<Object> advices){
		for(Object o : advices){
			if(o.getClass().equals(type)){
				return o;
			}
		}
		return null;
	}
}

package com.learn.spring.test.v5;

import java.util.List;

import com.learn.spring.aop.aspectj.AspectJAfterReturningAdvice;
import com.learn.spring.aop.aspectj.AspectJBeforeAdvice;
import com.learn.spring.aop.aspectj.AspectJExpressionPointcut;
import com.learn.spring.aop.config.AspectInstanceFactory;
import com.learn.spring.aop.framework.AopConfig;
import com.learn.spring.aop.framework.AopConfigSupport;
import com.learn.spring.aop.framework.CglibProxyFactory;
import com.learn.spring.beans.factory.BeanFactory;
import com.learn.spring.service.v5.PetStoreService;
import com.learn.spring.util.MessageTracker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CglibAopProxyTest extends AbstractV5Test{
		
	private AspectJBeforeAdvice beforeAdvice = null;
	private AspectJAfterReturningAdvice afterAdvice = null;
	private AspectJExpressionPointcut pc = null;
	private BeanFactory beanFactory = null;
	private AspectInstanceFactory aspectInstanceFactory = null;
	
	@Before
	public  void setUp() throws Exception{		
		
		MessageTracker.clearMsgs();
		
		String expression = "execution(* org.litespring.service.v5.*.placeOrder(..))";
		pc = new AspectJExpressionPointcut();
		pc.setExpression(expression);
		
		beanFactory = this.getBeanFactory("petstore-v5.xml");
		aspectInstanceFactory = this.getAspectInstanceFactory("tx");
		aspectInstanceFactory.setBeanFactory(beanFactory);
		
		beforeAdvice = new AspectJBeforeAdvice(
				getAdviceMethod("start"),
				pc,
				aspectInstanceFactory);
		
		afterAdvice = new AspectJAfterReturningAdvice(
				getAdviceMethod("commit"),
				pc,
				aspectInstanceFactory);		
		
	}
	
	@Test
	public void testGetProxy(){
		
		AopConfig config = new AopConfigSupport();
		
		config.addAdvice(beforeAdvice);
		config.addAdvice(afterAdvice);
		config.setTargetObject(new PetStoreService());
		
		
		CglibProxyFactory proxyFactory = new CglibProxyFactory(config);
		
		PetStoreService proxy = (PetStoreService)proxyFactory.getProxy();
		
		proxy.placeOrder();				
		
		
		List<String> msgs = MessageTracker.getMsgs();
		Assert.assertEquals(3, msgs.size());
		Assert.assertEquals("start tx", msgs.get(0));	
		Assert.assertEquals("place order", msgs.get(1));	
		Assert.assertEquals("commit tx", msgs.get(2));	
		
		proxy.toString();
	}
	
	
}

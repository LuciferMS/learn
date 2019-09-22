package com.learn.spring.aop.config;



import com.learn.spring.beans.factory.BeanFactory;
import com.learn.spring.beans.factory.BeanFactoryAware;
import com.learn.spring.util.StringUtils;


/**
 * Implementation of {@link AspectInstanceFactory} that locates the aspect from the
 * {@link org.springframework.beans.factory.BeanFactory} using a configured bean name.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @since 2.0
 */
public class AspectInstanceFactory implements BeanFactoryAware {

	private String aspectBeanName;

	private BeanFactory beanFactory;

	public void setAspectBeanName(String aspectBeanName) {
		this.aspectBeanName = aspectBeanName;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
		if (!StringUtils.hasText(this.aspectBeanName)) {
			throw new IllegalArgumentException("'aspectBeanName' is required");
		}
	}

	public Object getAspectInstance() throws Exception {
		return this.beanFactory.getBean(this.aspectBeanName);
	}
}

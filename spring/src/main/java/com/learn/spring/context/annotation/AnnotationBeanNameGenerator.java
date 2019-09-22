package com.learn.spring.context.annotation;


import java.beans.Introspector;
import java.util.Map;
import java.util.Set;

import com.learn.spring.beans.BeanDefinition;
import com.learn.spring.beans.factory.annotation.AnnotatedBeanDefinition;
import com.learn.spring.beans.factory.support.BeanDefinitionRegistry;
import com.learn.spring.beans.factory.support.BeanNameGenerator;
import com.learn.spring.core.type.AnnotationMetadata;
import com.learn.spring.stereotype.Component;
import com.learn.spring.util.ClassUtils;
import com.learn.spring.util.StringUtils;
import com.learn.spring.core.annotation.AnnotationAttributes;

public class AnnotationBeanNameGenerator implements BeanNameGenerator {


	@Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		if (definition instanceof AnnotatedBeanDefinition) {
			String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition) definition);
			if (StringUtils.hasText(beanName)) {
				// Explicit bean name found.
				return beanName;
			}
		}
		return buildDefaultBeanName(definition, registry);
	}

	/**
	 * Derive a bean name from one of the annotations on the class.
	 * @param annotatedDef the annotation-aware bean definition
	 * @return the bean name, or {@code null} if none is found
	 */
	protected String determineBeanNameFromAnnotation(AnnotatedBeanDefinition annotatedDef) {
		AnnotationMetadata amd = annotatedDef.getMetadata();
		Set<String> types = amd.getAnnotationTypes();
		String beanName = null;
		for (String type : types) {
			AnnotationAttributes attributes = amd.getAnnotationAttributes(type);
			if(isStereotypeWithNameValue(type,attributes)){
				Object value = attributes.get("value");
				if (value instanceof String) {
					String strVal = (String) value;
					if (StringUtils.hasLength(strVal)) {						
						beanName = strVal;
					}
				}
			}			
		}
		return beanName;
	}

	protected boolean isStereotypeWithNameValue(String annotationType,Map<String, Object> attributes) {

		boolean isStereotype = annotationType.equals(Component.class.getName()); /*||
				(metaAnnotationTypes != null && metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME)) ||
				annotationType.equals("javax.annotation.ManagedBean") ||
				annotationType.equals("javax.inject.Named");*/

		return (isStereotype && attributes != null && attributes.containsKey("value"));
	}
	/**
	 * Derive a default bean name from the given bean definition.
	 * <p>The default implementation delegates to {@link #buildDefaultBeanName(BeanDefinition)}.
	 * @param definition the bean definition to build a bean name for
	 * @param registry the registry that the given bean definition is being registered with
	 * @return the default bean name (never {@code null})
	 */
	protected String buildDefaultBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		return buildDefaultBeanName(definition);
	}

	/**
	 * Derive a default bean name from the given bean definition.
	 * <p>The default implementation simply builds a decapitalized version
	 * of the short class name: e.g. "mypackage.MyJdbcDao" -> "myJdbcDao".
	 * <p>Note that inner classes will thus have names of the form
	 * "outerClassName.InnerClassName", which because of the period in the
	 * name may be an issue if you are autowiring by name.
	 * @param definition the bean definition to build a bean name for
	 * @return the default bean name (never {@code null})
	 */
	protected String buildDefaultBeanName(BeanDefinition definition) {
		String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
		return Introspector.decapitalize(shortClassName);
	}

}


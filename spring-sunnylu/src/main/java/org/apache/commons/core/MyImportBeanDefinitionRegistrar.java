package org.apache.commons.core;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * spring的扩展接口
 * 原理见《spring源码解析3》
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		//创建MyFactoryBean类的bd
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class).getBeanDefinition();
		//为这个bd指定构造方法的参数类型是org.apache.commons.bean.IndexDao，不然spring没办法对其进行实例化
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("org.apache.commons.bean.IndexDao");
		registry.registerBeanDefinition("indexDao",beanDefinition);
	}
}

package org.apache.commons.core2;

import org.apache.commons.bean.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * 在userDao实例化之前对其进行代理
 */
public class AopBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if (beanName.equalsIgnoreCase("userDao")){
			UserDao dao = (UserDao)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{UserDao.class},new AopInvocationHandler(bean));
			return dao;
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}

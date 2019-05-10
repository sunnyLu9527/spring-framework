package org.apache.commons.core;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean,InvocationHandler {

	private Class clazz;

	public MyFactoryBean(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object getObject() throws Exception {
		Class[] clazzArray = new Class[]{clazz};
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),clazzArray,this);
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (args != null && args.length > 0)
			System.out.println(args[0]);
		return null;
	}
}

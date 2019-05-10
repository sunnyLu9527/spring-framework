package org.apache.commons.core2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler {

	private Object object;

	public AopInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("这里已经被代理了：运用ImportSelector的特性仅仅需要通过@Import注入，就可以方便的启用/禁用代理，不信你把@EnableSelectorAop注解去掉试试");
		return method.invoke(object,args);
	}
}

package org.apache.commons;

import org.apache.commons.bean.IndexDao;
import org.apache.commons.bean.UserService;
import org.apache.commons.bean.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("org.apache.commons");
//		context.refresh();


//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(UserServiceImpl.class);
//		context.refresh();
//		UserServiceImpl u =  context.getBean(UserServiceImpl.class);
//		System.out.println(u.getName());


		UserService userService = (UserService) context.getBean("userService");
		System.out.println(userService.getName());
		System.out.println(userService.getProxy("模拟mybatis的MapperScan:\n原理是在spring实例化bean之前使用spring提供的扩展接口ImportBeanDefinitionRegistrar将IndexDao接口\n（这里利用了jdk动态代理生成了一个IndexDao的代理类，并且通过FactoryBean的特性代替这个代理类交给spring容器管理，方便后续实例化出来）\n注册成为一个BeanDefinition"));
		System.out.println(userService.getDescription("这是未被代理的逻辑"));
//		IndexDao dao = context.getBean(IndexDao.class);
//		IndexDao dao = (IndexDao)context.getBean("indexDao");
//		System.out.println(dao.getProxy("...."));
	}
}

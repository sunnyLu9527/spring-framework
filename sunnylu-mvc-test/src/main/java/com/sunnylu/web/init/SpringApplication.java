package com.sunnylu.web.init;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import java.io.File;

public class SpringApplication {
	public static void run()throws ServletException,LifecycleException{

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		File base = new File(System.getProperty("java.io.tmpdir"));

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9090);

		Context rootContext = tomcat.addContext("/",base.getAbsolutePath());

		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

		tomcat.addServlet(rootContext,"luban",dispatcherServlet).setLoadOnStartup(0);
		rootContext.addServletMapping("/","luban");
		tomcat.start();
		tomcat.getServer().await();

	}
}

package com.sunnylu.web.init;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class Test {

	public static void main(String[] args) {
		try {
			SpringApplication.run();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}

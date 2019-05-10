package org.apache.commons;

import org.apache.commons.bean.UserDao;
import org.apache.commons.bean.UserService;
import org.apache.commons.bean.UserServiceImpl;
import org.apache.commons.core.MyMapperScan;
import org.apache.commons.core2.EnableSelectorAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.apache.commons.bean")
@MyMapperScan
@EnableSelectorAop
public class Config {

	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}

}

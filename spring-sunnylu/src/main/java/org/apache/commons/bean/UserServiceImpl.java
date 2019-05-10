package org.apache.commons.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 这里的indexDao是通过spring的扩展接口成为一个bean的
 * @see org.apache.commons.core.MyImportBeanDefinitionRegistrar
 * @see org.apache.commons.core.MyFactoryBean
 */
public class UserServiceImpl implements UserService {

	@Autowired
	private IndexDao indexDao;
	@Autowired
	private UserDao userDao;

	@Override
	public String getName() {
		return "mike";
	}

	@Override
	public String getProxy(String msg) {
		return indexDao.getProxy(msg);
	}

	@Override
	public String getDescription(String msg) {
		return userDao.getDescription(msg);
	}
}

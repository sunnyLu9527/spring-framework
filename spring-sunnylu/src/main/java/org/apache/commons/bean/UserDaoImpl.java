package org.apache.commons.bean;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public String getDescription(String msg) {
		return msg;
	}
}

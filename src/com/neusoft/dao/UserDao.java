package com.neusoft.dao;

import java.util.List;

import com.neusoft.bean.User;

public interface UserDao {
	public void saveUser(User user);
	public List<User> getUser();
}

package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.User;

public interface UserService {
	public void saveUser(User user);
	public List<User> getUser();
}

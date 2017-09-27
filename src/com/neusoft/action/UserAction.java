package com.neusoft.action;

import org.springframework.beans.factory.annotation.Autowired;


import com.neusoft.bean.User;
import com.neusoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override 
	public String execute() throws Exception { 
		//�����û�������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//����ҵ���߼����userService�ӿ��������û�������
		userService.saveUser(user);
		return super.execute();
	}

}

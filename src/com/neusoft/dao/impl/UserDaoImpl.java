package com.neusoft.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;

public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveUser(User user) {
		//与spring结合使用优先使用getCurrentSession(),线程安全，自动刷新缓存并关闭
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
//		openSession()是线程不安全的，需要手动去刷新session，否则可能出现session没有自动关闭，消耗数据库连接资源造成程序挂掉而没有把数据提交到数据库
//		Session session = sessionFactory.openSession();
//		session.save(user);
//		session.flush();
		//session.close();
		System.out.println("调用DAO层...");
	}
	
	public List<User> getUser() {
		//与spring结合使用优先使用getCurrentSession(),线程安全，自动刷新缓存并关闭
		Session session = sessionFactory.getCurrentSession();
		String hql="from User";
		Query query  =session.createQuery(hql);
		List<User> list =  query.list();
		System.out.println("调用DAO层...");
		return list;
		
	}
	
}

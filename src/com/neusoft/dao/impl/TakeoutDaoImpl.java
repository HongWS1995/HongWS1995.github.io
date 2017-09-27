/**
 * 
 */
package com.neusoft.dao.impl;

import java.util.List;

import javax.annotation.Resources;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.neusoft.bean.TakeOut;
import com.neusoft.dao.TakeOutDao;

@Component("TakeOutDao")
public class TakeoutDaoImpl implements TakeOutDao {
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveTakeOut(TakeOut TakeOut) {
		sessionFactory.getCurrentSession().save(TakeOut);
		
	}

	
	@Override
	public void deleteTakeOut(TakeOut TakeOut) {
		sessionFactory.getCurrentSession().delete(TakeOut);
		
	}

	
	@Override
	public void updateTakeOut(TakeOut TakeOut) {
		sessionFactory.getCurrentSession().saveOrUpdate(TakeOut);
		
	}

	
	@Override
	public List<TakeOut> getTakeOut() {
		List<TakeOut> list = sessionFactory.getCurrentSession().createQuery("from TakeOut").list();
		return list;
	}

	
	@Override
	public TakeOut getTakeOut(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from TakeOut where id = "+id);
		return (TakeOut) query.uniqueResult();
	}

	
	
}

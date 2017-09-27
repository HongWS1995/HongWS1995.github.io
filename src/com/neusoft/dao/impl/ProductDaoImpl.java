/**
 * 
 */
package com.neusoft.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Product;
import com.neusoft.dao.ProductDao;


public class ProductDaoImpl implements ProductDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	
	@Override
	public void deleteProduct(Product product) {
	}

	
	@Override
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);

	}

	
	@Override
	public List<Product> getProduct() {	
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	
	@Override
	public Product getProduct(int id) {
		
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where id="+id).uniqueResult();
	}

}

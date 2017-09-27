/**
 * 
 */
package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.bean.Product;
import com.neusoft.dao.ProductDao;
import com.neusoft.service.ProductService;


public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public void save(Product product) {
		productDao.saveProduct(product);

	}

	
	@Override
	public void delete(Product product) {
		
	}

	
	@Override
	public void update(Product product) {
		productDao.updateProduct(product);

	}

	
	@Override
	public List<Product> get() {
		
		return productDao.getProduct();
	}

	
	@Override
	public Product getById(int id) {
		
		return productDao.getProduct(id);
	}

}

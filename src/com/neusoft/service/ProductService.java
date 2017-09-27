package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.Product;

public interface ProductService {
	public void save(Product product);
	public void delete(Product product);
	public void update(Product product);
	public List<Product> get();
	public Product getById(int id);
}

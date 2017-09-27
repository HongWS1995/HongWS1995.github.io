package com.neusoft.dao;

import java.util.List;

import com.neusoft.bean.Product;;

public interface ProductDao {
	public void saveProduct(Product product);
	public void deleteProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> getProduct();
	public Product getProduct(int id);

}

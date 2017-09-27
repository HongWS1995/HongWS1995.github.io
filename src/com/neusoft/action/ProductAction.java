package com.neusoft.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neusoft.bean.Product;
import com.neusoft.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;


public class ProductAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String productName;
	private int id;
	private int quantity;
	
	private ProductService productService;

	private Map<String,Integer> map;
	
	public Map<String,Integer> getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public String getAll() throws Exception {	
		List<Product> list2=productService.get();
		map = new HashMap<String,Integer>();
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			Integer value = product.getId();
			String key = product.getProductName();
			map.put(key, value);
		}
		return "getAll";
	}
	
	public String getById() throws Exception {
		Product product = new Product();
		Product p2 = productService.getById(id);
		product.setId(p2.getId());
		productName=p2.getProductName();
		quantity=p2.getQuantity();
		return "getById";
	}

	@Override 
	public String execute() throws Exception { 
		Product product = new Product();
		product.setProductName(productName);
		product.setQuantity(quantity);
		productService.save(product);
		return SUCCESS;
	}

}

package com.neusoft.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neusoft.bean.Product;
import com.neusoft.bean.TakeOut;
import com.neusoft.service.ProductService;
import com.neusoft.service.TakeOutService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class TakeOutAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//需要序列化的属性（添加getter）
	private int id;
	private int quantity;
	private String handler;
	//不需要序列化的属性
	
	private TakeOutService takeOutService;
	private ProductService productService;
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Autowired
	public void setTakeOutService(TakeOutService takeOutService) {
		this.takeOutService = takeOutService;
	}

	@Override 
	public String execute() throws Exception { 
		//得到一个持久化的的对象
		Product product =productService.getById(id);
		System.out.println("出库前："+product.getProductName()+product.getQuantity());
		//修改库存数量
		product.setQuantity(product.getQuantity()-quantity);
		System.out.println("出库后：");
		System.out.println(product.getProductName()+product.getQuantity());
		//更新库存数量
		productService.update(product);
		TakeOut takeOut =new TakeOut();
		takeOut.setProduct(product);
		takeOut.setQuantity(quantity);
		takeOut.setHandler(handler);
		takeOut.setOutDate(new Date());
		//保存出库记录到数据库
		takeOutService.save(takeOut);
		System.out.println("库存记录保存成功");
		return SUCCESS;
	}

}

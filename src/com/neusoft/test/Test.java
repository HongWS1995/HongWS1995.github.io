package com.neusoft.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.action.ProductAction;
import com.neusoft.bean.Product;
import com.neusoft.bean.TakeOut;
import com.neusoft.bean.User;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.TakeOutDao;
import com.neusoft.dao.impl.TakeoutDaoImpl;
import com.neusoft.service.ProductService;
import com.neusoft.service.UserService;


public class Test {

	public static void main(String[] args) {
		
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		 SessionFactory sf = ctx.getBean("sessionFactory",SessionFactory.class);
		 Session session =sf.openSession();
		 TakeOutDao td = ctx.getBean("TakeOutDaoImpl",TakeOutDao.class);
		 ProductDao pd = ctx.getBean("productDao",ProductDao.class);
		 UserService us = ctx.getBean("userService",UserService.class);
		 ProductService ps = ctx.getBean("productService",ProductService.class);
		 ProductAction pa = ctx.getBean("productAction", ProductAction.class);
		 
//		 User user = new User();
//		 user.setUsername("bbbb");
//		 user.setPassword("444");
//		 us.saveUser(user);
		 Product product = new Product();
		 product.setId(2);
		
		 //pd.saveProduct(product);
		 TakeOut to = new TakeOut();
		 to.setHandler("韩信");
		 to.setOutDate(new Date());
		 to.setProduct(product);
		 to.setQuantity(20);
		 td.saveTakeOut(to);
		 System.out.println("保存");
		 List<TakeOut> ls = td.getTakeOut();
		 for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
			
			TakeOut takeOut = (TakeOut) iterator.next();
			System.out.print(takeOut.getId()+"\t");
			System.out.print(takeOut.getProduct().getId()+"\t");
			System.out.println(takeOut.getOutDate());
			
		}
		 System.out.println("测试");
		
	}

}

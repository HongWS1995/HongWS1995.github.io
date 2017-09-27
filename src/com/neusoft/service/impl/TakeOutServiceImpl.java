/**
 * 
 */
package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.TakeOut;
import com.neusoft.dao.TakeOutDao;
import com.neusoft.service.TakeOutService;

@Service("TakeOutService")
public class TakeOutServiceImpl implements TakeOutService {

	private TakeOutDao takeOutDao;
	@Autowired
	public void settakeOutDao(TakeOutDao takeOutDao) {
		this.takeOutDao = takeOutDao;
	}


	@Override
	public void save(TakeOut TakeOut) {
		takeOutDao.saveTakeOut(TakeOut);

	}

	
	@Override
	public void delete(TakeOut TakeOut) {
		takeOutDao.deleteTakeOut(TakeOut);
	}

	
	@Override
	public void update(TakeOut TakeOut) {
		takeOutDao.updateTakeOut(TakeOut);

	}

	
	@Override
	public List<TakeOut> get() {
		
		return takeOutDao.getTakeOut();
	}

	
	@Override
	public TakeOut getById(int id) {
		
		return takeOutDao.getTakeOut(id);
	}

}

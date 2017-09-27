package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.TakeOut;

public interface TakeOutService {
	public void save(TakeOut TakeOut);
	public void delete(TakeOut TakeOut);
	public void update(TakeOut TakeOut);
	public List<TakeOut> get();
	public TakeOut getById(int id);
}

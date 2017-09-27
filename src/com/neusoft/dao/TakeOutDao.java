package com.neusoft.dao;

import java.util.List;

import com.neusoft.bean.TakeOut;;

public interface TakeOutDao {
	public void saveTakeOut(TakeOut TakeOut);
	public void deleteTakeOut(TakeOut TakeOut);
	public void updateTakeOut(TakeOut TakeOut);
	public List<TakeOut> getTakeOut();
	public TakeOut getTakeOut(int id);

}

package com.myapp.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DBManager { 

	@Autowired
	@Qualifier("testDbDao")
	private AbstractDBDao dao;

	public AbstractDBDao getDao() {
		return dao;
	}

	public void setDao(AbstractDBDao dao) {
		this.dao = dao;
	}

	public String createTest(DBBean bean) throws Exception {
		return dao.createTest(bean);
	}

	public void deleteTest(String id)throws Exception {
		dao.deleteTest(id);
	}

}

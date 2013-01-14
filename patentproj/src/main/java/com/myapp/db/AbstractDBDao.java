package com.myapp.db;

public interface AbstractDBDao {

	public String createTest(DBBean bean) throws Exception;
	public void deleteTest(String id) throws Exception;
	public DBBean getTestBean(String id) throws Exception;
}


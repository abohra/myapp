package com.patent.bean;

import com.patent.db.DBBean;

public class ConverterUtility {

	public static DBBean getDBBeanFromTestBean(TestBean testBean)	{
		DBBean dbBean = new DBBean();
		dbBean.setV1(testBean.getObject1());
		dbBean.setV2(testBean.getObject2());
		return dbBean;
	}

	public static TestBean getTestBeanFromDBBean(DBBean dbBean) {
		TestBean testBean = new TestBean();
		testBean.setObject1(dbBean.getV1());
		testBean.setObject2(dbBean.getV2())	;
		return testBean;
	}

}

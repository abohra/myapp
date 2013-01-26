package com.patent.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.patent.bean.ConverterUtility;
import com.patent.bean.TestBean;
import com.patent.db.AbstractDBDao;
import com.patent.db.DBBean;


@Component
@Path("/test")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
public class TestResource {

	private AbstractDBDao testDbDao;

	public AbstractDBDao getTestDbDao() {
		return testDbDao;
	}

	@Autowired
	public void setTestDbDao(AbstractDBDao testDbDao) {
		this.testDbDao = testDbDao;
	}

	@GET
	@Path("t/{id}")
	public TestBean getTestBean(@PathParam("id") String id) throws Exception {
		DBBean dbBean= testDbDao.getTestBean(id);
		if (dbBean == null) {
			System.out.println("DB bean is null !!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		System.out.println(" DB bean is not null " + dbBean.getV1() + " : " + dbBean.getV2());
		return ConverterUtility.getTestBeanFromDBBean(dbBean);

	}

	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("t/abc") 
	public String createTestBean(TestBean bean) throws Exception {
		System.out.println("Bean found has value " + bean.getObject1() + " : " + bean.getObject2());
		DBBean dbBean = ConverterUtility.getDBBeanFromTestBean(bean);
		return testDbDao.createTest(dbBean);

	}

} 
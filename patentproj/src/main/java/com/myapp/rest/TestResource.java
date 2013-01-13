package com.myapp.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.myapp.bean.TestBean;

@Component
@Path("/test")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
public class TestResource {

	@GET
	@Path("t/{id}")
	public TestBean getCurrentFeedState(@PathParam("id") String id) {
		TestBean bean = new TestBean();
		bean.setObject1("Hello");
		bean.setObject2(id);
		return bean;
	}

}

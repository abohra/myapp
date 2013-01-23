package com.patent.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.patent.bean.Customer;


@Path("/customer")
public class CustomerResource {

	@GET
	public String checkRestResource(){
		return "Hello World";
	}
	
	@POST
	@Path("/newCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer newCustomer) {
		String result = "Track saved : " + newCustomer;
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/editCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editCustomer(Customer newCustomer) {
		String result = "Track saved : " + newCustomer;
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/getCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer() {
		Customer track = new Customer();
		return track;
	}

	@GET
	@Path("/deleteCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer deleteCustomer() {
		Customer track = new Customer();
		return track;
	}
}

package com.patent.rest;

import java.util.ArrayList;
import java.util.List;

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
import com.patent.bean.UserBean;
import com.patent.bean.UserList;
import com.patent.db.AbstractUserDao;
import com.patent.db.User;

@Component
@Path("/user")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})

public class UserResource {

	private AbstractUserDao userDao;


	public AbstractUserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(AbstractUserDao userDao) {
		this.userDao = userDao;
	}

	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("create/")
	public String createUser(UserBean userBean) throws Exception {
		//	return null;
		User user = ConverterUtility.getUserFromUserBean(userBean);
		return userDao.createUser(user);

	}
	@GET
	@Path("fetch/{id}")
	public UserBean getUserBean(@PathParam("id") String id) throws Exception {
		User user= userDao.getUser(id);
		if (user == null) {
			System.out.println("DB bean is null !!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return ConverterUtility.getUserBeanFromUser(user);

	}
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("update/")
	public String updateUser(UserBean userBean)throws Exception{
		User user = ConverterUtility.getUserFromUserBean(userBean);
		return userDao.editUser(user);
	}


	@GET
	@Path("delete/{id}")
	public void deleteUser(@PathParam("id") String id) throws Exception {
		//User user = ConverterUtility.getUserFromUserBean(userBean);
		userDao.deleteUser(id);
	}

     @GET
     @Path("allUsers/")
     @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
     public UserList listOfUser() throws Exception {
    	 return new UserList(new ArrayList<User> (userDao.listOfUser()));
     }

}

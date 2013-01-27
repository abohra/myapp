package com.patent.db;

import java.util.List;

import com.patent.bean.UserBean;

public interface AbstractUserDao {
	public String createUser(User newUser) throws Exception;
	public void deleteUser(String id) throws Exception;
	public User getUser(String id) throws Exception;
	public String editUser(User updatedUser) throws Exception;
	public List<User> listOfUser() throws Exception;

}
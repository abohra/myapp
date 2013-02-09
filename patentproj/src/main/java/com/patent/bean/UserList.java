package com.patent.bean;

import java.util.List;
import com.patent.db.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userList")
public class UserList {
	public List<User> listOfUsers;

	public UserList() {

	}

	public UserList(List<User> users) {
		this.listOfUsers = users;
	}

	@XmlElement
	public List<User> getUsers() {
		return listOfUsers;
	}

	public void setUsers(List<User> users) {
		this.listOfUsers = users;
	}

}

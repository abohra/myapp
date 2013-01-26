package com.patent.db;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "testdb")

public class DBBean implements Serializable {
	private String id;
	private String flag;
	private int value;

	public DBBean() { 

	}

	public DBBean(String id, String flag, int count){
		this.id = id;
		this.flag = flag;
		this.value =count;
	}

	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Column
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}


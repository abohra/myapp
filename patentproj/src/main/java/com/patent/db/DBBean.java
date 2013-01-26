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
	private String v1;
	private String v2;


	public DBBean() { 

	}
	public DBBean(String val1,String val2) {
		this.v1= val1;
		this.v2=val2;
	}

	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Column
	public String getV1() {
		return v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}

	@Column
	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}

}


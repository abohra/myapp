//Testing Commits
package com.myapp.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="test-bean")
public class TestBean {
	
	private String object1;
	private String object2;
	
	public String getObject1() {
		return object1;
	}
	public void setObject1(String object1) {
		this.object1 = object1;
	}
	public String getObject2() {
		return object2;
	}
	public void setObject2(String object2) {
		this.object2 = object2;
	}

}

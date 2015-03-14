package com.github.drunk2013.redis.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8304078756504876641L;
	private String name;
	private Date createDate;
	private int age;

	public String getName() {
		return name;
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.createDate = new Date();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", createDate=" + createDate + ", age="
				+ age + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

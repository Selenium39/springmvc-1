package com.wantao.bean;
/*
 *@author:wantao
 *@time:Jul 20, 2018 3:17:30 PM
 *@description:
 */
public class User {
	
	public User() {
		super();
	}
	private String name;
	private Integer age;
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}

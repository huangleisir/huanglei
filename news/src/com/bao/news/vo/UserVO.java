package com.bao.news.vo;

import java.util.Date;


public class UserVO {
	private String id;
	private String userName;
	private String password;
	private String sex;
	private int age;
	private String email;
	private String flag;
	private Date createTime;

	public UserVO(){}
	
	
	public UserVO( String userName, String password, String sex,
			int age, String email, String flag, Date createTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.flag = flag;
		this.createTime = createTime;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

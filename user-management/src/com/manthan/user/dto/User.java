package com.manthan.user.dto;

public class User {
	protected int id;
	protected String name;
	protected int age;
	protected String password;
	protected String email;
	protected String phoneno;

	public User(int id, String name, String email, String phoneno) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
	}

	public User(int id, String name, int age, String email, String phoneno) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phoneno = phoneno;
	}

	public User(int id, String name, int age, String password, String email, String phoneno) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}

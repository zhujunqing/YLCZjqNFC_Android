package com.ylczjqnfc.pojo;

public class Person {

	private int id;
	private String username;
	private int age;
	private String address;

	public Person(){
		
	}
	
	public Person(int id, String username, int age, String address) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

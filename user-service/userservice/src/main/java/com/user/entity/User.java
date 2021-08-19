package com.user.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Long id;
	private String name;
	private String number;
	
	List<Contact> contacts =new ArrayList<>();
	
	

	public User() {
		super();
	}

	public User(Long id, String name, String number, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.contacts = contacts;
	}

	public User(Long id, String name, String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}

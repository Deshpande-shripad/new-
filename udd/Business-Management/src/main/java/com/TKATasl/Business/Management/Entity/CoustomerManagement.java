package com.TKATasl.Business.Management.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CoustomerManagement {

	
	@Id
	int id;
	String name;
	String email;
	String phoneNumber;
	public CoustomerManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoustomerManagement(int id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "CoustomerManagement [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	
	
}

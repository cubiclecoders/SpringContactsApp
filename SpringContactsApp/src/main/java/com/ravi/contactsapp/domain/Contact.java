package com.ravi.contactsapp.domain;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Contact {

	private Integer contactId;
	
	@NotBlank
	private String contactName;
	
	@NotBlank
	@Pattern(regexp="[^a-zA-z]+")
	private String mobile;
	
	@Email
	@NotBlank
	private String email;
	
	private String address;
	private Integer userId;
	private Date creationDate;

	public Contact(String contactName, String mobile, String email, String address, Integer userId) {
		this.contactName = contactName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.userId = userId;
		this.creationDate = new Date();
	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String toString() {
		
		return contactId+", "+contactName+", "+mobile+", "+email+", "+address+", "+userId+", "+creationDate;
	}

}

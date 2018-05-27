package com.ravi.contactsapp.domain;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private Integer userId;
	
	@NotBlank
	@Pattern(regexp="[^0-9]+")
	private String userName;
	
	private Date dob;
	
    @NotEmpty
	private String gender;
	
    @NotBlank
    @Size(min=5,max=20)
	private String address;
    
    @Email
    @NotBlank
	private String email;
    
    @NotBlank
    @Pattern(regexp="[^a-zA-Z]+")
	private String mobile;
    
    @NotBlank
    @Size(min=5,max=8)
	private String password;
    
	private String role;
	private String active_yn;
	private Date lastLogin;
	
	public User() {}

	public User(String userName, Date dob, String gender, String address, String email, String mobile, String password,
			String role, String active_yn) {

		this.userName = userName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.active_yn = active_yn;
		this.lastLogin = new Date();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return new Date();
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getActive_yn() {
		return active_yn;
	}

	public void setActive_yn(String active_yn) {
		this.active_yn = active_yn;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public String toString() {
	return userId+","+userName;
	}

}

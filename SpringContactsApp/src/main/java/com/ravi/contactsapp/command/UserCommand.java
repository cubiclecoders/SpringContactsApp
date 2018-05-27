package com.ravi.contactsapp.command;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ravi.contactsapp.domain.User;

public class UserCommand {

	@Valid
	User user;
	
	@NotBlank
    @Size(min=5,max=8)
	private String confirmPassword;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}

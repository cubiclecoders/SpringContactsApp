package com.ravi.contactsapp.service;

import java.util.List;

import com.ravi.contactsapp.domain.User;
import com.ravi.contactsapp.exception.UserBlockedException;

public interface UserService {
	
	public static final char LOGIN_STATUS_ACTIVE='y';
	public static final char LOGIN_STATUS_BLOCK='n';
	
	public static String ROLE_USER="user";
	public static String ROLE_ADMIN="admin";
	
	public void register(User user);
	
	/* Method handle login operation(authentication) using given credentials. 
	 * For SUCCESS, returns USER
	 * For Fail, returns null
	 * For Blocked User account, throws UserBlockedException
	 * */
	public User logIn(String email, String password) throws UserBlockedException;
	public void logOut();
	
	//Method will generate the list of all Users
	public List<User> displayAllUsers();
	
	//Method is used for blocking a user or activating the user
	public void blockOrActivateUsers(Integer[] userIds, char login_status);
	
	
	//Method will delete/clean users from database and returns userIds of deleted users
	public Integer[] deleteUsers(Integer[] usersId); 
	
	public List<User> searchUsers(String freeText);

}

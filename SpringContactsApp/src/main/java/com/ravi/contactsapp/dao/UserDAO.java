package com.ravi.contactsapp.dao;

import java.util.List;

import com.ravi.contactsapp.domain.User;

public interface UserDAO {
	public Integer insertUser(User user); // returns id of newly created User
	public void updateUser(Integer userId, User user);
	public void deleteUser(Integer userId);
	public void deleteUser(User user);
    public List<User> findAll();
    public User findById(Integer userId);
    public User findByProperty(String propertyName, Object propertyValue);
    public Integer findNewUserId();

}

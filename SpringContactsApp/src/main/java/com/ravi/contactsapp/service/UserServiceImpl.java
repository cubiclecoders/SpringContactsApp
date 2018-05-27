package com.ravi.contactsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ravi.contactsapp.dao.BaseDAO;
import com.ravi.contactsapp.dao.UserDAO;
import com.ravi.contactsapp.domain.User;
import com.ravi.contactsapp.exception.UserBlockedException;
import com.ravi.contactsapp.rowmapper.UserRowMapper;
import com.ravi.contactsapp.util.StringUtil;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;

	public void register(User user) {

		if (user != null)
			userDAO.insertUser(user);

	}

	public User logIn(String email, String password) throws UserBlockedException {

		String sql = "select * from users where email=? and password=?";

		try {
			User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), new Object[] { email, password });

			if (user.getActive_yn().charAt(0) == LOGIN_STATUS_BLOCK) {
				throw new UserBlockedException("Your account has been blocked. Contact to admin.");
			} else {
				return user;
			}

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public void logOut() {
		// TODO Auto-generated method stub

	}

	public List<User> displayAllUsers() {
		String sql = "select * from users";

		return getJdbcTemplate().query(sql, new UserRowMapper());

	}

	public List<User> searchUsers(String freeText) {

		String sql = "select * from users where username||email like '%" + freeText + "%'";

		return getJdbcTemplate().query(sql, new UserRowMapper());

	}

	@Override
	public void blockOrActivateUsers(Integer[] userIds, char login_status) {

		String sql = "update users set active_yn='"+login_status+"' where userid in (" + StringUtil.CommaSeparatedUserIds(userIds) + ")";

		
			if (login_status == LOGIN_STATUS_ACTIVE)
				getJdbcTemplate().update(sql);
			else if (login_status == LOGIN_STATUS_BLOCK)
				getJdbcTemplate().update(sql);
		
	}


	@Override
	public Integer[] deleteUsers(Integer[] usersId) {
		Integer[] deletedUsersId = new Integer[usersId.length];

		for (int i = 0; i < usersId.length; i++) {
			userDAO.deleteUser(usersId[i]);
			deletedUsersId[i] = usersId[i];
		}

		return deletedUsersId;

	}

}
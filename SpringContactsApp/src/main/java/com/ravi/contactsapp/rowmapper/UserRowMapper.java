package com.ravi.contactsapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ravi.contactsapp.domain.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
        
		user.setUserId(rs.getInt("USERID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setDob(rs.getDate("DOB"));
		user.setAddress(rs.getString("ADDRESS"));
		user.setEmail(rs.getString("EMAIL"));
		user.setGender(rs.getString("GENDER"));
		user.setMobile(rs.getString("MOBILE"));
		user.setRole(rs.getString("ROLE"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setLastLogin(rs.getDate("LASTLOGIN"));
		user.setActive_yn(rs.getString("ACTIVE_YN"));
		
		return user;
	}

}

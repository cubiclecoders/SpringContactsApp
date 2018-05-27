package com.ravi.contactsapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.env.PropertySource.StubPropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ravi.contactsapp.domain.User;
import com.ravi.contactsapp.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public Integer insertUser(User user) {

		String sql = "insert into users(USERID,USERNAME,GENDER,ADDRESS,EMAIL,MOBILE,PASSWORD,ROLE,ACTIVE_YN,"
				+ "LASTLOGIN,DOB) values(:USERID,:USERNAME,:GENDER,:ADDRESS,:EMAIL,:MOBILE,:PASSWORD,:ROLE,:ACTIVE_YN,:LASTLOGIN,:DOB)";

		Map m = new HashMap();

		Integer newUserId = findNewUserId();

		m.put("USERID", newUserId);
		m.put("USERNAME", user.getUserName());
		m.put("GENDER", user.getGender());
		m.put("ADDRESS", user.getAddress());
		m.put("EMAIL", user.getEmail());
		m.put("MOBILE", user.getMobile());
		m.put("PASSWORD", user.getPassword());
		m.put("ROLE", user.getRole());
		m.put("ACTIVE_YN", user.getActive_yn());
		m.put("LASTLOGIN", user.getLastLogin());
		m.put("DOB", user.getDob());

		SqlParameterSource ps = new MapSqlParameterSource(m);

		
			super.getNamedParameterJdbcTemplate().update(sql, ps);

			user.setUserId(newUserId);
			
		
		return user.getUserId();
		
	}

	public void updateUser(Integer userId, User user) {

		String sql = "update users set " + "USERNAME=:USERNAME, " + "GENDER=:GENDER, " + "ADDRESS=:ADDRESS, "
				+ "EMAIL=:EMAIL, " + "MOBILE=:MOBILE, " + "PASSWORD=:PASSWORD, " + "ROLE=:ROLE, "
				+ "ACTIVE_YN=:ACTIVE_YN, " + "LASTLOGIN=:LASTLOGIN, " + "DOB=:DOB where userid=:USERID";

		Map map = new HashMap();

		map.put("USERNAME", user.getUserName());
		map.put("GENDER", user.getGender());
		map.put("ADDRESS", user.getAddress());
		map.put("EMAIL", user.getEmail());
		map.put("MOBILE", user.getMobile());
		map.put("PASSWORD", user.getPassword());
		map.put("ROLE", user.getRole());
		map.put("ACTIVE_YN", user.getActive_yn());
		map.put("LASTLOGIN", user.getLastLogin());
		map.put("DOB", user.getDob());
		map.put("USERID", userId);

		SqlParameterSource ps = new MapSqlParameterSource(map);

		try {
			super.getNamedParameterJdbcTemplate().update(sql, ps);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Records updated successfully.");

	}

	public void deleteUser(Integer userId) {

		String deleteSql = "delete from users where userid=" + userId;

		super.getJdbcTemplate().update(deleteSql);

		System.out.println("User deleted successfully.");

	}

	public void deleteUser(User user) {
		String deleteSql = "delete from users where userid=:USERID or USERNAME=:USERNAME or GENDER=:GENDER "
				+ "or ADDRESS=:ADDRESS or EMAIL=:EMAIL or MOBILE=:MOBILE or PASSWORD=:PASSWORD or ROLE=:ROLE "
				+ "or ACTIVE_YN=:ACTIVE_YN or LASTLOGIN=:LASTLOGIN or DOB=:DOB";

		Map map = new HashMap();

		map.put("USERID", user.getUserId());
		map.put("USERNAME", user.getUserName());
		map.put("GENDER", user.getGender());
		map.put("ADDRESS", user.getAddress());
		map.put("EMAIL", user.getEmail());
		map.put("MOBILE", user.getMobile());
		map.put("PASSWORD", user.getPassword());
		map.put("ROLE", user.getRole());
		map.put("ACTIVE_YN", user.getActive_yn());
		map.put("LASTLOGIN", user.getLastLogin());
		map.put("DOB", user.getDob());

		SqlParameterSource ps = new MapSqlParameterSource(map);

		try {
			super.getNamedParameterJdbcTemplate().update(deleteSql, ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("User deleted successfully.");

	}

	public List<User> findAll() {
		String sql = "select * from users order by userid";

		return super.getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public User findById(Integer userId) {
		String sql = "select * from users where userid=? order by userid";

		User user = super.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);

		return user;
	}

	public Integer findNewUserId() {

		Integer newUserId = super.getJdbcTemplate().queryForObject("select nvl(max(userid),0)+1 newuserid from users order by userid",
				Integer.class);

		return newUserId;

	}

	public User findByProperty(String propertyName, Object propertyValue) {
		String sql = "select * from users where " + propertyName + "=? order by userid";

		User user =super.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), propertyValue);

		return user;
	}

}

package com.ravi.contactsapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ravi.contactsapp.domain.Contact;
import com.ravi.contactsapp.domain.User;
import com.ravi.contactsapp.rowmapper.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	public Integer insertContact(Contact contact) {
		String sql = "insert into contacts(CONTACTID,CONTACTNAME,MOBILE,EMAIL,ADDRESS,USERID,CREATION_DATE) "
				+ "values(:CONTACTID,:CONTACTNAME,:MOBILE,:EMAIL,:ADDRESS,:USERID,:CREATION_DATE)";

		Integer newContactId = generateContactId();

		Map mapContact = new HashMap();
		mapContact.put("CONTACTID", newContactId);
		mapContact.put("CONTACTNAME", contact.getContactName());
		mapContact.put("MOBILE", contact.getMobile());
		mapContact.put("EMAIL", contact.getEmail());
		mapContact.put("ADDRESS", contact.getAddress());
		mapContact.put("USERID", contact.getUserId());
		mapContact.put("CREATION_DATE", contact.getCreationDate());

		SqlParameterSource ps = new MapSqlParameterSource(mapContact);

		try {
			super.getNamedParameterJdbcTemplate().update(sql, ps);
		} catch (Exception e) {
			e.printStackTrace();
		}

		contact.setContactId(newContactId);

		System.out.println("Contact added successfully");
		return contact.getContactId();
	}

	public void updateContact(Integer contactId, Contact contact) {

		String sql = "update contacts set contactname=:contactname,mobile=:mobile,email=:email,address=:address where contactid="
				+ contactId;

		Map ps = new HashMap();
		ps.put("contactname", contact.getContactName());
		ps.put("mobile", contact.getMobile());
		ps.put("email", contact.getEmail());
		ps.put("address", contact.getAddress());

		SqlParameterSource sps = new MapSqlParameterSource(ps);
        
		try {
			super.getNamedParameterJdbcTemplate().update(sql, sps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void deleteContact(Integer contactId) {

		String sql = "delete from contacts where contactid=" + contactId;

		getJdbcTemplate().update(sql);

	}

	public void deleteContact(Contact contact) {

	}

	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact findById(Integer contactId) {
		String sql = "select * from contacts where contactid=" + contactId;

		return getJdbcTemplate().queryForObject(sql, new ContactRowMapper());
	}

	public List<Contact> findByProperty(String propertyName, Object propertyType) {
		String sql = "select * from contacts where " + propertyName + "=" + propertyType + " order by contactid";

		List<Contact> listContacts = null;
		try {
			listContacts = getJdbcTemplate().query(sql, new ContactRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listContacts;
	}

	public List<Contact> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer generateContactId() {
		String sql = "select nvl(max(contactid),0)+1 from contacts";
		return super.getJdbcTemplate().queryForObject(sql, Integer.class);

	}

}

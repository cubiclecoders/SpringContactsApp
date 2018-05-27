package com.ravi.contactsapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ravi.contactsapp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {


	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();

		contact.setContactId(rs.getInt("CONTACTID"));
		contact.setContactName(rs.getString("CONTACTNAME"));
		contact.setMobile(rs.getString("MOBILE"));
		contact.setEmail(rs.getString("EMAIL"));
		contact.setAddress(rs.getString("ADDRESS"));
		contact.setUserId(rs.getInt("USERID"));
		contact.setCreationDate(rs.getDate("CREATION_DATE"));

		return contact;

	}
}

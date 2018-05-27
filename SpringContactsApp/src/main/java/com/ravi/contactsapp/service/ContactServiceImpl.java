package com.ravi.contactsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.contactsapp.dao.BaseDAO;
import com.ravi.contactsapp.dao.ContactDAO;
import com.ravi.contactsapp.domain.Contact;
import com.ravi.contactsapp.rowmapper.ContactRowMapper;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public void addContact(Contact contact) {

		if (contact != null)
			contactDAO.insertContact(contact);

	}

	public void updateContact(Integer contactId, Contact contact) {
		if (contact != null)
			contactDAO.updateContact(contactId, contact);

	}

	public Contact findById(Integer contactId) {
		return contactDAO.findById(contactId);
	}

	public List<Contact> getAllContacts() {

		return contactDAO.findAll();
	}

	public void deleteContact(Integer contactId) {

		if (contactId != null)
			contactDAO.deleteContact(contactId);

	}

	public void deleteBulkContact(Integer[] contacts) {
		for (Integer contactId : contacts)
			contactDAO.deleteContact(contactId);

	}

	public List<Contact> findUserContacts(Integer userId) {

		return contactDAO.findByProperty("userid", userId);
	}

	public List<Contact> searchContact(Integer userId, String searchText) {

		String sql = "select * from contacts where contactname||mobile||email||address like \'%"+searchText+"%\' and userid=? order by contactid";

		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper(), new Object[]{userId});

		return contacts;
	}

	public List<Contact> searchContactByField(Integer userId, String fieldName, String fieldValue) {

		String sql = "select * from contacts where " + fieldName + "=" + fieldValue
				+ " and userid=? order by contactid";

		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper(), userId);

		return contacts;
	}

}

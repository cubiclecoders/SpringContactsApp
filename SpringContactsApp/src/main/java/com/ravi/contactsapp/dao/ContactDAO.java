package com.ravi.contactsapp.dao;

import java.util.List;

import com.ravi.contactsapp.domain.Contact;
import com.ravi.contactsapp.domain.User;

public interface ContactDAO {
	
	public Integer insertContact(Contact contact); // returns id of newly created Contact
	public void updateContact(Integer contactId, Contact contact);
	public void deleteContact(Integer contactId);
	public void deleteContact(Contact contact);
    public List<Contact> findAll();
    public Contact findById(Integer contactId);
    public List<Contact> findByProperty(String propertyName, Object propertyType);
    public List<Contact> findByUser(User user);
    public Integer generateContactId();

}

package com.ravi.contactsapp.service;

import java.util.List;

import com.ravi.contactsapp.domain.Contact;

/*Interface defines all the business operations for Contact entity
 * 
 * @author Ravindra
 * */

public interface ContactService {

	public void addContact(Contact contact);

	public void updateContact(Integer contactId, Contact contact);

	public List<Contact> getAllContacts();

	public void deleteContact(Integer contactId);

	public void deleteBulkContact(Integer[] contacts);

	public List<Contact> findUserContacts(Integer userId);
	/*
	 * This method returns all the contacts of user who is logged in
	 * 
	 * @param userId
	 * 
	 * @return List of Contacts
	 */

	public List<Contact> searchContact(Integer userId, String searchText);
	/*
	 * This method will apply free text search on all the contacts of user who is
	 * logged in with userId
	 * 
	 * 
	 * @param userId
	 * 
	 * @param searchText
	 * 
	 * @return List of contacts
	 * 
	 * 
	 */

	public List<Contact> searchContactByField(Integer userId, String fieldName, String fieldValue);
	/*
	 * This method will search the contact where property fieldName=fieldValue for
	 * the user logged in with userId
	 * 
	 * @param userId
	 * @param fieldName
	 * @param fieldValue
	 * 
	 * @return List of Contacts
	 */
	
	public Contact findById(Integer contactId);

}

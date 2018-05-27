package com.ravi.contactsapp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ravi.contactsapp.domain.Contact;
import com.ravi.contactsapp.service.ContactService;
import com.ravi.contactsapp.util.StringUtil;

public class TestClass {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("contactsapp-servlet_test.xml");

		//ContactService contactService = (ContactService) ctx.getBean("contactService");

		//List<Contact> listContacts = contactService.searchContact(9, "lodhi");
Integer[] nameInt= {5,6,3,9,9,10};
System.out.println(nameInt);
		
		//System.out.println(listContacts);
		// List<Contact> listContact = contactService.searchContactByField(9,
		// "contactId", String.valueOf(8));

		// System.out.println(listContact.get(0));

		// String msg=ctx.getMessage("NotBlank.user.userName", new Object[]
		// {"UserName"}, Locale.US);

		// System.out.println(msg);

		/*
		 * UserService userService = (UserService)ctx.getBean("userService");
		 * 
		 * 
		 * User user = new User("Ravindra1", new Date(), "Male1",
		 * "Temp Address1","temp@gmail.com", "8799736739", "12346", "user1", "y");
		 * 
		 * try { userService.register(user); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		/*
		 * ContactDAO contactDAO = (ContactDAO) ctx.getBean("contactDAO");
		 * 
		 * Contact contact = new Contact("Babita", "9028281062",
		 * "lodhi.ravindra@gmail.com", "C-303", 1);
		 * 
		 * System.out.println(contactDAO.insertContact(contact));
		 */

		// DataSource ds = (DataSource) ctx.getBean("dataSource");
		// UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
		// User user=userDAO.findByProperty("gender", "Male");

		// User user=userDAO.findById(1);
		// System.out.println(user.getLastLogin());
		/*
		 * //User user=userDAO.findById(1);
		 * 
		 * //System.out.println(user.getUserName());
		 * 
		 * User user = new User("Ravindra1", new Date(), "Male1", "Temp Address1",
		 * "ravi.mits09@gmail.com", "8799736739", "12346", "user1", "y");
		 * 
		 * //user.setUserId(5);
		 * 
		 * // userDAO.deleteUser(1);
		 * 
		 * userDAO.insertUser(user);
		 */

	}

}

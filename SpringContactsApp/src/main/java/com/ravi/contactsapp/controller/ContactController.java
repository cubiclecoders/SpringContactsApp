package com.ravi.contactsapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravi.contactsapp.domain.Contact;
import com.ravi.contactsapp.service.ContactService;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/createContact")
	public String addContactForm(Model model,HttpSession session) {
		Contact contact = new Contact();
		session.setAttribute("contactId",null);
		model.addAttribute("contactCommand", contact);
		return "addContact";

	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveOrUpdateContact(@Valid @ModelAttribute("contactCommand") Contact contact, BindingResult result,
			HttpSession session, Model model) {

		if (result.hasErrors()) {
			return "addContact";
		}

		Integer sessionContactId = (Integer) session.getAttribute("contactId");

		if (sessionContactId != null) {

			contactService.updateContact(sessionContactId, contact);
			return "redirect:/contact/clist?act=upd";

		} else {
			contact.setUserId((Integer) session.getAttribute("userId"));
			contact.setCreationDate(new Date());

			try {

				contactService.addContact(contact);
				return "redirect:/contact/createContact?act=sv";
			} catch (DataIntegrityViolationException e) {
				model.addAttribute("err", e.getMessage());
				e.printStackTrace();
				return "addContact";
			}
		}

	}

	@RequestMapping(value = "/clist")
	public String contactList(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");

		List<Contact> listContacts = null;
		try {

			listContacts = contactService.findUserContacts(userId);

		} catch (Exception e) {

			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("listContacts", listContacts);
		model.addAttribute("userid", session.getAttribute("userId"));

		return "clist";

	}

	@RequestMapping(value="/searchText")
	public String searchFreeText(@RequestParam("searchString") String searchString,Model model,HttpSession session) {
		
		List<Contact> listContacts=null;
		
		try {
			listContacts=contactService.searchContact((Integer)session.getAttribute("userId"), searchString);

		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
		}
				   
		    model.addAttribute("listContacts", listContacts);
			model.addAttribute("userid", session.getAttribute("userId"));
			
			return "clist";
		 
	}

	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("contactId") Integer contactId, Model model) {

		try {
			contactService.deleteContact(contactId);
			model.addAttribute("contactId", contactId);
			return "redirect:/contact/clist?act=d_s"; // act=d_s delete success
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
			return "redirect:/contact/clist?act=exp";
		}

	}

	@RequestMapping(value = "/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, HttpSession session, Model model) {

		session.setAttribute("contactId", contactId);

		Contact contact = null;

		try {
			contact = contactService.findById(contactId);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return "clist";
		}

		model.addAttribute("contactCommand", contact);

		return "addContact";

		// return null;

	}

	
	@RequestMapping(value = "/bulk_contactDelete")
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds, HttpSession session, Model model) {

	  try {
			contactService.deleteBulkContact(contactIds);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			
		}

	     return "redirect:/contact/clist?act=bd_s";

		// return null;

	}
}

package com.Smart.controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Smart.Repository.ContactRepository;
import com.Smart.Repository.UserRepository;
import com.Smart.entity.Contact;
import com.Smart.service.ContactService;

@Controller
public class ContactController {

@Autowired	
private ContactRepository contactRepository;	
	

	@Autowired
	private ContactService contactService;
	
	
	@PostMapping("/processContact")
	public String addContact(@ModelAttribute Contact contact,Model model)
	{
		contactService.addContact(contact);
		model.addAttribute(contact);
		
		return "processContact";
		
		
	}
	
	@GetMapping("/addContact")
	public String AddContactForm(Model model)
	{
		model.addAttribute("title","Add Contact");
		model.addAttribute("contact",new Contact());
		return "addContact";
	}
	
	
	@GetMapping("/viewContact")
	public String viewContact(Model model) 
	{
		model.addAttribute("title","Your Contacts List");
		List<Contact>  list =  contactService.displayAllContact();
		model.addAttribute("contact", list);
		System.out.println(list);
		return "viewContact";
	}
	
	
	@GetMapping("/myProfile")
	public String myProfile(Model model) 
	{
		model.addAttribute("title","My Profile");
		return "myProfile";
	}
	
	
	
	
	

}

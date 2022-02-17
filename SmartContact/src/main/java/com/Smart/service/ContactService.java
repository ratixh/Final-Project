package com.Smart.service;

import java.util.List;

import com.Smart.entity.Contact;

public interface ContactService {
	
	
	public  void addContact(Contact contact);
	
	public List<Contact> displayAllContact();
	
	public Contact findByContactid(int cid);
	
	
	}

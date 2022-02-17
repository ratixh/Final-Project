package com.Smart.serviceimplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Smart.Repository.ContactRepository;
import com.Smart.entity.Contact;
import com.Smart.service.ContactService;


@Service
public class ContactServiceImplementation implements ContactService
{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void addContact(Contact contact) 
	{
		contactRepository.save(contact);
	}
	
	
	public List<Contact> displayAllContactList() 
	{
		return   contactRepository.findAll();
		
	}
	
	public Contact findByContactId(int id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id).get();
	}


	@Override
	public List<Contact> displayAllContact() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Contact findByContactid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}

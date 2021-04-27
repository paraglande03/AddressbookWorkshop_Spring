package com.lande.WorkshopAddressBook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.dto.ContactDTO;

import com.lande.WorkshopAddressBook.model.ContactData;
import com.lande.WorkshopAddressBook.repository.ContactRepository;

@Service
public class ContactService implements ContactServiceInterface{

	@Autowired
	private ContactRepository repository;

	
	public List<ContactData> getAllContacts(){
		return repository.findAll();
	}

	@Override
	public ContactData getContactById(int Id) {
		return repository.findById(Id).orElseThrow();		
	}
	
	@Override
	public ContactData createContact(ContactDTO dto) {
		ContactData contactData= new ContactData( dto);
		return repository.save(contactData);
	}

	@Override
	public ContactData updatedataById(int Id, ContactDTO dto) {
		ContactData contactData = this.getContactById(Id);
	
		contactData.setFName(dto.fName);
		contactData.setLName(dto.lName);
		contactData.setEmail(dto.email);
		contactData.setPhoneNumber(dto.phoneNumber);
		return repository.save(contactData);
	}
	
	@Override
	public void deleteDataById(int Id) {
		ContactData contactData = this.getContactById(Id);
		repository.delete(contactData);
		
	}

}

package com.lande.WorkshopAddressBook.service;

import java.util.List;
import java.util.UUID;

import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.model.Contact;

public interface ContactServiceInterface {

	public List<Contact> getAllContacts();
	
	public Contact getContactById(UUID Id);
	
	public Contact createContact(ContactDTO dto);
	
	public Contact updatedataById(UUID Id,ContactDTO dto);
	
	public void deleteDataById(UUID Id);
	
	public List<Contact> sortContact();
	
//	public Contact getcontactThroughaddress(id);
}

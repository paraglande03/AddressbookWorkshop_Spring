package com.lande.WorkshopAddressBook.service;

import java.util.List;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.model.Address;
import com.lande.WorkshopAddressBook.model.Contact;

public interface ContactServiceInterface {

	public List<Contact> getAllContacts();
	
	public Contact getContactById(int Id);
	
	public Contact createContact(ContactDTO dto);
	
	public Contact updatedataById(int Id,ContactDTO dto);
	
	public void deleteDataById(int Id);
	
	public List<Contact> sortContact();
}

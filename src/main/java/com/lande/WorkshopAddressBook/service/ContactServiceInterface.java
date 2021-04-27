package com.lande.WorkshopAddressBook.service;

import java.util.List;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.model.AddressData;
import com.lande.WorkshopAddressBook.model.ContactData;

public interface ContactServiceInterface {

	public List<ContactData> getAllContacts();
	
	public ContactData getContactById(int Id);
	
	public ContactData createContact(ContactDTO dto);
}

package com.lande.WorkshopAddressBook.service;

import java.util.List;

import com.lande.WorkshopAddressBook.model.ContactData;

public interface ContactServiceInterface {

	public List<ContactData> getAllContacts();
	
	public ContactData getContactById(int Id);
}

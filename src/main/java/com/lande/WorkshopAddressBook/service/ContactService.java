package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import com.lande.WorkshopAddressBook.model.AddressData;
import com.lande.WorkshopAddressBook.model.ContactData;

public class ContactService implements ContactServiceInterface{

	List<ContactData> list = new ArrayList<>();
	
	public List<ContactData> getAllContacts(){
		return list;
	}

}

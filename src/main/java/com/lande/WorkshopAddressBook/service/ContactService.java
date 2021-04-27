package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.model.ContactData;

@Service
public class ContactService implements ContactServiceInterface{

	List<ContactData> list = new ArrayList<>();
	
	public List<ContactData> getAllContacts(){
		return list;
	}

	@Override
	public ContactData getContactById(int Id) {
		return list.stream().filter(addData-> addData.getId()==Id).findFirst().orElseThrow();
		
	}

}

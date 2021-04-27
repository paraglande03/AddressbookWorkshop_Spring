package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.model.AddressData;
import com.lande.WorkshopAddressBook.model.ContactData;
import com.lande.WorkshopAddressBook.repository.ContactRepository;

@Service
public class ContactService implements ContactServiceInterface{

	@Autowired
	private ContactRepository repository;
//	List<ContactData> list = new ArrayList<>();
	
	public List<ContactData> getAllContacts(){
		return list;
	}

	@Override
	public ContactData getContactById(int Id) {
		return list.stream().filter(addData-> addData.getId()==Id).findFirst().orElseThrow();
		
	}
	
	@Override
	public ContactData createContact(ContactDTO dto) {
		ContactData contactData= new ContactData( dto);
		list.add(contactData);
		return contactData;
	}

	@Override
	public ContactData updatedataById(int Id, ContactDTO dto) {
		ContactData contactData = this.getContactById(Id);
	
		contactData.setFName(dto.fName);
		contactData.setLName(dto.lName);
		contactData.setEmail(dto.email);
		contactData.setPhoneNumber(dto.phoneNumber);
		list.set(Id-1, contactData);
		return contactData;
	}
	
	@Override
	public void deleteDataById(int Id) {
		list.remove(Id-1);
		
	}

}

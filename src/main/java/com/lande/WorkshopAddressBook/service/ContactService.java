package com.lande.WorkshopAddressBook.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.exceptions.AddressBookException;
import com.lande.WorkshopAddressBook.model.Address;
import com.lande.WorkshopAddressBook.model.Contact;
import com.lande.WorkshopAddressBook.repository.AddressRepository;
import com.lande.WorkshopAddressBook.repository.ContactRepository;

@Service
public class ContactService implements ContactServiceInterface{

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository repository;

	
	public List<Contact> getAllContacts(){
		return repository.findAll();
	}

	@Override
	public Contact getContactById(UUID Id) {
		return repository.findById(Id).orElseThrow(()-> new AddressBookException("details not found!"))	;	
	}
	
	@Override
	public Contact createContact(ContactDTO dto) {
		Contact contact= new Contact( dto);
		
		
		
//		Address address = addressRepository.findById(UUID.fromString(dto.addressID)).orElseThrow(()-> new AddressBookException("details not found!"));
////		contact.setAddress(address);
		return repository.save(contact);
	}

	@Override
	public Contact updatedataById(UUID Id, ContactDTO dto) {
		Contact contact = this.getContactById(Id);
	
		contact.setFirst_name(dto.first_name);
		contact.setLast_name(dto.last_name);
		contact.setEmail(dto.email);
		contact.setPhoneNumber(dto.phoneNumber);
		return repository.save(contact);
	}
	
	@Override
	public void deleteDataById(UUID Id) {
		Contact contact = this.getContactById(Id);
		repository.delete(contact);
		
	}
	
	
	public List<Address> addAddressToContact(String contactId, String addressId) {
		
		Address address = addressRepository.findById(UUID.fromString(addressId)).orElseThrow(()-> new AddressBookException("details not found!"));
	
		Contact contact=repository.findById(UUID.fromString(contactId)).orElseThrow(()-> new AddressBookException("details not found!"));
		List<Address> addresses = contact.getAddress();
		addresses.add(address);
		return repository.save(contact).getAddress();
		
		
	
	}
	

	@Override
	public List<Contact> sortContact() {
		
		return repository.SortingContactAsc();
		
		
	   
	}



}

package com.lande.WorkshopAddressBook.service;

import java.util.List;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.Address;

public interface AddressServiceInterface {
	
	public List<Address> getAllAddress();
	
	public Address getAddressById(int id );
	
	public Address createAddress(AddressDTO dto);

	public Address updatedataById(int Id,AddressDTO dto);
	
	public void deleteDataById(int Id);
	
	public List<Address> sortAddress();
}

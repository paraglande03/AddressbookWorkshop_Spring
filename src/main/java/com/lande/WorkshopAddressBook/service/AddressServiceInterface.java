package com.lande.WorkshopAddressBook.service;

import java.util.List;
import java.util.UUID;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.Address;

public interface AddressServiceInterface {
	
	public List<Address> getAllAddress();
	
	public Address getAddressById(UUID id );
	
	public Address createAddress(AddressDTO dto);

	public Address updatedataById(UUID Id,AddressDTO dto);
	
	public void deleteDataById(UUID Id);
	
	public List<Address> sortAddress();
}

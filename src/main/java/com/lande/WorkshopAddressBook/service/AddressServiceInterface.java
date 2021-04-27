package com.lande.WorkshopAddressBook.service;

import java.util.List;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.AddressData;

public interface AddressServiceInterface {
	
	public List<AddressData> getAllAddress();
	
	public AddressData getAddressById(int id );
	
	public AddressData createAddress(AddressDTO dto);

	public AddressData updatedataById(int Id,AddressDTO dto);
	
	public void deleteDataById(int Id);
}

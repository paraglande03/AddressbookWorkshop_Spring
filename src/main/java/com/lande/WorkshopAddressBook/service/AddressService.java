package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.AddressData;

@Service
public class AddressService implements AddressServiceInterface{
	
	List<AddressData> list = new ArrayList<>();
	
	public List<AddressData> getAllAddress(){
		return list;
	}

	@Override
	public AddressData createAddress(AddressDTO dto) {
		AddressData addressData = new AddressData(list.size()+1, dto);
		list.add(addressData);
		return addressData;
	}

	

}
